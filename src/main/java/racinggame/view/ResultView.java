package racinggame.view;

import racinggame.model.Car;

import java.util.List;

public class ResultView {

    private static final String PRINT_WINNERS_FORMAT = "최종 우승자는 %s 입니다.";

    /**
     * 경주 결과
     *
     * @param list
     */
    public static void printRaceResult(List<Car> list) {
        list.forEach(car -> System.out.println(String.format("%s : %s", car.getName(), car.getRecord())));
    }

    /**
     * 우승자 발표
     *
     * @param winners
     */
    public static void printWinners(String winners) {
        System.out.println(String.format(PRINT_WINNERS_FORMAT, winners));
    }

}
