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



    }



    @Test
    void test2() throws Exception {
        //var test55 = CalculateClass.calcShipCost(787,null,false,"high");


        CalculateClass.calcShipCost(787,null,false,"high"), "gggggg");




    }



}






