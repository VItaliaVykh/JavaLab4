package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class SellPropertyTaxes implements Command {
    DataBase dataBase;

    public SellPropertyTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.sellPropertyTaxes();
    }
}
