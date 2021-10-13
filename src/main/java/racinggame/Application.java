package racinggame;

import racinggame.model.Cars;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getCarNames());
        cars.race(inputView.getRaceCount());
        ResultView.printRaceResult(cars.getList());
        ResultView.printWinners(cars.getWinners());
    }
}
