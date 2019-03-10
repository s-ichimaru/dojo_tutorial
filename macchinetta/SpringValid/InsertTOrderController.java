package jp.co.infrontinc.studentManager.app.t_order.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import jp.co.infrontinc.studentManager.app.t_order.model.TOrderP;
import jp.co.infrontinc.studentManager.domain.t_order.model.TOrder;
import jp.co.infrontinc.studentManager.domain.t_order.service.TOrderService;

@Controller
@RequestMapping("t_order")
public class InsertTOrderController {

	@Inject
	private TOrderService tOrderService;

	@Inject
	private TOrderPHelper tOrderPHelper;

	@Inject
	private TOrderPValidator tOrderPValidator;


	@ModelAttribute("TOrderP")
	public TOrderP setupForm() {
		return new TOrderP();
	}

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(tOrderPValidator);
    }

	@GetMapping("insert")
	public String do_show(TOrderP tOrderP) {
		return "t_order/insertTOrder";
	}

	@PostMapping("insert")
	public String do_insert(@Validated TOrderP tOrderP,
			BindingResult result,
			RedirectAttributes attributes,
			Model model) {

		if (result.hasErrors()) {

//		    ResultMessages messages = ResultMessages.warn().add(ResultMessage.fromText("入力値が不正です"));
//		    model.addAttribute(messages);

			return "t_order/insertTOrder";
		}

		TOrder entity = tOrderPHelper.p2s(tOrderP, TOrder.class);

		tOrderService.insert(entity);

		attributes.addFlashAttribute(ResultMessages.success().add(
				ResultMessage.fromText("登録が完了しました。")));

		return "redirect:/t_order/insert";
	}
}
