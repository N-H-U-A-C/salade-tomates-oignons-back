package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnimalControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void getAllAnimalDto_Should_Return_First_Slice_Of_20_AnimalDto_Sorted_By_Asc_Name() throws JSONException {
        // given
        String expected = """
                [
                {"label": "Agneau"},
                {"label": "Bison"},
                {"label": "Bœuf"},
                {"label": "Canard"},
                {"label": "Cerf"},
                {"label": "Cheval"},
                {"label": "Dinde"},
                {"label": "Faisan"},
                {"label": "Grenouille"},
                {"label": "Huître"},
                {"label": "Lapin"},
                {"label": "Moule"},
                {"label": "Mouton"},
                {"label": "Oie"},
                {"label": "Pintade"},
                {"label": "Porc"},
                {"label": "Poule"},
                {"label": "Sanglier"},
                {"label": "Saumon"},
                {"label": "Truite"}
                ]
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/animals", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals(expected, response.getBody(), true);
    }

    @Test
    public void getAnimalDtoById_Should_Return_Optional_Of_AnimalDto() throws JSONException {
        // given
        String expected = """
                {"label": "Poule"}
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/animals/8adcb6de-5db4-42cf-8cf9-056d3b702969", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void getAnimalDtoById_Should_Not_Return_Optional_Of_AnimalDto() throws JSONException {
        // given

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/animals/9adcb6de-5db4-42cf-8cf9-056d3b702969", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }

//    @Test
//    public void save_Should_Return_Location() throws JSONException {
//        // given
//        Animal animal = new Animal("Gorille");
//
//        // when
//        ResponseEntity<String> response = restTemplate.postForEntity("/v1/animals", animal, String.class);
//
//        // then
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        assertThat(response.getHeaders().getLocation()).isNotNull();
//    }

//    @Test
//    public void update_Should_Return_Location() throws JSONException {
//        // given
//        UUID id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969");
//        Animal animal = new Animal(id,"Put test");
//        String expected = """
//                {"label": "Put test"}
//                """;
//
//        // when
//        restTemplate.put("/v1/animals", animal, String.class);
//        ResponseEntity<String> response = restTemplate.getForEntity("/v1/animals/" + id, String.class);
//
//        // then
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        JSONAssert.assertEquals(expected, response.getBody(), false);
//    }

//    @Test
//    public void deleteById_Should_Return_NOT_FOUND() throws JSONException {
//        // given
//        UUID id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969");
//
//        // when
//        restTemplate.delete("/v1/animals/" + id);
//
//        // then
//        try {
//            restTemplate.getForObject("/v1/animals/" + id, Animal.class);
//        } catch (final HttpClientErrorException e) {
//            assertThat(e.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//        }
//    }
}
