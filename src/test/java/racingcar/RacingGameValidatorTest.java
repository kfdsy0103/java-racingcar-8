package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGameValidator 검증기 테스트")
public class RacingGameValidatorTest {

    @Nested
    @DisplayName("validateRacingCarName()")
    class ValidateRacingCarName {

        @Test
        @DisplayName("자동차 이름에 쉼표(,)가 포함되어 있으면 실패한다.")
        void 이름_쉼표_실패() {
            // given
            String racingCarName = "c,ar";
            // when & then
            assertThatThrownBy(() -> RacingGameValidator.validateRacingCarName(racingCarName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름에 구분자(,)는 들어갈 수 없습니다.");
        }

        @Test
        @DisplayName("자동차 이름이 비어있는 경우 실패한다.")
        void 이름_비어있음_실패() {
            // given
            String racingCarName = "";
            // when & then
            assertThatThrownBy(() -> RacingGameValidator.validateRacingCarName(racingCarName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름을 다시 입력해주세요.");
        }

        @Test
        @DisplayName("자동차 이름이 null인 경우 실패한다.")
        void 이름_NULL_실패() {
            // given
            String racingCarName = null;
            // when & then
            assertThatThrownBy(() -> RacingGameValidator.validateRacingCarName(racingCarName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름을 다시 입력해주세요.");
        }

        @Test
        @DisplayName("자동차 이름이 공백인 경우 실패한다.")
        void 이름_공백_실패() {
            // given
            String racingCarName = "   ";
            // when & then
            assertThatThrownBy(() -> RacingGameValidator.validateRacingCarName(racingCarName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름을 다시 입력해주세요.");
        }

        @Test
        @DisplayName("자동차 이름이 5자를 초과하면 실패한다.")
        void 이름_5자초과_실패() {
            // given
            String racingCarName = "helloMyCar";
            // when & then
            assertThatThrownBy(() -> RacingGameValidator.validateRacingCarName(racingCarName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
        }

        @Test
        @DisplayName("자동차 이름에 쉼표가 없고, 공백이 아니며, 5자 이하인 경우 성공한다.")
        void 이름_성공() {
            // given
            String racingCarName = "hello";
            // when & then
            assertThatCode(() -> RacingGameValidator.validateRacingCarName(racingCarName))
                    .doesNotThrowAnyException();
        }
    }
}
