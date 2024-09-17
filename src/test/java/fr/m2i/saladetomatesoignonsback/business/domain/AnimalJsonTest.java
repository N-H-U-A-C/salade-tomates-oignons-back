package fr.m2i.saladetomatesoignonsback.business.domain;

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
class AnimalJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private Animal animal;
    private String animalJson;
    private Animal[] animalArray;
    private String animalArrayJson;

    @BeforeEach
    public void setUp() {
        animal = new Animal(UUID.fromString("1cb41691-3282-42e8-adcd-89731e6b51f5"), "Dummy");
        animalJson = """
                {
                  "id": "1cb41691-3282-42e8-adcd-89731e6b51f5",
                  "label": "Dummy"
                }
                """;
        animalArray = Arrays.array(
                new Animal(UUID.fromString("1cb41691-3282-42e8-adcd-89731e6b51f5"), "Test"),
                new Animal(UUID.fromString("5386afaf-925e-47d0-8abc-0703a7ad879a"), "Ok"));
        animalArrayJson = """
                [
                  {"id": "1cb41691-3282-42e8-adcd-89731e6b51f5", "label": "Test"},
                  {"id": "5386afaf-925e-47d0-8abc-0703a7ad879a", "label": "Ok"}
                ]
                """;
    }

    @Test
    public void animalShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(animal);
        System.out.println(result);

        // then
        JSONAssert.assertEquals(animalJson, result, false);
    }

    @Test
    public void animalShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Animal result = this.objectMapper.readValue(animalJson, Animal.class);

        // then
        assertThat(result).isEqualTo(animal);
    }

    @Test
    public void animalArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(animalArray);

        // then
        JSONAssert.assertEquals(animalArrayJson, result, true);
    }

    @Test
    public void animalArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Animal[] result = this.objectMapper.readValue(animalArrayJson, Animal[].class);

        // then
        assertThat(result).isEqualTo(animalArray);
    }
}
