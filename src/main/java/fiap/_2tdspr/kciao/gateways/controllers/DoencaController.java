package fiap._2tdspr.kciao.gateways.controllers;

import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doenca")
public interface DoencaController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Optional<DoencaResponseDto>> getDoenca(@PathVariable @Valid String id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<DoencaResponseDto>> getAllDoenca();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<DoencaResponseDto> criarDoenca(@RequestBody @Valid DoencaRequestPostDto doenca);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Optional<DoencaResponseDto>> atualizarDoenca(@PathVariable @Valid String id, @RequestBody @Valid DoencaRequestPatchDto doencaRequestPatchDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarDoenca(@PathVariable @Valid String id);
}