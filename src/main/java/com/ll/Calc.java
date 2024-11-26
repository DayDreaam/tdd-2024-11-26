package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calc {
    public int run(String str){
        // 전처리
        str = str.replaceAll("\\(", "\\( ");
        str = str.replaceAll("\\)", " \\)");

        // 리스트 안에 순서대로 담기
        List<String> list = new ArrayList<>();
        for(String element : str.split(" ")){
            list.add(element);
        }
        // 후위 연산식으로 변경
        List<String> huiList = hui(list);

        // 후위 연산식 계산
        return calculateHui(huiList);
    }

    public List<String> hui(List<String> list) {
        List<String> l = new ArrayList<>();
        Stack<String> s = new Stack<>();

        for(int i=0; i<list.size();i++){
            String str = list.get(i);
            if(priority(str)==0){ // 숫자는 리스트에 바로 등록
                l.add(str);
            }
            else if(s.empty()){ // 연산자가 스택에 없을경우 스택에 푸시
                s.push(str);
            }
            else{ // 연산자가 두개 이상 스택에 들어가야 되는 상황
                if(str.equals("(")){ // 여는 괄호면 푸시
                    s.push(str);
                }
                else if(str.equals(")")){ // 닫힌 괄호면 스택에 저장된 열린괄호까지의 모든 연산자 반환
                    while(true){
                        String operator = s.pop();
                        if(operator.equals("(")){
                            break;
                        }
                        else{
                            l.add(operator);
                        }
                    }
                }
                else{ // 연산자 우선순위 비교
                    if(priority(str) > priority(s.peek())){ // 스택에 저장되어있는 것보다 우선순위가 높으면
                        s.push(str);
                    }
                    else{
                        while(!s.isEmpty()){
                            if(priority(str) <= priority(s.peek())){ // 스택에 저장되어있는 것보다 우선순위가 높으면
                                list.add(s.pop());
                            }
                            else{
                                break;
                            }
                        }
                        s.push(str);
                    }
                }
            }
        }
        while(!s.isEmpty()){
            String str = s.pop();
            if(!str.equals("(")) l.add(str);
        }
        return l;
    }

    private int priority(String str){
        if(str.equals("*") || str.equals("/")){
            return 3;
        }else if(str.equals("+") || str.equals("-")){
            return 2;
        }else if(str.equals("(") || str.equals(")")){
            return 1;
        }
        else{ // 숫자일경우
            return 0;
        }
    }

    public int calculateHui(List<String> list){
        Stack<Integer> stack = new Stack<>();
        for(String str : list){
            if(priority(str) == 0){
                stack.push(Integer.parseInt(str));
            }
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(str.equals("+")){
                    stack.push(num1+num2);
                }else if(str.equals("-")){
                    stack.push(num1-num2);
                }else if(str.equals("*")){
                    stack.push(num1*num2);
                }else if(str.equals("/")){
                    stack.push(num1/num2);
                }
            }
        }
        int result = stack.pop();
        return result;
    }
}