package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Unit;
import fr.m2i.saladetomatesoignonsback.business.service.UnitService;
import fr.m2i.saladetomatesoignonsback.business.service.dto.UnitDto;
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
@RequestMapping("/v1/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping()
    public ResponseEntity<Slice<UnitDto>> getAllUnitDto(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "label"))
        );
        Slice<UnitDto> slice = unitService.getAllUnitDto(pageRequest);
        return ResponseEntity.ok(slice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> getUnitDtoById(@PathVariable @NotNull UUID id) {
        Optional<UnitDto> optionalUnitDto = unitService.getUnitDtoById(id);
        return optionalUnitDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody Unit unit) {
        Unit savedUnit = unitService.saveOrUpdate(unit);
        // create a 201 response with the location of the resource created as internet standard RFC 9110
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUnit.getId()).toUri()).build();
    }

    @PutMapping()
    public ResponseEntity<Unit> update(@Valid @RequestBody Unit unit) {
        return ResponseEntity.ok(unitService.saveOrUpdate(unit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotNull UUID id) {
        if (unitService.deleteById(id) > 0) {
            // create a 204 response with empty body as internet standard RFC 9110
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
