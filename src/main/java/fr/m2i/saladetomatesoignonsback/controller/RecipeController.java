package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.business.service.RecipeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<Recipe> slice = recipeService.getAll(pageRequest);
        return ResponseEntity.ok(slice.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable UUID id) {
        Optional<Recipe> optionalRecipe = recipeService.getById(id);
        return optionalRecipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.saveOrUpdate(recipe);
        // create a 201 response with the location of the resource created as internet standard RFC 9110
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRecipe.getId()).toUri()).build();
    }

    @PutMapping()
    public ResponseEntity<Recipe> update(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.saveOrUpdate(recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        if (recipeService.deleteById(id) > 0) {
            // create a 204 response with empty body as internet standard RFC 9110
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
