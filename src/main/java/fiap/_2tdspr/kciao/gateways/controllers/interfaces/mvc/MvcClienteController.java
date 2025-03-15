package fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc;

import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface MvcClienteController {

    ModelAndView getAllClient();
    ModelAndView formNewClient();
    ModelAndView formUpdateClient(String id);
    ModelAndView confirmDelete(String id);
    ModelAndView saveClient(ClienteRequestDto clienteRequestDto, BindingResult result);
    ModelAndView updateClient(String id, ClienteRequestDto clienteRequestDto, BindingResult result);
    ModelAndView deleteClient(String id);
}