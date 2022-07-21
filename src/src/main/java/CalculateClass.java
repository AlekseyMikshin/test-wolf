import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;




@Log4j2
public class CalculateClass {



    /**
     *  мЕТОД ДЛЯ РАСЧЕТАВ СТОИОСТИ ДСОАТВКП
     * @param distance
     * @param size
     * @param fragility
     * @param load
     * @return
     */
    public static double calcShipCost (Integer distance, Boolean size, Boolean fragility , String load)  {

        if (distance == null) {
            throw new RuntimeException("missing required parameter - distance");
        }
          else if (distance <= 0) {
                throw new RuntimeException("distance must be >= 0");
            }
         else if (size == null) {
            throw new RuntimeException("missing required parameter - size");
        }
        else if (fragility == null) {
            throw new RuntimeException("missing required parameter - fragility");
        }
        else if (load == null){
            throw new RuntimeException("missing required parameter - load");
        }
        else {
            System.out.print("Проверка входных параметров прошла успешна \n");
        }


        double result = (calcSize(size) + calcDistanceAndFragility(distance,fragility)) * calcLoad(load);

        if (result < 400){
            System.out.print("Минимальная стоиость доставки = 400 рублей");
            return 400;
        }
        else {
            System.out.print("Стоимость доставки = " + result + " рублей");
            return result;
        }


    }

    /**
     * Расчет надбавки стоимости за габариты груза
     * size = true (большие габариты)
     * size = false (маденькие габариты)
     * @param size
     * @return
     */
    public static Integer calcSize(Boolean size){
        if (size) {
            return 200;
        }
        else {
            return 100;
        }
    }


    /**
     * Рассчет коэффициэнта в зависимости от уровня загрузки
     * very high = очень высокая загруженность
     * high = высокая загруженность
     * medium = повышенная загруженность
      * @param load
     * @return
     */
    public static double calcLoad(String load) {

        switch (load) {

            case "very high": {
                return 1.6;
            }
            case "high": {
                return 1.4;
            }
            case "medium": {
                return 1.2;
            }
            default:
                return 1;
        }
    }


    /**
     * Расчет надбавки за расстояние доставки
     * @param distance
     * @param fragility
     * @return
     */
        public static int calcDistanceAndFragility(Integer distance, Boolean fragility) {

            if (distance <= 2) {
                return 50;
            }
             else if (distance <= 10) {
                return 100;
            }
            else if (distance <= 30) {
                return 200;
            }
             else {
                 if (fragility) {
                 throw new RuntimeException("Хрупкие грузы нельзя возить на расстояние более 30 км");
                 }
                 else {
                     return 300;
                 }
            }
        }






}

