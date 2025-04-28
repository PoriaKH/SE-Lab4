package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int multiply(int a, int b){
        return a * b;
    }
    public int division(int a, int b){
        return a / b;
    }
    public int power(int value1, int value2){
        int result = 1;
        boolean flag = true;
        int count = value2;
        if (value2 < 0){
            flag = false;
            count = (-1) * value2;
        }
        for(int i = 0; i < count; i++){
            result *= value1;
        }
        if (!flag){
            result = 1 / result;
        }
        return result;
    }
}