package racingcar;

import java.util.List;

public class RacingGameSimulator {

    private List<RacingCar> racingCarList;
    private int tryCount;
    private NumberStrategy numberStrategy;

    public RacingGameSimulator(List<RacingCar> racingCarList, int tryCount, NumberStrategy numberStrategy) {
        this.racingCarList = racingCarList;
        this.tryCount = tryCount;
        this.numberStrategy = numberStrategy;
    }

    public void simulate() {
        ConsoleIO.printRacingStartMessage();
        for (int currentCount = 0; currentCount < tryCount; currentCount++) {
            racingCarList.forEach(this::pickNumberAndMove);
            ConsoleIO.printRacingStatus(racingCarList);
        }
        ConsoleIO.printRacingWinnerNames(extractWinnerNameList());
    }

    private void pickNumberAndMove(RacingCar racingCar) {
        int number = numberStrategy.pickNumber();
        if (number >= 4) {
            racingCar.moveForward();
        }
    }

    private List<String> extractWinnerNameList() {
        int maxForwardCount = extractMaxForwardCount();
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getForwardCount() == maxForwardCount)
                .map(RacingCar::getName)
                .toList();
    }

    private int extractMaxForwardCount() {
        return racingCarList.stream()
                .map(RacingCar::getForwardCount)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
