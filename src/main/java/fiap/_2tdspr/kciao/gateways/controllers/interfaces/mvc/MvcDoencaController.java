package fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc;

import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface MvcDoencaController {
    ModelAndView getAllDoenca();
    ModelAndView formNewDoenca();
    ModelAndView formUpdateDoenca(String id);
    ModelAndView confirmDelete(String id);
    ModelAndView saveDoenca(DoencaRequestDto doencaRequestDto, BindingResult result);
    ModelAndView updateDoenca(String id, DoencaRequestDto doencaRequestDto, BindingResult result);
    ModelAndView deleteDoenca(String id);
}
