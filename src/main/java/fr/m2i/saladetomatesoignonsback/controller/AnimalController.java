package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import fr.m2i.saladetomatesoignonsback.business.service.AnimalService;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
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
@RequestMapping("/v1/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public ResponseEntity<List<AnimalDto>> getAllAnimalDto(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<AnimalDto> slice = animalService.getAllAnimalDto(pageRequest);
        return ResponseEntity.ok(slice.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> getAnimalDtoById(@PathVariable UUID id) {
        Optional<AnimalDto> optionalAnimalDto = animalService.getAnimalDtoById(id);
        return optionalAnimalDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Animal> save(@RequestBody Animal animal) {
        Animal savedAnimal = animalService.saveOrUpdate(animal);
        // create a 201 response with the location of the resource created as internet standard RFC 9110
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAnimal.getId()).toUri()).build();
    }

    @PutMapping()
    public ResponseEntity<Animal> update(@RequestBody Animal animal) {
        return ResponseEntity.ok(animalService.saveOrUpdate(animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        if (animalService.deleteById(id) > 0) {
            // create a 204 response with empty body as internet standard RFC 9110
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
