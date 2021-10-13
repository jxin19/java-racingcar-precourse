package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.Car;
import racinggame.model.Cars;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("경주 기능을 테스트합니다.")
public class RacingTests {

    private static final String INPUT_CAR_NAME_DELIMITER = ",";

    private List<String> carNames;
    private Cars cars;

    @BeforeEach
    public void 자동차목록_초기화() {
        String inputCarNames = "pobi,crong,honux";
        carNames = Arrays.asList(inputCarNames.split(INPUT_CAR_NAME_DELIMITER));
        cars = new Cars(carNames);
    }

    @DisplayName("자동차목록")
    @Test
    public void 자동차목록() {
        assertAll(
                () -> assertThat(cars)
                        .isNotNull()
                        .isInstanceOf(Cars.class),
                () -> assertThat(cars.getList())
                        .isNotNull()
                        .isInstanceOf(ArrayList.class)
                        .asList(),
                () -> {
                    for (int i = 0; i < cars.getList().size(); i++) {
                        assertThat(cars.getList().get(i).getName())
                                .isNotEmpty()
                                .isEqualTo(carNames.get(i));
                    }
                }
        );
    }

    @DisplayName("경주(레이싱)")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    public void 경주(int raceCount) {
        cars.race(raceCount);

        for (Car car : cars.getList()) {
            assertThat(car.getRecordResult())
                    .isNotNull()
                    .isGreaterThanOrEqualTo(1);
        }
    }

    @DisplayName("최고성적 찾기")
    @ParameterizedTest
    @CsvSource(value = {"135:5", "269:9", "4521:5"}, delimiterString = ":")
    public void 최고성적_찾기(String recordRawValues, String checkValue) {
        List<Integer> records = Arrays.stream(recordRawValues.split("")).map(Integer::new).collect(Collectors.toList());
        Integer topRecordValue = Collections.max(records, Comparator.comparing(record -> record));

        assertThat(topRecordValue.equals(Integer.valueOf(checkValue))).isTrue();
    }

    @DisplayName("우승자 목록")
    @ParameterizedTest
    @ValueSource(ints = 3)
    public void 우승자_목록(int raceCount) {
        cars.race(raceCount);

        for (Car car : cars.getList()) {
            System.out.println(String.format("Car[%s], Record[%s]", car.getName(), car.getRecordResult()));
        }

        String winners = cars.getWinners();
        System.out.println(winners);

        assertThat(winners).isNotEmpty();
    }

}
