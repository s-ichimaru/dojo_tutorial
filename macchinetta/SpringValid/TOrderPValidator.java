package jp.co.infrontinc.studentManager.app.t_order.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.infrontinc.studentManager.app.t_order.model.TOrderP;

@Component
public class TOrderPValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TOrderP.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasFieldErrors("inputFrom")) {
			return;
		}
		if (errors.hasFieldErrors("inputTo")) {
			return;
		}

		TOrderP tOrderP = (TOrderP) target;

		if (tOrderP.getInputFrom().getTime() > tOrderP.getInputTo().getTime()) {
			errors.rejectValue("inputFrom", "", "日付エラー");
			errors.rejectValue("inputTo", "", "日付エラー");
		}
	}

}
