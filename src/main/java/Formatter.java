import java.util.Scanner;

public class Formatter {
    private final Scanner scanner;
    public Formatter(Scanner scanner) {
        this.scanner = scanner;
    }

    public int scanNumberOfPersons() {

        int numberOfPersons;
        System.out.println("На скольких человек необходимо разделить счёт?");
        String messageError = "Количество человек неверное, введите количество больше или равно 2";

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println(messageError);
                getString();
            } else {
                numberOfPersons = scanner.nextInt();
                if (numberOfPersons < 2){
                    System.out.println(messageError);
                    getString();
                } else {
                    break;
                }
            }
        }
        getString(); // Очистка буфера ввода после Чтение числового значения из ввода
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
                getString();
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
        getString(); // Очистка буфера ввода после Чтение числового значения из ввода
        return price;
    }

    public boolean checkExitCommand(String command) {
        return command.equalsIgnoreCase("завершить");
    }

    public double getDividedPrice(double totalPrice, int numberOfPersons) {
        double dividedPrice = totalPrice / numberOfPersons;
        dividedPrice = Math.round(dividedPrice * 100.0) / 100.0; //Округление до 2 знаков после запятой
        return dividedPrice;
    }

    public String getCurrencyDecline(double amount){

        String currencyName;
        int lastNumberBeforePoint = (int) (Math.floor(amount) % 10);            // единицы числа
        int nextToLastNumberBeforePoint = (int) (Math.floor(amount) / 10 % 10); // десятки числа
        if (nextToLastNumberBeforePoint == 1) {                                 // если число вышло от 10 до 19, то падеж будет как у 0 рублей
            lastNumberBeforePoint = 0;
        }

        switch (lastNumberBeforePoint) {
            case 1 -> currencyName = "рубль";
            case 2, 3, 4 -> currencyName = "рубля";
            case 5, 6, 7, 8, 9, 0 -> currencyName = "рублей";
            default -> currencyName = "руб";
        }

        return currencyName;
    }
}