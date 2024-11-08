package fiap._2tdspr.kciao.gateways.controllers.interfaces;

import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doenca")
public interface DoencaController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void criarDoenca(@RequestBody @Valid DoencaRequestDto doenca);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void atualizarDoenca(@PathVariable @Valid Long id, @RequestBody @Valid DoencaRequestDto doencaRequestDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarDoenca(@PathVariable @Valid Long id);
}