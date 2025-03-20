package fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc;

import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface MvcClienteController {

    ModelAndView getAllCliente();
    ModelAndView formNewCliente();
    ModelAndView formUpdateCliente(String id);
    ModelAndView confirmDelete(String id);
    ModelAndView saveCliente(ClienteRequestDto clienteRequestDto, BindingResult result);
    ModelAndView updateCliente(String id, ClienteRequestDto clienteRequestDto, BindingResult result);
    ModelAndView deleteCliente(String id);
}