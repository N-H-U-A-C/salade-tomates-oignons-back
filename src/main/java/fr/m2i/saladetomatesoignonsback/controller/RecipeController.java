package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.business.service.RecipeService;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeShortDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/v1/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public ResponseEntity<Slice<RecipeDto>> getAllRecipeDto(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<RecipeDto> slice = recipeService.getAllRecipeDto(pageRequest);
        return ResponseEntity.ok(slice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeDtoById(@PathVariable @NotNull UUID id) {
        Optional<RecipeDto> optionalRecipeDto = recipeService.getRecipeDtoById(id);
        return optionalRecipeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@Valid @RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.saveOrUpdate(recipe);
        // create a 201 response with the location of the resource created as internet standard RFC 9110
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRecipe.getId()).toUri()).build();
    }

    @PutMapping()
    public ResponseEntity<Recipe> update(@Valid @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.saveOrUpdate(recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotNull UUID id) {
        if (recipeService.deleteById(id) > 0) {
            // create a 204 response with empty body as internet standard RFC 9110
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{accountId}/doable-recipes")
    public ResponseEntity<Slice<RecipeShortDto>> getAllDoableRecipesByAccountId(@PathVariable @NotNull UUID accountId, Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<RecipeShortDto> slice = recipeService.getAllDoableRecipesByAccountId(accountId, pageRequest);
        return ResponseEntity.ok(slice);
    }
}
