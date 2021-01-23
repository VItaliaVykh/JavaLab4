package lab4.Pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class IncomeCollector {

    private List<Double>  incomeValue = new ArrayList<>();
    private List<String>  incomeMonth = new ArrayList<>();

    public void initList(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("D:\\Uni\\2 yaerz\\Прик.програмування\\mavenLab4\\src\\main\\java\\lab4\\Runner\\DataBaseIncome.txt"));
            int i = 0;
            String number;
            while(i <12){
                number = bufferedReader.readLine();
                incomeValue.add(Double.parseDouble(number));
                i++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


        String []month = {"Січень","Лютий","Березень","Квітень","Травень","Червень","Липень","Серпень","Вересень","Жовтень","Листопад","Грудень"};
        int i = 0;
        while(i<12){
            incomeMonth.add(month[i]);
            i++;
        }
    }

    public void printTable(){
        initList();
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        for(int i = 0 ; i<12 ;i++) {
            System.out.printf("|%-30s||  %-10g        |",incomeMonth.get(i),incomeValue.get(i));
            System.out.print("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|\n");
        }
        double sum = getSum();
        System.out.printf("|Сума доходу за рік %-30g   |\n",sum);
    }

    public void start(){
        System.out.println("|-Ваш дохід за цей рік                               |");
        printTable();
    }
    
    public double getSum(){
        double sum= 0;
        for(int i = 0;i<12;i++){
            sum += incomeValue.get(i);
        }
        return sum;
    }

    public double getValueByIndex(int index){
        return incomeValue.get(index);
    }

    public String getMonthByIndex(int index){
        return incomeMonth.get(index);
    }

}
