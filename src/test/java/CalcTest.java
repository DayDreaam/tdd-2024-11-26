import com.ll.Calc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcTest {
    Calc calc = new Calc();

    @Test
    @DisplayName("후위계산 테스트")
    public void calculateHuiTest(){
        int result = calc.calculateHui(Arrays.asList("1","2","3","*","+","4","/"));
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("후위계산 변환 테스트")
    public void huiTest(){
        List<String> list = Arrays.asList("(","1","+","2","*","3",")","/","4");
        assertThat(calc.hui(list))
                .isEqualTo(Arrays.asList("1","2","3","*","+","4","/"));
    }

    @Test
    @DisplayName("후위계산 변환 테스트2")
    public void huiTest2(){
        List<String> list = Arrays.asList("(","(","1","+","-10",")","*","3",")","/","4");
        assertThat(calc.hui(list))
                .isEqualTo(Arrays.asList("1","-10","+","3","*","4","/"));
    }

    @Test
    @DisplayName("후위계산 변환 테스트3")
    public void huiTest3(){
        List<String> list = Arrays.asList(
                "(","(","3","+","5",")","*","5","+","-10",")","*","10","/","5");
        assertThat(calc.hui(list))
                .isEqualTo(Arrays.asList("1","-10","+","3","*","4","/"));
    }


    @Test
    @DisplayName("테스트 코드 활용 계산기 과제")
    public void runTest(){
        assertThat(calc.run("((3 + 5) * 5 + -10) * 10 / 5"))
                .isEqualTo(60);
    }
}
