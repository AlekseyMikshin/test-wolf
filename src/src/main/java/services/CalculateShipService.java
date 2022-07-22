package services;


public class CalculateShipService {

    /**
     *  Метод рассчета стоимости доставки
     * @param distance
     * @param size
     * @param fragility
     * @param load
     * @return
     */
    public static double calcShipCost (Integer distance, Boolean size, Boolean fragility, String load)  {

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


        var result = (calcSize(size) + calcDistanceAndFragility(distance,fragility)) * calcLoad(load);

        if (result < 400){
            System.out.print("Минимальная стоимость доставки = 400 рублей \n");
            return 400;
        }
        else {
            System.out.print("Стоимость доставки = " + result + " рублей \n");
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

            var fragIncrease = 300;
            if (distance <= 2 & fragility) {
                return 50 + fragIncrease;
            }
            if (distance <= 2 & !fragility) {
                return 50;
            }
             else if (distance <= 10 & fragility) {
                return 100 + fragIncrease;
            }
            else if (distance <= 10 & !fragility) {
                return 100;
            }


            else if (distance <= 30 & fragility) {
                return 200 + fragIncrease;
            }
            else if (distance <= 30 & !fragility) {
                return 200;
            }
            else if (distance > 30 & fragility) {
                throw new RuntimeException("Хрупкие грузы нельзя возить на расстояние более 30 км");
            }
            else {
                return 300 + fragIncrease;
            }
        }






}

