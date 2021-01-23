package lab4.Pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TaxesCollector {

    private int childTaxes;

    private double sellPropertyTaxes;
    private int countProperty;

    private double giftingTaxes;
    private int countGifts;

    private boolean financialTaxes;
    private boolean royaltiesTaxes;

    private double incomeTaxes;

    private double transferTaxes;
    private int countTransfers;


    private IncomeCollector incomeCollector = new IncomeCollector();
    private TaxesCalculator taxesCalculator = new TaxesCalculator();

    private void initList(){
        incomeCollector.initList();
        System.out.println("|----------------------------------------------------|");
    }

    public void GetPersonalInfo(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("D:\\Uni\\2 yaerz\\Прик.програмування\\mavenLab4\\src\\main\\java\\lab4\\Runner\\PersonalData.txt"));
            String info = bufferedReader.readLine();
            childTaxes = (int) Double.parseDouble(info);
            info = bufferedReader.readLine();
            countTransfers = (int) Double.parseDouble(info);
            info = bufferedReader.readLine();
            transferTaxes = Double.parseDouble(info);
            info = bufferedReader.readLine();
            countGifts = (int) Double.parseDouble(info);
            info = bufferedReader.readLine();
            giftingTaxes = Double.parseDouble(info);
            info = bufferedReader.readLine();
            if (info == "true") {
                royaltiesTaxes = true;
            } else {
                royaltiesTaxes = false;
            }
            info = bufferedReader.readLine();
            if (info == "true") {
                financialTaxes = true;
            } else {
                financialTaxes = false;
            }
            info = bufferedReader.readLine();
            countProperty = (int) Double.parseDouble(info);
            info = bufferedReader.readLine();
            sellPropertyTaxes = Double.parseDouble(info);

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

    }

    public void getIncomeTaxes(){
        initList();
        double value;
        double sum=0;
        String month;
        int i = 0;
        while(i<12) {
            value = incomeCollector.getValueByIndex(i);
            month = incomeCollector.getMonthByIndex(i);
            incomeTaxes = (value * 8) / 100;
            sum += incomeTaxes;
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|%-30s||  %-10g        |\n", month, incomeTaxes);
            i++;
        }
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.printf("|Сума доходу за рік %-30g   |\n",sum);
    }

    public void getChildTaxes() {
        GetPersonalInfo();
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.printf("|Сума пільг за %d дитини = %-27d|\n",childTaxes,(2950*childTaxes));
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    }

    public void getSellPropertyTaxes(){
        GetPersonalInfo();
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.printf("|Ви продали %d одиниць майна на суму = %-13g  |",countProperty,sellPropertyTaxes);
        System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.printf("|Заплачено податку %-30g    |",((sellPropertyTaxes*5)/100));
        System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    }


    public void getGiftingTaxes(){
        GetPersonalInfo();
        if(countGifts == 0) {
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|Ви  отримували нічого в подарунок  суму або майно     |");
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }else{
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|Сума за %d подаруник = %-29g  |\n", countGifts, ((countGifts * 15) / 100));
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }
    }

    public void getTransferTaxes(){
        GetPersonalInfo();
        if(countTransfers == 0 ){
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|Ви  отримували  нічого                              |");
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }else {
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|Сума за %d перекази = %-29g  |\n", countTransfers, (transferTaxes * 17) / 100);
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }
    }

    public void getFinancialAidTaxes(){
        GetPersonalInfo();
        if(financialTaxes == false){
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|За рік ви отримали     0 грн допомоги               |");
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }else{
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|За рік ви отримали 30000 грн допомоги               |");
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }
    }

    public void getRoyaltiesTaxes(){
        GetPersonalInfo();
        if(royaltiesTaxes == false){
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|За рік ви отримали    0 грн допомоги               |");
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }else{
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.printf("|За рік ви отримали 10000 грн допомоги               |");
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        }
    }

    public void searchData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("|-----------------------Пошук-----------------------|");
        System.out.println("|1)Пошук за сумою                                   |");
        System.out.println("|2)Пошук за множиною                                |");
        int chose = 0;
        chose = scanner.nextInt();
        switch (chose){
            case 1:
                searchBySum();
                break;
            case 2:
                searchByFewSum();
                break;
            default:
        }
        System.out.println("|---------------------------------------------------|\n\n");
    }


    public void searchBySum(){
        Scanner scanner = new Scanner(System.in);
        double sum;
        int chose = 0;
        System.out.println("|-----------------------Пошук-----------------------|");
        System.out.println("|-----------------------Список----------------------|");
        System.out.println("\n|-Переказ з-за кордону 17%                          |"+
                           "\n|-Продаж майна 5%                                   |"+
                           "\n|-Отримання в подарунок майна і сум  15%            |"+
                           "\n|-Податки з доходу     8%                           |"+
                           "\n|-Пільги на дітей       2950 за 1 дитину            |");
        System.out.println("|---------------------------------------------------|\n\n");
        System.out.print("|Введіть по чому разувати = ");
        chose = scanner.nextInt();
        System.out.println();
        switch (chose){
            case 1:
                System.out.println("|-----------------------Перекази--------------------|");
                System.out.print("|-Введіть суму = ");
                sum = scanner.nextDouble();
                double res = taxesCalculator.countTransfer(sum);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|"+res);
                break;
            case 2:
                System.out.println("|-------------------------Продаж--------------------|");
                System.out.print("|-Введіть суму = ");
                sum = scanner.nextDouble();
                res = taxesCalculator.countSelling(sum);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|"+res);
                break;
            case 3:
                System.out.println("|-----------------------Подарунок-------------------|");
                System.out.print("|-Введіть суму = ");
                sum = scanner.nextDouble();
                res = taxesCalculator.countGifts(sum);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|"+res);
                break;
            case 4:
                System.out.println("|-------------------------Доходи--------------------|");
                System.out.print("|-Введіть суму = ");
                sum = scanner.nextDouble();
                res = taxesCalculator.countIncome(sum);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|"+res);
                break;
            case 5:
                System.out.println("|------------------------Пільги---------------------|");
                System.out.print("|-Введіть кількість дітей = ");
                sum = scanner.nextInt();
                res = taxesCalculator.countChild(sum);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|"+res);
                break;
            default:
                break;
        }
    }

    public void searchByFewSum(){
        Scanner scanner = new Scanner(System.in);
        int []sum = new int[2];
        int chose = 0;
        System.out.println("|-----------------------Пошук-----------------------|");
        System.out.println("|-----------------------Список----------------------|");
        System.out.println("\n|-Переказ з-за кордону 17%                          |"+
                "\n|-Продаж майна 5%                                   |"+
                "\n|-Отримання в подарунок майна і сум  15%            |"+
                "\n|-Податки з доходу     8%                           |"+
                "\n|-Пільги на дітей       2950 за 1 дитину            |");
        System.out.println("|---------------------------------------------------|\n\n");
        System.out.print("|Введіть по чому разувати = ");
        chose = scanner.nextInt();
        System.out.println();
        switch (chose){
            case 1:
                System.out.println("|-----------------------Перекази--------------------|");
                System.out.print("|-Введіть множину = ");
                sum[0] = scanner.nextInt();
                sum[1] = scanner.nextInt();
                String res = taxesCalculator.countChild(sum[0],sum[1]);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|" + res);
                break;
            case 2:
                System.out.println("|-------------------------Продаж--------------------|");
                System.out.print("|-Введіть множину = ");
                sum[0] = scanner.nextInt();
                sum[1] = scanner.nextInt();
                res = taxesCalculator.countChild(sum[0],sum[1]);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println(res);
                break;
            case 3:
                System.out.println("|-----------------------Подарунок-------------------|");
                System.out.print("|-Введіть множину = ");
                sum[0] = scanner.nextInt();
                sum[1] = scanner.nextInt();
                res = taxesCalculator.countChild(sum[0],sum[1]);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println("|" + res);
                break;
            case 4:
                System.out.println("|-------------------------Доходи--------------------|");
                System.out.print("|-Введіть множину = ");
                sum[0] = scanner.nextInt();
                sum[1] = scanner.nextInt();
                res = taxesCalculator.countChild(sum[0],sum[1]);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println(res);
                break;
            case 5:
                System.out.println("|------------------------Пільги---------------------|");
                System.out.print("|-Введіть кількість дітей = ");
                sum[0] = scanner.nextInt();
                sum[1] = scanner.nextInt();
                res = taxesCalculator.countChild(sum[0],sum[1]);
                System.out.println("|-----------------------Результат-------------------|");
                System.out.println(res);
                break;
            default:
                break;
        }
    }


}
