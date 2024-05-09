

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Calculator {

    private final int numberOfPersons;
    private final ArrayList<Product> productList = new ArrayList<>();
    private final Formatter formatter;
    private double totalPrice;

    public Calculator(int numberOfPersons, Scanner scanner){
        this.numberOfPersons = numberOfPersons;
        this.formatter = new Formatter(scanner);
    }

    public void scanProducts(){
        String inputValue, productName;
        double productPrice;
        totalPrice = 0;
        while (true) {

            System.out.println("Введите название товара или команду \"завершить\"");
            inputValue = formatter.getString();

            if (formatter.checkExitCommand(inputValue)) {
                System.out.println("Ввод товаров завершен. Идет подсчет суммы, которую должен заплатить каждый человек");
                break;
            } else {
                productName = inputValue;
                productPrice = formatter.getProductPrice("Введите цену товара.", "Стоимость должна быть в формате рубли.копейки, например 10,45 или 11,40");
                Product product = new Product(productName, productPrice);
                productList.add(product);
                totalPrice += productPrice;
                String currencyName = formatter.getCurrencyDecline(productPrice);
                System.out.println("Товар \"" + productName + "\" на сумму " + String.format("%.2f", productPrice) + " " + currencyName + " успешно добавлен в список!");
                System.out.println("Хотите добавить еще один товар?");
            }
        }
    }

    public void showTotalReceipt() {
        System.out.println("\nДобавленные товары:");
        Iterator<Product> listIterator = productList.iterator();
        while (listIterator.hasNext()){
            Product product = listIterator.next();
            System.out.println("\"" + product.getName() + "\" на сумму " + String.format("%.2f", product.getPrice()));
        }

        System.out.println("Общая сумма: " + String.format("%.2f", totalPrice));
        double dividedPrice = formatter.getDividedPrice(totalPrice, numberOfPersons);
        String currencyName = formatter.getCurrencyDecline(dividedPrice);
        System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", dividedPrice) + " " + currencyName);

    }


}
