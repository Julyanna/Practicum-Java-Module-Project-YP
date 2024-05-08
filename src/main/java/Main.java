import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.println("Добро пожаловать в приложение по разделению счета!");
        Formatter formatter = new Formatter(scanner);
        int numberOfPersons = formatter.scanNumberOfPersons();
        System.out.println("Количество человек: " + numberOfPersons);

        Calculator calc = new Calculator(numberOfPersons, scanner);
        calc.scanProducts();
        calc.showTotalReceipt();



    }
}