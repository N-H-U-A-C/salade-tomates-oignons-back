package fr.m2i.saladetomatesoignonsback.repository;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface AnimalRepository extends CrudRepository<Animal, UUID>, PagingAndSortingRepository<Animal, UUID> {
}
