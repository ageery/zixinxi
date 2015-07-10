package com.zixinxi;

import static com.zixinxi.web.ZixinxiWebConstants.REST_PATH;
import static org.jooq.SQLDialect.POSTGRES_9_4;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.sql.DataSource;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zixinxi.domain.WicketProperties;
import com.zixinxi.repo.CedictWordRepo;
import com.zixinxi.repo.CedictWordRepoImpl;
import com.zixinxi.repo.TranscriptionRepo;
import com.zixinxi.repo.TranscriptionRepoImpl;
import com.zixinxi.repo.WordRepo;
import com.zixinxi.repo.WordRepoImpl;
import com.zixinxi.service.AppConfigService;
import com.zixinxi.service.AppConfigServiceImpl;
import com.zixinxi.service.TranscriptionService;
import com.zixinxi.service.TranscriptionServiceImpl;
import com.zixinxi.service.WordService;
import com.zixinxi.service.WordServiceImpl;
import com.zixinxi.web.wicket.app.ZiXinxiWebApp;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class ZiXinxiApp {

	@Inject
	private DataSource dataSource;
	@Inject
	private AppConfig appConfig;
	
    public static void main(String[] args) throws Exception {
    	SpringApplication app = new SpringApplication(ZiXinxiApp.class);
    	//app.addListeners(new ApplicationStartedListener());
    	app.run(args);
    }
    
    @Bean
    public ObjectMapper getObjectMapper() {
    	return new ObjectMapper();
    }
    
    @Bean
    public DSLContext getDslContext() {
    	return DSL.using(dataSource, POSTGRES_9_4);
    }
    
    @Bean
    public AppConfigService getAppConfigService() {
    	return new AppConfigServiceImpl(appConfig);
    }
    
    @Bean
    public WordRepo getWordDetailRepo() {
    	return new WordRepoImpl(getDslContext(), getObjectMapper());
    }
    
    @Bean
    public WordService getWordService() {
    	return new WordServiceImpl(getWordDetailRepo(), getCedictWordRepo());
    }
    
    @Bean
    public CedictWordRepo getCedictWordRepo() {
    	return new CedictWordRepoImpl(dataSource, System.getProperty("java.io.tmpdir"));
    }

    @Bean
    public TranscriptionRepo getTranscriptionRepo() {
    	return new TranscriptionRepoImpl(getDslContext());
    }
    
    @Bean
    public TranscriptionService getTranscriptionService() {
    	return new TranscriptionServiceImpl(getTranscriptionRepo());
    }
    
    @Bean
    @ConditionalOnProperty(prefix = "zixinxi", name = "refreshCedictDataAtStartup")
    public CedictDataRefreshRunner getCedictDataLoader() {
    	return new CedictDataRefreshRunner(getWordService());
    }
    
    @Bean
    public WicketProperties getWicketProperties() {
    	return new WicketProperties();
    }
    
    @Bean
    public FilterRegistrationBean getWicketFiler() {
    	FilterRegistrationBean registration = new FilterRegistrationBean();
    	WebApplication application = new ZiXinxiWebApp();
        WicketFilter wicketFilter = new WicketFilter(application);
        application.setConfigurationType(getWicketProperties().getConfiguration());
        wicketFilter.setFilterPath("/");
        registration.addInitParameter(WicketFilter.IGNORE_PATHS_PARAM, REST_PATH + "/*");
        registration.setFilter(wicketFilter);
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return registration;
    }
    
    @Bean
    public SessionTrackingConfigListener sessionTrackingConfigListener() {
    	return new SessionTrackingConfigListener();
    }
    
    private static class SessionTrackingConfigListener implements ServletContextInitializer {

		@Override
		public void onStartup(ServletContext servletContext) throws ServletException {
			servletContext.setSessionTrackingModes(new HashSet<>(Arrays.asList(SessionTrackingMode.COOKIE)));
		}
	
	}
    
}