package racinggame.model;


import java.util.*;

public class Cars {

    private final List<Car> list;
    private static String WINNER_LIST_DELIMITER = ",";

    public Cars(List<String> carNames) {
        list = new ArrayList<>();
        carNames.forEach(carName -> list.add(new Car(carName)));
    }

    public List<Car> getList() {
        return list;
    }

    /**
     * 레이스(경주)
     * 시도 회수만큼 경주를 진행합니다.
     *
     * @param raceCount 시도 회수
     */
    public void race(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            list.forEach(car -> car.move());
        }
    }

    /**
     * 우승자 목록
     *
     * @return 우승자 목록을 문자열로 반환합니다.
     */
    public String getWinners() {
        int topRecord = getTopRecord();
        StringJoiner winners = new StringJoiner(WINNER_LIST_DELIMITER);

        for (Car car : list) {
            winners = getWinnerName(car, topRecord, winners);
        }

        return winners.toString();
    }

    /**
     * 최고성적 찾기
     *
     * @return 경주결과 중 최고성적을 반환합니다.
     */
    private int getTopRecord() {
        Car topRecordCar = Collections.max(list, Comparator.comparing(compare -> compare.getRecordResult()));
        return topRecordCar.getRecordResult();
    }

    /**
     * 우승자 이름 반환
     * 개인기록이 최고성적과 동일하면 우승자로 판단합니다.
     * 우승자로 판단되었다면 우승자 목록에 추가합니다.
     *
     * @param car
     * @param topRecord 최고성적
     * @param winners 우승자 목록
     * @return 우승자 목록을 반환합니다.
     */
    private StringJoiner getWinnerName(Car car, int topRecord, StringJoiner winners) {
        if (car.getRecordResult() == topRecord) {
            winners.add(car.getName());
        }

        return winners;
    }

}
