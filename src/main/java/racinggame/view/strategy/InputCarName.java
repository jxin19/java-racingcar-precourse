package racinggame.view.strategy;

public class InputCarName implements Input {

    private static final String MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REGEX_PATTERN = "^([^,]{1,5},)*[^,]{1,5}$";
    private static final String ERROR_MESSAGE= "자동자 이름은 5자 이내로 입력할 수 있고, 쉼표(,) 기준으로 구분합니다.";

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
