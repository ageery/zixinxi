package com.zixinxi.web.wicket.component;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.minis.behavior.VisibleModelBehavior;

import com.zixinxi.web.wicket.model.EmptyStringModel;
import com.zixinxi.web.wicket.model.SupplierModel;

public class TitledPage extends BasePage {

	public TitledPage(PageParameters parameters) {
		super(parameters);
		add(new Label("header", getPageHeaderModel()));
		add(new Label("headerDescription", getDescriptionModel()));
		
		IModel<String> helpContentModel = new ResourceModel("page.help", EmptyStringModel.get()).wrapOnAssignment(this);
		Component helpPanel = new Label("helpContent", helpContentModel)
				.setOutputMarkupPlaceholderTag(true);
		add(helpPanel);
		IModel<Boolean> hasHelpContentModel = new SupplierModel<Boolean>(() -> 
				!StringUtils.isEmpty(helpContentModel.getObject()));

		add(new HelpCollapserLink("helpLink", new SupplierModel<>(() -> helpPanel.getMarkupId()))
				.add(new VisibleModelBehavior(hasHelpContentModel)));
	}
	
	protected IModel<String> getPageHeaderModel() {
		return new ResourceModel("page.header", getTitleModel());
	}
	
	protected IModel<String> getDescriptionModel() {
		return new ResourceModel("page.headerDescription", EmptyStringModel.get());
	}

}
