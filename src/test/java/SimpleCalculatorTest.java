import com.ll.SimpleCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    @Test
    @DisplayName("덧셈")
    public void t1(){
        SimpleCalculator calculator = new SimpleCalculator();
        int rs = calculator.plus(1,2);
        assertThat(rs).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    public void t2(){
        SimpleCalculator calculator = new SimpleCalculator();
        int rs = calculator.minus(5,3);
        assertEquals(2,rs);
    }

    @Test
    @DisplayName("곱셈")
    public void t3(){
        SimpleCalculator calculator = new SimpleCalculator();
        int rs = calculator.multiply(2,4);
        assertEquals(8,rs);
    }

    @Test
    @DisplayName("나눗셈")
    public void t4(){
        SimpleCalculator calculator = new SimpleCalculator();
        int rs = calculator.divide(5,2);
        assertEquals(2,rs);
    }

    @Test
    @DisplayName("나눗셈 나머지")
    public void t5(){
        SimpleCalculator calculator = new SimpleCalculator();
        int rs = calculator.reminder(5,2);
        assertEquals(1,rs);
    }

    @Test
    @DisplayName("나눗셈 나머지2")
    public void t6(){
        SimpleCalculator calculator = new SimpleCalculator();
        int rs = calculator.reminder(12,3);
        assertEquals(0,rs);
    }

}
