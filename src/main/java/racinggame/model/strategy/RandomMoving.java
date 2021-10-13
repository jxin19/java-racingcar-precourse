package racinggame.model.strategy;

import nextstep.utils.Randoms;
import racinggame.exception.UnexpectValueException;

public class RandomMoving implements Moving {

    private static int minRandomValue;
    private static int maxRandomValue;
    private static int minMovingRange;

    public RandomMoving(final int minRandomValue, final int maxRandomValue, final int minMovingRange) {
        this.minRandomValue = minRandomValue;
        this.maxRandomValue = maxRandomValue;
        this.minMovingRange = minMovingRange;
    }

    @Override
    public int getValue() {
        try {
            return Randoms.pickNumberInRange(minRandomValue, maxRandomValue);
        } catch (IllegalArgumentException e) {
            throw new UnexpectValueException(e.getMessage());
        }
    }

    /**
     * 앞으로 이동가능한지 판단
     *
     * @param compareValue
     * @return
     */
    public boolean canMove(int compareValue) {
        return compareValue >= minMovingRange;
    }

}
