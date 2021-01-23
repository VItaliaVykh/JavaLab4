package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class FinancialAidTaxes implements Command {
    DataBase dataBase;

    public FinancialAidTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public void execute() {
        dataBase.financialAidTaxes();
    }
}
