package racinggame.model;

import racinggame.model.strategy.RandomMoving;

public class Car {

    private Name name;
    private Record record;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_MOVING_RANGE = 4;

    public Car(final String name) {
        this.name = new Name(name);
        this.record = new Record();
    }

    /**
     * 자동차 이동
     * 랜덤 값(숫자 1-9 중)이 최소 이동 범위보다 크다면 개인성적에 기록합니다.
     */
    public void move() {
        RandomMoving randomMoving = new RandomMoving(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE, MIN_MOVING_RANGE);
        int moveRange = randomMoving.getValue();

        if (randomMoving.canMove(moveRange)) {
            record.update();
        }
    }

    public String getName() {
        return name.getName();
    }

    public String getRecord() {
        return record.getValue();
    }

    public Integer getRecordResult() {
        return record.getSize();
    }

}
