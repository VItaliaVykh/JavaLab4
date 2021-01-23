package lab4;


import lab4.Pack.IncomeCollector;
import lab4.Pack.TaxesCollector;

public class DataBase {

    private TaxesCollector taxesCollector = new TaxesCollector();

    public void help(){
        System.out.println("|-Перелік команд:                                    |" +
                "\n|-допомога                                           |"+
                "\n|-податки з доходів                                  |"+
                "\n|-авторські винагороди                               |"+
                "\n|-продаж майна                                       |"+
                "\n|-отримання в подарунок сум і майна                  |"+
                "\n|-перекази з-за кордону                              |"+
                "\n|-пільги на дітей                                    |"+
                "\n|-матеріальна допомога                               |"+
                "\n|-мій дохід                                          |"+
                "\n|-пошук                                              |"+
                "\n|-вийти                                              |");

    }
    
    public void myIncome(){
        IncomeCollector incomeCollector = new IncomeCollector();
        incomeCollector.start();
    }

    public void giftingTaxes(){
            taxesCollector.getGiftingTaxes();
    }

    public void financialAidTaxes(){
        taxesCollector.getFinancialAidTaxes();
    }

    public void childTaxes(){
        taxesCollector.getChildTaxes();
    }

    public void RoyaltiesTaxes(){
        taxesCollector.getRoyaltiesTaxes();

    }

    public void sellPropertyTaxes(){
        System.out.println("|-Звичайна ставка податку складає  5%                |");
        taxesCollector.getSellPropertyTaxes();
    }

    public void incomeTaxes(){
        System.out.println("|-Звичайна ставка податку складає 8%                |");
        taxesCollector.getIncomeTaxes();
    }

    public void transferTaxes(){
            taxesCollector.getTransferTaxes();
    }

    public void search(){
        taxesCollector.searchData();
    }
}
