package fiap._2tdspr.kciao.gateways.controllers.impl.mvc;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc.MvcEventoController;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudEventoImpl;
import fiap._2tdspr.kciao.usecases.impl.CrudDoencaImpl;
import fiap._2tdspr.kciao.usecases.interfaces.CrudCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view/evento")
@RequiredArgsConstructor
public class MvcEventoControllerImpl implements MvcEventoController {

    private final CrudEventoImpl crudEvento;
    private final CrudDoencaImpl crudDoencaImpl;
    private final CrudCliente crudCliente;

    @GetMapping
    @Override
    public ModelAndView getAllEvento() {
        ModelAndView modelAndView = new ModelAndView("evento/list");
        modelAndView.addObject("eventos", crudEvento.getAll());
        return modelAndView;
    }

    @GetMapping("/new")
    @Override
    public ModelAndView formNewEvento() {
        ModelAndView modelAndView = new ModelAndView("evento/create");
        modelAndView.addObject("eventoRequestDto", new EventoRequestPostDto());
        modelAndView.addObject("clientes", crudCliente.getAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    @Override
    public ModelAndView formUpdateEvento(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("evento/edit");
        EventoResponseDto evento = crudEvento.getOne(id);
        modelAndView.addObject("eventoEditDto", evento);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @Override
    public ModelAndView confirmDelete(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("evento/delete");
        modelAndView.addObject("evento", crudEvento.getOne(id));
        return modelAndView;
    }

    @PostMapping
    @Override
    public ModelAndView saveEvento(EventoRequestPostDto eventoRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("evento/create")
                    .addObject("eventoRequestDto", eventoRequestDto);
        }

        crudEvento.save(eventoRequestDto);
        return new ModelAndView("redirect:/view/evento");
    }

    @PostMapping("/{id}")
    @Override
    public ModelAndView updateEvento(@PathVariable String id, EventoRequestPatchDto eventoRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("evento/edit")
                    .addObject("eventoEditDto", eventoRequestDto);
        }

        crudEvento.update(id, eventoRequestDto);
        return new ModelAndView("redirect:/view/evento");
    }

    @PostMapping("/delete/{id}")
    @Override
    public ModelAndView deleteEvento(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do evento não pode ser nulo ou vazio.");
        }
        crudEvento.delete(id);
        return new ModelAndView("redirect:/view/evento");
    }
}