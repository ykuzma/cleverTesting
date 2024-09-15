package by.clevertec.car.controllers;

import by.clevertec.car.common.CarType;
import by.clevertec.car.domain.Car;
import by.clevertec.car.services.CarService;
import by.clevertec.car.util.TestHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    TypeReference<List<Car>> typeReference = new TypeReference<>() {
    };

    @Test
    void shouldGetCarsWithoutCriteria() throws Exception {
        //given
        List<Car> expectedCars = testHelper.getAllCars();
        when(carService.getCars(Mockito.any())).thenReturn(expectedCars);
        //when
        String contentAsString = mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<Car> actualCars = objectMapper.readValue(contentAsString, typeReference);
        //then
        assertThat(actualCars).isEqualTo(expectedCars);
    }
    @ParameterizedTest
    @EnumSource
    void shouldGetCarsByType(CarType carType) throws Exception {
        //given

        when(carService.getCars(Mockito.any())).thenReturn(
                testHelper.getCarsByType(carType, testHelper.getAllCars()));
        //when
        String contentAsString = mockMvc.perform(get("/cars?type={carType}", carType))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<Car> actualCars = objectMapper.readValue(contentAsString, typeReference);
        //then
        assertThat(actualCars).isNotEmpty().allMatch(car -> car.getCarType().equals(carType));
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
        Car createCar = testHelper.getRandomCar();
        when(carService.create(createCar)).thenReturn(createCar);
        //when, then
        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCar)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(createCar)));
   }

    @Test
    void shouldUpdateCar() throws Exception {
        //given
        UUID id = UUID.randomUUID();
        Car updateCar = testHelper.getAllCars().get(2);
        Car expectedCar = testHelper.getAllCars().get(3);
        when(carService.update(updateCar, id)).thenReturn(expectedCar);
        //when
        String contentAsString = mockMvc.perform(post("/cars/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateCar)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Car actualCar = objectMapper.readValue(contentAsString, Car.class);
          //then
        assertThat(actualCar).isEqualTo(expectedCar);
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