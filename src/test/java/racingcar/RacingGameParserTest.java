package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGameParser 파싱 테스트")
public class RacingGameParserTest {

    @Nested
    @DisplayName("parseRacingCarNames()")
    class ParseRacingCarNames {

        @Test
        @DisplayName("자동차 이름이 공백인 경우 실패한다.")
        void 이름_공백_실패() {
            // given
            String racingCarNames = "car1,,car3";

            // when & then
            assertThatThrownBy(() -> RacingGameParser.parseRacingCarNames(racingCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름을 다시 입력해주세요.");
        }

        @Test
        @DisplayName("자동차 이름이 5자를 초과하면 실패한다.")
        void 이름_5자초과_예외() {
            // given
            String racingCarNames = "car1,fivename,car2";

            // when & then
            assertThatThrownBy(() -> RacingGameParser.parseRacingCarNames(racingCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
        }

        @Test
        @DisplayName("쉼표(,)로 구분된 5자 이하의 자동차 이름은 성공한다.")
        void 이름_쉼표구분_5자이하_성공() {
            // given
            String racingCarNames = "car1,car2,car3";

            // when
            List<String> names = RacingGameParser.parseRacingCarNames(racingCarNames);

            // then
            assertThat(names).containsExactly("car1", "car2", "car3");
        }
    }

    @Nested
    @DisplayName("parseTryCount()")
    class ParseTryCount {

        @Test
        @DisplayName("양수인 정수 입력 시 int 값으로 반환하여 성공한다.")
        void 양수정수_성공() {
            // given
            String tryCountInput = "10";

            // when
            int tryCount = RacingGameParser.parseTryCount(tryCountInput);

            // then
            assertThat(tryCount).isEqualTo(10);
        }

        @Test
        @DisplayName("공백 입력 시 실패한다.")
        void 공백_실패() {
            // given
            String tryCount = "   ";

            // when & then
            assertThatThrownBy(() -> RacingGameParser.parseTryCount(tryCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수를 다시 입력해주세요.");
        }

        @Test
        @DisplayName("0을 입력한 경우 실패한다.")
        void 입력_0_실패() {
            // given
            String tryCount = "0";

            // when & then
            assertThatThrownBy(() -> RacingGameParser.parseTryCount(tryCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수는 양수인 정수만 입력될 수 있습니다.");
        }

        @Test
        @DisplayName("음수를 입력한 경우 실패한다.")
        void 입력_음수_실패() {
            // given
            String tryCount = "-10";

            // when & then
            assertThatThrownBy(() -> RacingGameParser.parseTryCount(tryCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수는 양수인 정수만 입력될 수 있습니다.");
        }

        @Test
        @DisplayName("숫자가 아닌 값 입력 시 예외를 던진다.")
        void 입력_문자_실패() {
            // given
            String tryCount = "abc";

            // when & then
            assertThatThrownBy(() -> RacingGameParser.parseTryCount(tryCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수는 양수인 정수만 입력될 수 있습니다.");
        }
    }
}
