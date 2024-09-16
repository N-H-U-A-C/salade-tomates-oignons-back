package fr.m2i.saladetomatesoignonsback.business.service.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JsonTest
class AnimalDtoDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private AnimalDto animalDto;
    private String animalDtoJson;
    private AnimalDto[] animalDtoArray;
    private String animalDtoArrayJson;

    @BeforeEach
    public void setUp() {
        animalDto = new AnimalDto("Dummy");
        animalDtoJson = """
                {
                  "label": "Dummy"
                }
                """;
        animalDtoArray = Arrays.array(
                new AnimalDto("Test"),
                new AnimalDto("Ok"));
        animalDtoArrayJson = """
                [
                  {"label": "Test"},
                  {"label": "Ok"}
                ]
                """;
    }

    @Test
    public void animalDtoShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(animalDto);
        System.out.println(result);

        // then
        JSONAssert.assertEquals(animalDtoJson, result, false);
    }

    @Test
    public void animalDtoShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        AnimalDto result = this.objectMapper.readValue(animalDtoJson, AnimalDto.class);

        // then
        assertThat(result).isEqualTo(animalDto);
    }

    @Test
    public void animalDtoArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(animalDtoArray);

        // then
        JSONAssert.assertEquals(animalDtoArrayJson, result, true);
    }

    @Test
    public void animalDtoArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        AnimalDto[] result = this.objectMapper.readValue(animalDtoArrayJson, AnimalDto[].class);

        // then
        assertThat(result).isEqualTo(animalDtoArray);
    }
}