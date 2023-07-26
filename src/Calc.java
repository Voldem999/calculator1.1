import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа и арифметическое действие");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static int parse(String expression) throws Exception {
        int num1;
        int num2;
        String operation;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Не верная операция");
        operation = detectOperation(expression);
        assert operation != null;
        num1 = Integer.parseInt(operands[0]);
        num2 = Integer.parseInt(operands[1]);
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        return Integer.parseInt(String.valueOf(calc(num1, num2, operation)));
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }
}