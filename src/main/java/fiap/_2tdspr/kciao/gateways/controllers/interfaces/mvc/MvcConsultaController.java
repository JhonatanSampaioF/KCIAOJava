package fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc;

import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPostDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface MvcConsultaController {
    ModelAndView getAllConsulta();
    ModelAndView formNewConsulta();
    ModelAndView formUpdateConsulta(String id);
    ModelAndView confirmDelete(String id);
    ModelAndView saveConsulta(ConsultaWithEventoRequestPostDto consultaRequestDto, BindingResult result);
    ModelAndView updateConsulta(String id, ConsultaWithEventoRequestPatchDto consultaRequestDto, BindingResult result);
    ModelAndView deleteConsulta(String id);
}
