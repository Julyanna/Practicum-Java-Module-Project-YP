
import java.util.Scanner;

public class Formatter {

    private final Scanner scanner;

    public Formatter(Scanner scanner) {
        this.scanner = scanner;
    }

    public int scanNumberOfPersons() {

        System.out.println("На скольких человек необходимо разделить счёт?");
        int numberOfPersons;
        String messageError = "Количество человек неверное, введите количество больше или равно 2";
        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println(messageError);
                scanner.nextLine();
            } else {
                numberOfPersons = scanner.nextInt();
                if (numberOfPersons < 2){
                    System.out.println(messageError);
                    scanner.nextLine();
                } else {
                    break;
                }
            }
        }

        scanner.nextLine(); // Очистка буфера ввода после Чтение числового значения из ввода

        return numberOfPersons;
    }

    public String getString(){
        return scanner.nextLine();
    }

    public double getProductPrice(String msgFirst, String msgRightPrice){
        double price;
        System.out.println(msgFirst + " " + msgRightPrice);
        String msgErrorPrice = "Вы ввели некорректный формат стоимости.";
        while (true) {
            if (!scanner.hasNextDouble()){

                System.out.println(msgErrorPrice + "\n" + msgRightPrice);
                scanner.nextLine();
            } else {
                price = scanner.nextDouble();
                price = Math.round(price * 100.0) / 100.0;
                if (price <= 0.00){
                    System.out.println(msgErrorPrice + "\n" + msgRightPrice + " и больше 0");
                } else {
                    break;
                }
            }
        }


        scanner.nextLine(); // Очистка буфера ввода после Чтение числового значения из ввода

        return price;
    }

    public boolean checkExitCommand(String command) {
        return command.equalsIgnoreCase("завершить");
    }

    public double getDividedPrice(double totalPrice, int numberOfPersons) {

        double dividedPrice = totalPrice / numberOfPersons;
        dividedPrice = Math.round(dividedPrice * 100.0) / 100.0;
        return dividedPrice;
    }

    public String getCurrencyDecline(double amount){
        String currencyName;

        int lastNumber = (int) (Math.floor(amount) % 10);

        switch (lastNumber) {
            case 1 -> currencyName = "рубль";
            case 2, 3, 4 -> currencyName = "рубля";
            case 5, 6, 7, 8, 9, 0 -> currencyName = "рублей";
            default -> currencyName = "руб";
        }


        return currencyName;
    }
}
