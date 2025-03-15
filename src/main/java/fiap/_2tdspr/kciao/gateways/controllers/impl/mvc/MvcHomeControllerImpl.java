package fiap._2tdspr.kciao.gateways.controllers.impl.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcHomeControllerImpl {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }
}
