package racinggame.model;

import racinggame.exception.UnexpectValueException;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final String INVALID_VALUE_MESSAGE = "자동자 이름은 5자 이내로 입력할 수 있습니다.";

    private final String name;

    public Name(final String name) {
        validateValue(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 유효성 검사
     *
     * @param name
     */
    private void validateValue(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new UnexpectValueException(INVALID_VALUE_MESSAGE);
        }
    }

}
