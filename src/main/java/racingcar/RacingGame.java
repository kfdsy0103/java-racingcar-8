package racingcar;

import java.util.List;

public class RacingGame {

    public void play() {
        // 1. 자동차 이름 입력
        String racingCarNameInput = ConsoleIO.inputRacingCarNames();
        List<String> racingCarNameList = RacingGameParser.parseRacingCarNames(racingCarNameInput);
        List<RacingCar> racingCarList = racingCarNameList.stream()
                .map(racingCarName -> new RacingCar(racingCarName, 0))
                .toList();

        // 2. 시도할 횟수 입력
        String tryCountInput = ConsoleIO.inputTryCount();
        int tryCount = RacingGameParser.parseTryCount(tryCountInput);

        // 3. 게임 진행
        RacingGameSimulator simulator = new RacingGameSimulator(racingCarList, tryCount);
        simulator.simulate();
    }
}
