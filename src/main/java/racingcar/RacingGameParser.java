package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingGameParser {

    public static List<String> parseRacingCarNames(String input) {
        List<String> racingCarNameList = Arrays.stream(input.split(",")).toList();
        racingCarNameList.forEach(carName -> RacingGameValidator.validateRacingCarName(carName));
        return racingCarNameList;
    }

    public static int parseTryCount(String input) {
        RacingGameValidator.validateTryCount(input);
        return Integer.parseInt(input);
    }
}
