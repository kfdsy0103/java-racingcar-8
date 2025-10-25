package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGameSimulator {

    private List<RacingCar> racingCarList;
    private int tryCount;

    public RacingGameSimulator(List<RacingCar> racingCarList, int tryCount) {
        this.racingCarList = racingCarList;
        this.tryCount = tryCount;
    }

    public void simulate() {
        ConsoleIO.printRacingStartMessage();
        for(int currentCount = 0; currentCount < tryCount; currentCount++) {
            racingCarList.forEach(racingCar -> pickNumberAndMove(racingCar));
            ConsoleIO.printRacingStatus(racingCarList);
        }
        ConsoleIO.printRacingWinnerNames(extractWinnerNameList());
    }

    private void pickNumberAndMove(RacingCar racingCar) {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            racingCar.moveForward();
        }
    }

    private List<String> extractWinnerNameList() {
        int maxForwardCount = extractMaxForwardCount();
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getForwardCount() == maxForwardCount)
                .map(racingCar -> racingCar.getName())
                .toList();
    }

    private int extractMaxForwardCount() {
        return racingCarList.stream()
                .map(racingCar -> racingCar.getForwardCount())
                .max(Integer::compareTo)
                .orElse(0);
    }
}
