package fr.m2i.saladetomatesoignonsback.repository;

import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AnimalRepositoryTest {

    // TODO add 2 tests for getAnimalDtoById and customDeleteById
//    @Autowired
//    private AnimalRepository classUnderTest;
//
//    @Test
//    public void should_Return_First_Slice_Of_20_Animals_Dto_Sorted_By_Asc_Label() {
//        // given
//        Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "label"));
//        List<AnimalDto> expected = List.of(
//                new AnimalDto("Agneau"),
//                new AnimalDto("Bison"),
//                new AnimalDto("Bœuf"),
//                new AnimalDto("Canard"),
//                new AnimalDto("Cerf"),
//                new AnimalDto("Cheval"),
//                new AnimalDto("Dinde"),
//                new AnimalDto("Faisan"),
//                new AnimalDto("Huître"),
//                new AnimalDto("Grenouille"),
//                new AnimalDto("Moule"),
//                new AnimalDto("Lapin"),
//                new AnimalDto("Mouton"),
//                new AnimalDto("Oie"),
//                new AnimalDto("Porc"),
//                new AnimalDto("Pintade"),
//                new AnimalDto("Poule"),
//                new AnimalDto("Sanglier"),
//                new AnimalDto("Saumon"),
//                new AnimalDto("Truite")
//        );
//
//        // when
//        Slice<AnimalDto> result = classUnderTest.findAllAnimalDto(pageable);
//
//        // then
//        assertThat(result.getContent()).isEqualTo(expected);
//    }
}
