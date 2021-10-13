package racinggame.view.strategy;

import nextstep.utils.Console;
import racinggame.exception.InvalidInputException;

public interface Input {

    String getMessage();

    String getInputRegex();

    String getErrorMessage();

    /**
     * 입력 값에 대한 유효성 검사
     */
    default String getValue() {
        System.out.println(this.getMessage());
        String inputValue = Console.readLine();

        if (!inputValue.matches(this.getInputRegex())) {
            throw new InvalidInputException(this.getErrorMessage());
        }

        return inputValue;
    }

}
