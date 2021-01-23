package lab4.Pack;

import java.util.Scanner;

public class TaxesCalculator {

    private double res;
    private double []result = new double[1];

    public double countTransfer(double sum){
        res = (sum*17)/100;
        return res;
    }

    public double countSelling(double sum){
        res = (sum*15)/100;
        return res;
    }

    public double countGifts(double sum){
        res = (sum*5)/100;
        return res;
    }

    public double countIncome(double sum){
        res = (sum*8)/100;
        return res;
    }

    public double countChild(double sum){
        res = sum*2950;
        return res;
    }

    public String countTransfer(double sum1,double sum2){
        result[0] = (sum1*17)/100;
        result[1] = (sum2*17)/100;
        return "| "+result[0] + " | " + result[1];
    }

    public String countSelling(double sum1,double sum2){
        result[0] = (sum1*15)/100;
        result[1] = (sum2*15)/100;
        return "| "+result[0] + " | " + result[1];
    }

    public String counttGifts(double sum1,double sum2){
        result[0] = (sum1*5)/100;
        result[1] = (sum2*5)/100;
        return "| "+result[0] + " | " + result[1];
    }

    public String countIncome(double sum1,double sum2){
        result[0] = (sum1*8)/100;
        result[1] = (sum2*8)/100;
        return "| "+result[0] + " | " + result[1];
    }

    public String countChild(double sum1,double sum2){
        result[0] = sum1*2950;
        result[1] = sum2*2950;
        return "| "+result[0] + " | " + result[1];
    }
}
