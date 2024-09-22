package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository classUnderTest;

    @Test
    public void should_Return_First_Slice_Of_20_Animals_Dto_Sorted_By_Asc_Label() {
        // given
        Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "label"));
        List<AnimalDto> expected = List.of(
                new AnimalDto(UUID.fromString("39adf80f-50da-4af9-bc82-b9a2892822c8"), "Agneau"),
                new AnimalDto(UUID.fromString("a0fab814-cea4-4417-9a62-1929fef64a43"), "Bison"),
                new AnimalDto(UUID.fromString("5e05a91f-94f2-4f61-8bd5-3539c6148cc1"), "Bœuf"),
                new AnimalDto(UUID.fromString("02e875a0-72bf-4f19-8657-4e1d3325fc91"), "Canard"),
                new AnimalDto(UUID.fromString("23b977a3-b3ba-40c5-ab3d-2af62a2a500f"), "Cerf"),
                new AnimalDto(UUID.fromString("1a93aa6c-1d16-49df-a626-f56b7c0e709f"), "Cheval"),
                new AnimalDto(UUID.fromString("c8a94fc5-311b-4a57-a77f-b85e47460708"), "Dinde"),
                new AnimalDto(UUID.fromString("722c833b-791b-490d-8a6d-ce5ce755ce19"), "Faisan"),
                new AnimalDto(UUID.fromString("ec834681-dbc3-400c-b7dd-5387d956f795"), "Grenouille"),
                new AnimalDto(UUID.fromString("2eb1c5eb-d46e-481f-a18f-c520e8a40248"), "Huître"),
                new AnimalDto(UUID.fromString("ca7597ca-0482-4919-8cfd-74d489805d77"), "Lapin"),
                new AnimalDto(UUID.fromString("734595b8-a181-4b4c-a067-4c71f838911d"), "Moule"),
                new AnimalDto(UUID.fromString("e0a4c668-4fa8-4eac-a482-9777126b009d"), "Mouton"),
                new AnimalDto(UUID.fromString("7baa2d1d-45f0-48b4-91ab-da8b5a4bb92b"), "Oie"),
                new AnimalDto(UUID.fromString("ec866d40-86ba-4a54-85da-cd435b4daf00"), "Pintade"),
                new AnimalDto(UUID.fromString("6c6da8eb-7f4e-4c88-b190-7adf39156de7"), "Porc"),
                new AnimalDto(UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969"), "Poule"),
                new AnimalDto(UUID.fromString("c2f4115f-7c8d-4b71-834f-9cc89205da06"), "Sanglier"),
                new AnimalDto(UUID.fromString("84a3d090-98ec-434a-87fb-a63a265ed81f"), "Saumon"),
                new AnimalDto(UUID.fromString("85166f35-482e-4a56-a8e6-10a779a63dd6"), "Truite")
        );

        // when
        Slice<AnimalDto> result = classUnderTest.findAllAnimalDto(pageable);

        // then
        assertThat(result.getContent()).isEqualTo(expected);
    }

    @Test
    public void findAnimalDtoById_Should_Return_Optional_Of_AnimalDto_If_Id_Exists() {
        // given
        UUID id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969");
        AnimalDto expected = new AnimalDto(UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969"), "Poule");

        // when
        Optional<AnimalDto> result = classUnderTest.findAnimalDtoById(id);

        // then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(expected);
    }

    @Test
    public void findAnimalDtoById_Should_Not_Return_Optional_Of_AnimalDto_If_Id_Does_Not_Exist() {
        // given
        UUID id = UUID.fromString("9adcb6de-5db4-42cf-8cf9-056d3b702969");

        // when
        Optional<AnimalDto> result = classUnderTest.findAnimalDtoById(id);

        // then
        assertThat(result.isPresent()).isFalse();
    }

    @DirtiesContext
    @Test
    public void customDeleteById_Should_Return_1_If_Id_Exists() {
        // given
        UUID id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969");
        int expected = 1;

        // when
        int result = classUnderTest.customDeleteById(id);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DirtiesContext
    @Test
    public void customDeleteById_Should_Return_0_If_Id_Does_Not_Exist() {
        // given
        UUID id = UUID.fromString("9adcb6de-5db4-42cf-8cf9-056d3b702969");
        int expected = 0;

        // when
        int result = classUnderTest.customDeleteById(id);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
