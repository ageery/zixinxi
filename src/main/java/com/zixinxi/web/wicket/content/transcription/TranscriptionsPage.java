package com.zixinxi.web.wicket.content.transcription;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

import com.zixinxi.web.wicket.component.BasePage;

@MountPath("/transcriptions")
public class TranscriptionsPage extends BasePage {
	
	public TranscriptionsPage(PageParameters parameters) {
		super(parameters);
		add(new TranscriptionsPanel("panel"));
	}

}
