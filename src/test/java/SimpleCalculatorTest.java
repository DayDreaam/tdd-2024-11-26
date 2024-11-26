import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    @Test
    @DisplayName("계산기는 덧셈이 가능해야 한다.")
    public void t1(){
        SimpleCalculator calculator = new SimpleCalculator();

        int rs = calculator.plus(10,20);

        assertEquals(3,rs);
    }
}
