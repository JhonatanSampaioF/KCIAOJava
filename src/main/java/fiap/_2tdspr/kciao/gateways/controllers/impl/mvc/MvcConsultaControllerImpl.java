package fiap._2tdspr.kciao.gateways.controllers.impl.mvc;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc.MvcConsultaController;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudConsultaImpl;
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
@RequestMapping("/view/consulta")
@RequiredArgsConstructor
public class MvcConsultaControllerImpl implements MvcConsultaController {

    private final CrudConsultaImpl crudConsulta;
    private final CrudDoencaImpl crudDoencaImpl;
    private final CrudCliente crudCliente;

    @GetMapping
    @Override
    public ModelAndView getAllConsulta() {
        ModelAndView modelAndView = new ModelAndView("consulta/list");
        modelAndView.addObject("consultas", crudConsulta.getAll());
        return modelAndView;
    }

    @GetMapping("/new")
    @Override
    public ModelAndView formNewConsulta() {
        ModelAndView modelAndView = new ModelAndView("consulta/create");
        modelAndView.addObject("consultaRequestDto", new ConsultaWithEventoRequestPostDto());
        modelAndView.addObject("clientes", crudCliente.getAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    @Override
    public ModelAndView formUpdateConsulta(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("consulta/edit");
        ConsultaResponseDto consulta = crudConsulta.getOne(id);
        modelAndView.addObject("consultaEditDto", consulta);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @Override
    public ModelAndView confirmDelete(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("consulta/delete");
        modelAndView.addObject("consulta", crudConsulta.getOne(id));
        return modelAndView;
    }

    @PostMapping
    @Override
    public ModelAndView saveConsulta(ConsultaWithEventoRequestPostDto consultaRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("consulta/create")
                    .addObject("consultaRequestDto", consultaRequestDto);
        }

        crudConsulta.saveWithEvento(consultaRequestDto);
        return new ModelAndView("redirect:/view/consulta");
    }

    @PostMapping("/{id}")
    @Override
    public ModelAndView updateConsulta(@PathVariable String id, ConsultaWithEventoRequestPatchDto consultaRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("consulta/edit")
                    .addObject("consultaEditDto", consultaRequestDto);
        }

        crudConsulta.updateWithEvento(id, consultaRequestDto);
        return new ModelAndView("redirect:/view/consulta");
    }

    @PostMapping("/delete/{id}")
    @Override
    public ModelAndView deleteConsulta(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do consulta não pode ser nulo ou vazio.");
        }
        crudConsulta.delete(id);
        return new ModelAndView("redirect:/view/consulta");
    }
}