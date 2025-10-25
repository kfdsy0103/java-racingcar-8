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
}
