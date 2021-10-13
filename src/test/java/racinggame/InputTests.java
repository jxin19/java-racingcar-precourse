package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 기능을 테스트합니다.")
public class InputTests {

    @DisplayName("자동차이름 유효성검사 통과")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    public void 자동차이름_유효성검사_통과(String inputValue) {
        final String REGEX_PATTERN = "^([^,]{1,5},)*[^,]{1,5}$";

        assertThat(inputValue.matches(REGEX_PATTERN))
                .isNotNull()
                .isTrue();
    }

    @DisplayName("자동차이름 유효성검사 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "cartier", "balenciaga"})
    public void 자동차이름_유효성검사_실패(String inputValue) {
        final String REGEX_PATTERN = "^([^,]{1,5},)*[^,]{1,5}$";

        assertThat(inputValue.matches(REGEX_PATTERN))
                .isFalse();
    }

    @DisplayName("시도회수 유효성검사 통과")
    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "3345", "1240"})
    public void 시도회수_유효성검사_통과(String inputValue) {
        final String REGEX_PATTERN = "^[1-9][0-9]*$";

        assertThat(inputValue.matches(REGEX_PATTERN))
                .isNotNull()
                .isTrue();
    }

    @DisplayName("시도회수 유효성검사 실패")
    @ParameterizedTest
    @ValueSource(strings = {"0", "010", "fail01"})
    public void 시도회수_유효성검사_실패(String inputValue) {
        final String REGEX_PATTERN = "^[1-9][0-9]*$";

        assertThat(inputValue.matches(REGEX_PATTERN))
                .isFalse();
    }

}
