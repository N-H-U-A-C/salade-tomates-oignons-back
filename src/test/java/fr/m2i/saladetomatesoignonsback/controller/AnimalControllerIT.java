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
import org.springframework.test.annotation.DirtiesContext;
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
                {
                 	"content": [
                 		{"id": "39adf80f-50da-4af9-bc82-b9a2892822c8", "label": "Agneau"},
                 		{"id": "a0fab814-cea4-4417-9a62-1929fef64a43", "label": "Bison"},
                 		{"id": "5e05a91f-94f2-4f61-8bd5-3539c6148cc1", "label": "Bœuf"},
                 		{"id": "02e875a0-72bf-4f19-8657-4e1d3325fc91", "label": "Canard"},
                 		{"id": "23b977a3-b3ba-40c5-ab3d-2af62a2a500f", "label": "Cerf"},
                 		{"id": "1a93aa6c-1d16-49df-a626-f56b7c0e709f", "label": "Cheval"},
                 		{"id": "c8a94fc5-311b-4a57-a77f-b85e47460708", "label": "Dinde"},
                 		{"id": "722c833b-791b-490d-8a6d-ce5ce755ce19", "label": "Faisan"},
                 		{"id": "ec834681-dbc3-400c-b7dd-5387d956f795", "label": "Grenouille"},
                 		{"id": "2eb1c5eb-d46e-481f-a18f-c520e8a40248", "label": "Huître"},
                 		{"id": "ca7597ca-0482-4919-8cfd-74d489805d77", "label": "Lapin"},
                 		{"id": "734595b8-a181-4b4c-a067-4c71f838911d", "label": "Moule"},
                 		{"id": "e0a4c668-4fa8-4eac-a482-9777126b009d", "label": "Mouton"},
                 		{"id": "7baa2d1d-45f0-48b4-91ab-da8b5a4bb92b", "label": "Oie"},
                 		{"id": "ec866d40-86ba-4a54-85da-cd435b4daf00", "label": "Pintade"},
                 		{"id": "6c6da8eb-7f4e-4c88-b190-7adf39156de7", "label": "Porc"},
                 		{"id": "8adcb6de-5db4-42cf-8cf9-056d3b702969", "label": "Poule"},
                 		{"id": "c2f4115f-7c8d-4b71-834f-9cc89205da06", "label": "Sanglier"},
                 		{"id": "84a3d090-98ec-434a-87fb-a63a265ed81f", "label": "Saumon"},
                 		{"id": "85166f35-482e-4a56-a8e6-10a779a63dd6", "label": "Truite"}
                 	],
                 	"pageable": {
                 		"pageNumber": 0,
                 		"pageSize": 20,
                 		"sort": {
                 			"empty": false,
                 			"sorted": true,
                 			"unsorted": false
                 		},
                 		"offset": 0,
                 		"paged": true,
                 		"unpaged": false
                 	},
                 	"size": 20,
                 	"number": 0,
                 	"sort": {
                 		"empty": false,
                 		"sorted": true,
                 		"unsorted": false
                 	},
                 	"numberOfElements": 20,
                 	"first": true,
                 	"last": false,
                 	"empty": false
                 }
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

    @DirtiesContext
    @Test
    public void save_Should_Return_Location() throws JSONException {
        // given
        Animal animal = new Animal("Gorille");

        // when
        ResponseEntity<String> response = restTemplate.postForEntity("/v1/animals", animal, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getHeaders().getLocation()).isNotNull();
    }

    @DirtiesContext
    @Test
    public void update_Should_Return_Location() throws JSONException {
        // given
        UUID id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969");
        Animal animal = new Animal(id,"Put test");
        String expected = """
                {"label": "Put test"}
                """;

        // when
        restTemplate.put("/v1/animals", animal, String.class);
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/animals/" + id, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    // TODO fix, always return 404 even if id exists
//    @DirtiesContext
//    @Test
//    public void deleteById_Should_Return_NOT_FOUND_If_Id_Doest_Not_Exist() throws JSONException {
//        // given
//        UUID id = UUID.fromString("9adcb6de-5db4-42cf-8cf9-056d3b702969");
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
