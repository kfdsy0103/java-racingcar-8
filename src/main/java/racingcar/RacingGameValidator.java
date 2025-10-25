package racingcar;

public class RacingGameValidator {

    private static final String REGEXP_TRY_COUNT = "^[1-9][0-9]*$";

    public static void validateRacingCarName(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 다시 입력해주세요.");
        }
        else if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        else if (input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름에 구분자(,)는 들어갈 수 없습니다.");
        }
    }

    public static void validateTryCount(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 공백일 수 없습니다.");
        } else if (!input.matches(REGEXP_TRY_COUNT)) {
            throw new IllegalArgumentException("시도 횟수는 양수인 정수만 입력될 수 있습니다.");
        }
    }
}
