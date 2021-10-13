package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.UnexpectValueException;
import racinggame.model.Car;
import racinggame.model.Record;
import racinggame.model.strategy.RandomMoving;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동자 기능을 테스트합니다.")
public class CarTests {

    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_MOVING_RANGE = 4;
    private static String MOVED_RANGE = "-";

    private Car car;

    @BeforeEach
    public void 자동차_초기화() {
        car = new Car("pobi");
    }

    @DisplayName("자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    public void 자동차_생성(String name) {
        assertThat(car.getName())
                .isNotNull()
                .isEqualTo(name);
    }

    @DisplayName("자동차 이름부여 실패")
    @ParameterizedTest
    @ValueSource(strings = {"anthony", ""})
    public void 자동차_이름부여_실패(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(UnexpectValueException.class);
    }

    @DisplayName("자동차 이동범위 생성")
    @Test
    public void 자동차_이동범위_생성() {
        RandomMoving randomMoving = new RandomMoving(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE, MIN_MOVING_RANGE);

        assertThat(randomMoving.getValue())
                .isNotNull()
                .isGreaterThanOrEqualTo(MIN_RANDOM_VALUE)
                .isLessThanOrEqualTo(MAX_RANDOM_VALUE);
    }

    @DisplayName("개인성적 기록")
    @Test
    public void 개인성적_기록() {
        Record record = new Record();
        record.update();

        assertThat(record.getValue())
                .isNotNull()
                .isEqualTo(MOVED_RANGE);
    }

    @DisplayName("자동차 이동가능")
    @Test
    public void 자동차_이동가능() {
        RandomMoving randomMoving = new RandomMoving(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE, MIN_MOVING_RANGE);
        assertThat(randomMoving.canMove(MAX_RANDOM_VALUE))
                .isTrue();
    }

    @DisplayName("자동차 이동실패")
    @Test
    public void 자동차_이동실패() {
        RandomMoving randomMoving = new RandomMoving(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE, MIN_MOVING_RANGE);
        assertThat(randomMoving.canMove(MAX_RANDOM_VALUE + 1))
                .isTrue();
    }

}
