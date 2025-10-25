package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleIO {

    public static String inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static void printRacingStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRacingStatus(List<RacingCar> racingCarList) {
        racingCarList.stream()
                .map(racingCar -> racingCar.getName() + " : " + "-".repeat(racingCar.getForwardCount()))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printRacingWinnerNames(List<String> winnerList) {
        String winnerListFormat = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winnerListFormat);
    }
}
