package by.clevertec.car.controllers;

import by.clevertec.car.domain.Car;
import by.clevertec.car.services.CarService;
import by.clevertec.car.util.TestHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @MockBean
    CarService carService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    TestHelper testHelper = new TestHelper();


    @Test
    void shouldGetCars() throws Exception {
        //given
        int expectedValue = testHelper.getAllCars().size();
        when(carService.getCars()).thenReturn(testHelper.getAllCars());
        //when, then
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(expectedValue));
    }

    @Test
    void shouldGetCarById() throws Exception {
        //given
        UUID id = UUID.nameUUIDFromBytes("3".getBytes());
        Car expectedCar = testHelper.getCarById(id);
        when(carService.getCarById(id)).thenReturn(expectedCar);
        //when
        String contentAsString = mockMvc.perform(get("/cars/{id}", id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Car actualCar = objectMapper.readValue(contentAsString, Car.class);
        //then
        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void shouldCreateCar() throws Exception {
        //given
        Car createCar = testHelper.getAllCars().get(3);
        when(carService.create(createCar)).thenReturn(createCar);
        //when
        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(createCar)))
                .andExpect(status().isOk());

        //then
    }

    @Test
    void shouldDeleteCarById() throws Exception {
        //given
        UUID id = UUID.randomUUID();
        //when. then
        mockMvc.perform(delete("/cars/{id}", id))
                .andExpect(status().isOk());
    }


}