package fiap._2tdspr.kciao.gateways.controllers.interfaces;

import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface DoencaController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> getDoenca(@PathVariable @Valid String id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<DoencaResponseDto>> getAllDoenca();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<DoencaResponseDto> criarDoenca(@RequestBody @Valid DoencaRequestDto doenca);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> atualizarDoenca(@PathVariable @Valid String id, @RequestBody @Valid DoencaRequestDto doencaRequestDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarDoenca(@PathVariable @Valid String id);
}