package lab4.Runner;

import lab4.DataBase;
import lab4.Developer;
import lab4.Menu.Commands.*;
import lab4.Person.Account;


import java.io.IOException;
import java.util.Scanner;



public class DataBaseRunner {

    private static Scanner scanner = new Scanner(System.in);
    private static Account account = new Account("Влад", "Тодорчук");

    public static void main(String[] args) throws IOException {
        String name = getPersonContacts();

        DataBase dataBase = new DataBase();
        Developer dev = new Developer(
                new Help(dataBase),
                new IncomeTaxes(dataBase),
                new ChildTaxes(dataBase),
                new TransferTaxes(dataBase),
                new SellPropertyTaxes(dataBase),
                new GiftingTaxes(dataBase),
                new FinancialAidTaxes(dataBase),
                new RoyaltiesTaxes(dataBase),
                new MyIncome(dataBase),
                new Search(dataBase)
        );
        System.out.println("|----------------------Terminal----------------------|");//52
        System.out.println("|-Щоб дізнатися більше введіть - допомога            |");
        String command;

        while (true){
            System.out.print("|-Введіть команду:");
            command = scanner.nextLine();
            switch (command){
                case "допомога":
                    dev.helpCommand();
                    break;
                case "податки з доходів":
                    dev.incomesCommand();
                    break;
                case "авторські винагороди":
                    dev.royaltyCommand();
                    break;
                case "продаж майна":
                    dev.sellingCommand();
                    break;
                case "отримання в подарунок сум і майна":
                    dev.giftingCommand();
                    break;
                case "перекази з-за кордону":
                    dev.transferCommand();
                    break;
                case "пільги на дітей":
                    dev.childCommand();
                    break;
                case "матеріальна допомога":
                    dev.financialCommand();
                    break;
                case "мій дохід":
                    dev.MyIncomeCommand();
                    break;
                case  "вийти":
                    System.out.println("|----------------------Terminal----------------------|");
                    System.exit(1);
                case "пошук":
                    dev.searchCommand();
                    break;
                default:
                    System.out.println("|-Не правильна команда введіть команду-допомога");
                    break;
            }
            System.out.println("|----------------------------------------------------|");
        }

    }

    public static String getPersonContacts()   {
        String name;
        String surname;
        System.out.println("|-----------------------Увійти-----------------------|");
        System.out.print("|-Введіть ваше ім'я ");
        name = scanner.nextLine();
        System.out.print("|-Введіть ваше прізвище ");
        surname = scanner.nextLine();
        return name + " " + surname;
    }
}
