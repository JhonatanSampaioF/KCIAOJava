package fiap._2tdspr.kciao.gateways;

import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchNameDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPutDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doenca")
public interface DoencaController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> getDoenca(@PathVariable @Valid String id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> getAllDoenca();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<DoencaResponseDto> criarDoenca(@RequestBody @Valid DoencaRequestPostDto doenca);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> atualizarDoencaCompleta(@RequestBody @Valid @PathVariable String id, DoencaRequestPutDto doenca);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> atualizarDoencaParcial(@RequestBody @Valid @PathVariable String id, DoencaRequestPatchNameDto doenca);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<DoencaResponseDto> deletarDoenca(@PathVariable String id);
}
