package racinggame.view.strategy;

public class InputRaceCount implements Input {

    private static final String MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String REGEX_PATTERN = "^[1-9][0-9]*$";
    private static final String ERROR_MESSAGE= "숫자만 입력할 수 있습니다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public String getInputRegex() {
        return REGEX_PATTERN;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }

}
