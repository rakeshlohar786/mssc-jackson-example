package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscjacksonexamples.model.BeerDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println("Serialize");
        System.out.println(jsonString);
    }

    
    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2022-11-07T18:49:46+0530\",\"lastUpdatedDate\":\"2022-11-07T18:49:46.6987203+05:30\",\"myLocalDate\":\"20221107\",\"beerId\":\"658b61b8-aa66-481a-880a-179e7ee55762\"}\n"
        		;

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);
        System.out.println("Deserialize");
        System.out.println(dto);

    }
}