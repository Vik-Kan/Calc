import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) throws Exception {
        String[] zn = {"+", "-", "/", "*"};
        String[] regexZn = {"\\+", "-", "/", "\\*"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");

        String exp = scanner.nextLine();

        int znIndex = -1;
        for (int i = 0; i < zn.length; i++){
            if (exp.contains(zn[i])){
                znIndex = i;
                break;
            }
        }
        //если введен другой арифметический знак или он отсутствует
        if (znIndex == -1){
            throw new Exception();
        }

        String[] numbers = exp.split(regexZn[znIndex]);
        //чисел не может быть больше двух
        if (numbers.length > 2){
            throw new Exception();
        }
        int a,b;
        //числа меньше 0 и больше 10 запрещены
        a = Integer.parseInt(numbers[0]);
        if (a > 10 | a < 0){
            throw new Exception();
        }
        b = Integer.parseInt(numbers[1]);
        if (b > 10 | b < 0){
            throw new Exception();
        }
        //второй арифметический знак
        if (exp.length() > 5){
            throw new Exception();
        }
        if (exp.length() == 5 && a != 10 | b != 10){
            throw new Exception();
        }
        if (exp.length() == 4 && a < 10 && b < 10){
            throw new Exception();
        }

        int ans;
        switch (zn[znIndex]){
            case "+":
                ans = a+b;
                break;
            case "-":
                ans = a-b;
                break;
            case "/":
                ans = a/b;
                break;
            case "*":
                ans = a*b;
                break;
            default:
                throw new Exception();
        }
        System.out.println("Output:\n"+ans);
    }
}
