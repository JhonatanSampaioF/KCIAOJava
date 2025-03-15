package fiap._2tdspr.kciao.gateways.controllers.impl.mvc;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc.MvcClienteController;
import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudClienteImpl;
import fiap._2tdspr.kciao.usecases.impl.CrudDoencaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/view/cliente")
@RequiredArgsConstructor
public class MvcClienteControllerImpl implements MvcClienteController {

    private final CrudClienteImpl crudCliente;
    private final CrudDoencaImpl crudDoencaImpl;

    @GetMapping
    @Override
    public ModelAndView getAllClient() {
        ModelAndView modelAndView = new ModelAndView("cliente/list");
        modelAndView.addObject("clientes", crudCliente.getAll());
        return modelAndView;
    }

    @GetMapping("/new")
    @Override
    public ModelAndView formNewClient() {
        ModelAndView modelAndView = new ModelAndView("cliente/create");
        modelAndView.addObject("clienteRequestDto", new ClienteRequestDto());
        modelAndView.addObject("doencas", crudDoencaImpl.getAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    @Override
    public ModelAndView formUpdateClient(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("cliente/edit");
        ClienteResponseDto cliente = crudCliente.getOne(id);
        if (cliente.getDoencas() == null) {
            cliente.setDoencas(new ArrayList<>());
        }
        modelAndView.addObject("clienteEditDto", cliente);
        modelAndView.addObject("doencas", crudDoencaImpl.getAll());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @Override
    public ModelAndView confirmDelete(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("cliente/delete");
        modelAndView.addObject("cliente", crudCliente.getOne(id));
        return modelAndView;
    }

    @PostMapping
    @Override
    public ModelAndView saveClient(ClienteRequestDto clienteRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("cliente/create")
                    .addObject("clienteRequestDto", clienteRequestDto);
        }

        crudCliente.save(clienteRequestDto);
        return new ModelAndView("redirect:/view/cliente");
    }

    @PostMapping("/{id}")
    @Override
    public ModelAndView updateClient(@PathVariable String id, ClienteRequestDto clienteRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("cliente/edit")
                    .addObject("clienteEditDto", clienteRequestDto);
        }

        crudCliente.update(id, clienteRequestDto);
        return new ModelAndView("redirect:/view/cliente");
    }

    @PostMapping("/delete/{id}")
    @Override
    public ModelAndView deleteClient(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do cliente não pode ser nulo ou vazio.");
        }
        crudCliente.delete(id);
        return new ModelAndView("redirect:/view/cliente");
    }
}