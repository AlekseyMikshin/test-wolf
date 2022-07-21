import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainClass {

    @Test
    void test() throws Exception {
        //var test55 = CalculateClass.calcShipCost(787,null,false,"high");


        Throwable exception = assertThrows(Exception.class,
                ()-> CalculateClass.calcShipCost(787,null,false,"high"), "gggggg");


        assertTrue( exception.getMessage().contains("missing required parameter - size"), "fgsgfd");

        }







    @Test
    @DisplayName("меньше минимума")
    void test2() throws Exception {
        //var test55 = CalculateClass.calcShipCost(787,null,false,"high");


        var rest = CalculateClass.calcShipCost(2,false,false,"normal");


        System.out.print(rest);



    }



    @Test
    @DisplayName("Проверка граничных занчений")
    void test3() throws Exception {
        //var test55 = CalculateClass.calcShipCost(787,null,false,"high");


        var rest = CalculateClass.calcShipCost(27,true,false,"normal");


        System.out.print(rest);



    }

    @Test
    @DisplayName("хрупкий гркз больше 30 км")
    void test4() throws Exception {
        //var test55 = CalculateClass.calcShipCost(787,null,false,"high");


        var rest = CalculateClass.calcShipCost(31,true,true,"normal");


        System.out.print(rest);



    }



    @DisplayName("хрупкий гркз меньше 30 км")
    @Test
    void test5() throws Exception {
        //var test55 = CalculateClass.calcShipCost(787,null,false,"high");


        var rest = CalculateClass.calcShipCost(30,true,true,"normal");


        System.out.print(rest);



    }







}






