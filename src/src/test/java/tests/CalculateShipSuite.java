package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.CalculateShipService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalculateShipSuite {

    private static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of(null,false,false,"hight","distance"),
                Arguments.of(2,null,false,"hight","size"),
                Arguments.of(2,false,null,"hight","fragility"),
                Arguments.of(2,false,false,null,"load")
        );
    }

    @ParameterizedTest(name = "Вызов рассчета стоимости с передачей невалидного параметра {4}")
    @MethodSource("invalidArguments")
    void testCheckEmptyParams(Integer distance, Boolean size, Boolean fragility , String load, String param)  {

        Throwable exception = assertThrows(RuntimeException.class,
                ()-> CalculateShipService.calcShipCost(distance,size,fragility,load), "Класс ошибки отличается от ожидаемого");

        Assertions.assertEquals("missing required parameter - " + param, exception.getMessage());

        }


    @Test
    @DisplayName("Проверка рассчета минимальной стоимости доставки")
    void testCheckPriceLowMin()  {

        var result = CalculateShipService.calcShipCost(2,false,false,"normal");

        Assertions.assertEquals(400,result,"Минимальная стоимость доставки != 400");

    }

    @Test
    @DisplayName("Проверка расчета максимальной стоимости доставки")
    void testCheckMaxCost()  {

        var result = CalculateShipService.calcShipCost(31,true,false,"very high");

        Assertions.assertEquals(1280,result,"Cтоимость доставки != 400");

    }

    @Test
    @DisplayName("Проверка запрета перевозки хрупкого груза на расстояние более 30 км")
    void testCheckRestrictShipForFragility()  {

        Throwable exception = assertThrows(RuntimeException.class,
                ()-> CalculateShipService.calcShipCost(31,true,true,"normal"), "Класс ошибки отличается от ожидаемого");

        Assertions.assertEquals("Хрупкие грузы нельзя возить на расстояние более 30 км" , exception.getMessage());

    }

    @DisplayName("Проверка расчета стомости за доставку хрупкого груза на расстояние <= 30 км")
    @Test
    void testCheckValidFragility(){

        var result = CalculateShipService.calcShipCost(30,false,true,"normal");

        Assertions.assertEquals(600,result,"Цена доставки за хрупкий груз отличается от ожидамемой");

    }
}






