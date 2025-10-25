package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingGameParser {

    public static List<String> parseRacingCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 다시 입력해주세요.");
        }

        List<String> racingCarNameList = Arrays.stream(input.split(",")).toList();
        racingCarNameList.forEach(carName -> RacingGameValidator.validateRacingCarName(carName));
        return racingCarNameList;
    }

    public static int parseTryCount(String input) {
        RacingGameValidator.validateTryCount(input);
        return Integer.parseInt(input);
    }
}
