package com.ll;

public class SimpleCalculator {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1/num2;
    }

    public int reminder(int num1, int num2) {
//        // 첫구현
//        return 1;

//        // 두번째 구현
//        if(num1 == 5 && num2 == 2){
//            return 1;
//        }
        // 세번째 구현
        return num1%num2;
    }
}
