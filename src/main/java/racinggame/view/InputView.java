package racinggame.view;

import racinggame.exception.InvalidInputException;
import racinggame.view.strategy.Input;
import racinggame.view.strategy.InputCarName;
import racinggame.view.strategy.InputRaceCount;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAME_DELIMITER = ",";

    private List<String> carNames;
    private int raceCount;

    /**
     * 경기 준비: 자동차 이름, 시도할 횟수를 입력
     */
    public InputView() {
        setCarNames();
        setRaceCount();
    }

    /**
     * 자동차 이름을 입력합니다.
     */
    private void setCarNames() {
        try {
            Input input = new InputCarName();
            this.carNames = Arrays.asList(input.getValue().split(INPUT_CAR_NAME_DELIMITER));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            setCarNames();
        }
    }

    /**
     * 시도할 회수를 입력합니다.
     */
    private void setRaceCount() {
        try {
            Input input = new InputRaceCount();
            this.raceCount = Integer.valueOf(input.getValue());
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            setRaceCount();
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRaceCount() {
        return raceCount;
    }

}
