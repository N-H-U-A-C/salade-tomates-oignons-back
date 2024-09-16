package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.service.AnimalService;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(AnimalController.class)
class AnimalControllerTest {

    @Autowired
    private AnimalController classUnderTest;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AnimalService animalService;
    private PageRequest defaultPageRequest;
    private UUID id;
    @Captor
    private ArgumentCaptor<PageRequest> pageRequestCaptor;
    @Captor ArgumentCaptor<UUID> uuidCaptor;
    private Slice<AnimalDto> slice;
    private Optional<AnimalDto> optionalAnimalDto;

    @BeforeEach
    public void setUp() {
        defaultPageRequest = PageRequest.of(0, 20, Sort.Direction.ASC, "label");
        id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702777");
        slice = new SliceImpl<>(List.of(
                new AnimalDto("Test"),
                new AnimalDto("Ok")));
        optionalAnimalDto = Optional.of(new AnimalDto("Toto"));
    }

    @Test
    public void should_Call_GetAllAnimalDto_Of_AnimalService() {
        // given
        when(animalService.getAllAnimalDto(defaultPageRequest)).thenReturn(slice);

        // when
        classUnderTest.getAllAnimalDto(defaultPageRequest);

        // then
        verify(animalService).getAllAnimalDto(defaultPageRequest);
    }

    @Test
    public void pageRequest_Should_Be_First_Page_Of_20_AnimalsDto_Sorted_By_Asc_Label() throws Exception {
        // given
        when(animalService.getAllAnimalDto(defaultPageRequest)).thenReturn(slice);

        // when
        mockMvc.perform(get("/v1/animals"));

        // then
        verify(animalService).getAllAnimalDto(pageRequestCaptor.capture());
        PageRequest usedPageRequest = pageRequestCaptor.getValue();
        assertThat(usedPageRequest).isEqualTo(defaultPageRequest);
    }

    @Test
    public void pageRequest_Should_Be_Second_Page_Of_AnimalsDto() throws Exception {
        // given
        PageRequest secondPage = PageRequest.of(1, 20, Sort.Direction.ASC, "label");
        when(animalService.getAllAnimalDto(secondPage)).thenReturn(slice);

        // when
        mockMvc.perform(get("/v1/animals?page=1"));

        // then
        verify(animalService).getAllAnimalDto(pageRequestCaptor.capture());
        PageRequest usedPageRequest = pageRequestCaptor.getValue();
        assertThat(usedPageRequest).isEqualTo(secondPage);
    }

    @Test
    public void pageRequest_Should_Be_Page_Of_5_AnimalsDto() throws Exception {
        // given
        PageRequest pageOf5AnimalDto = PageRequest.of(0, 5, Sort.Direction.ASC, "label");
        when(animalService.getAllAnimalDto(pageOf5AnimalDto)).thenReturn(slice);

        // when
        mockMvc.perform(get("/v1/animals?size=5"));

        // then
        verify(animalService).getAllAnimalDto(pageRequestCaptor.capture());
        PageRequest usedPageRequest = pageRequestCaptor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageOf5AnimalDto);
    }

    @Test
    public void pageRequest_Should_Be_Page_Of_AnimalsDto_Sorted_By_Desc_Label() throws Exception {
        // given
        PageRequest pageSortedByDescLabel = PageRequest.of(0, 20, Sort.Direction.DESC, "label");
        when(animalService.getAllAnimalDto(pageSortedByDescLabel)).thenReturn(slice);

        // when
        mockMvc.perform(get("/v1/animals?sort=label,desc"));

        // then
        verify(animalService).getAllAnimalDto(pageRequestCaptor.capture());
        PageRequest usedPageRequest = pageRequestCaptor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageSortedByDescLabel);
    }

    @Test
    public void should_Call_GetAnimalDtoById_Of_AnimalService() {
        // given
        when(animalService.getAnimalDtoById(id)).thenReturn(optionalAnimalDto);

        // when
        classUnderTest.getAnimalDtoById(id);

        // then
        verify(animalService).getAnimalDtoById(id);
    }

    @Test
    public void id_Should_Be_8adcb6de_5db4_42cf_8cf9_056d3b702777() throws Exception {
        // given
        when(animalService.getAnimalDtoById(id)).thenReturn(optionalAnimalDto);

        // when
        mockMvc.perform(get("/v1/animals/8adcb6de-5db4-42cf-8cf9-056d3b702777"));

        // then
        verify(animalService).getAnimalDtoById(uuidCaptor.capture());
        UUID usedId = uuidCaptor.getValue();
        assertThat(usedId).isEqualTo(id);
    }
}
