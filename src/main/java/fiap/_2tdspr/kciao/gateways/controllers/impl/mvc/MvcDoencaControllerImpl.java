package fiap._2tdspr.kciao.gateways.controllers.impl.mvc;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.mvc.MvcDoencaController;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudDoencaImpl;
import fiap._2tdspr.kciao.usecases.impl.CrudDoencaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view/doenca")
@RequiredArgsConstructor
public class MvcDoencaControllerImpl implements MvcDoencaController {

    private final CrudDoencaImpl crudDoenca;
    private final CrudDoencaImpl crudDoencaImpl;

    @GetMapping
    @Override
    public ModelAndView getAllDoenca() {
        ModelAndView modelAndView = new ModelAndView("doenca/list");
        modelAndView.addObject("doencas", crudDoenca.getAll());
        return modelAndView;
    }

    @GetMapping("/new")
    @Override
    public ModelAndView formNewDoenca() {
        ModelAndView modelAndView = new ModelAndView("doenca/create");
        modelAndView.addObject("doencaRequestDto", new DoencaRequestDto());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    @Override
    public ModelAndView formUpdateDoenca(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("doenca/edit");
        DoencaResponseDto doenca = crudDoenca.getOne(id);
        modelAndView.addObject("doencaEditDto", doenca);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @Override
    public ModelAndView confirmDelete(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("doenca/delete");
        modelAndView.addObject("doenca", crudDoenca.getOne(id));
        return modelAndView;
    }

    @PostMapping
    @Override
    public ModelAndView saveDoenca(DoencaRequestDto doencaRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("doenca/create")
                    .addObject("doencaRequestDto", doencaRequestDto);
        }

        crudDoenca.save(doencaRequestDto);
        return new ModelAndView("redirect:/view/doenca");
    }

    @PostMapping("/{id}")
    @Override
    public ModelAndView updateDoenca(@PathVariable String id, DoencaRequestDto doencaRequestDto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("doenca/edit")
                    .addObject("doencaEditDto", doencaRequestDto);
        }

        crudDoenca.update(id, doencaRequestDto);
        return new ModelAndView("redirect:/view/doenca");
    }

    @PostMapping("/delete/{id}")
    @Override
    public ModelAndView deleteDoenca(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do doenca não pode ser nulo ou vazio.");
        }
        crudDoenca.delete(id);
        return new ModelAndView("redirect:/view/doenca");
    }
}