package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.IngredientService;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping()
    public ResponseEntity<Slice<IngredientDto>> getAllIngredientDto(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<IngredientDto> slice = ingredientService.getAllIngredientDto(pageRequest);
        return ResponseEntity.ok(slice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDto> getIngredientDtoById(@PathVariable UUID id) {
        Optional<IngredientDto> optionalIngredient = ingredientService.getIngredientDtoById(id);
        return optionalIngredient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.saveOrUpdate(ingredient);
        // create a 201 response with the location of the resource created as internet standard RFC 9110
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedIngredient.getId()).toUri()).build();
    }

    @PutMapping()
    public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.saveOrUpdate(ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        if (ingredientService.deleteById(id) > 0) {
            // create a 204 response with empty body as internet standard RFC 9110
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{accountId}/fridge-ingredients")
    public ResponseEntity<Slice<IngredientFridgeDto>> getFridgeByAccountId(@PathVariable UUID accountId, Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<IngredientFridgeDto> slice = ingredientService.getFridgeByAccountId(accountId, pageRequest);
        return ResponseEntity.ok(slice);
    }
}
