package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements NumberStrategy {

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
