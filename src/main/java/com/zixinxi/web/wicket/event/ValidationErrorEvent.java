package com.zixinxi.web.wicket.event;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.wicketstuff.event.annotation.AbstractAjaxAwareEvent;

public class ValidationErrorEvent extends AbstractAjaxAwareEvent {

	public ValidationErrorEvent(AjaxRequestTarget target) {
		super(target);
	}

}
