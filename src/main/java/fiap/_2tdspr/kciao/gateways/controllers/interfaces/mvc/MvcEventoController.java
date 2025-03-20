package fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc;

import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface MvcEventoController {
    ModelAndView getAllEvento();
    ModelAndView formNewEvento();
    ModelAndView formUpdateEvento(String id);
    ModelAndView confirmDelete(String id);
    ModelAndView saveEvento(EventoRequestPostDto eventoRequestPostDto, BindingResult result);
    ModelAndView updateEvento(String id, EventoRequestPatchDto eventoRequestPatchDto, BindingResult result);
    ModelAndView deleteEvento(String id);
    
}
