package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class TransferTaxes implements Command {
    DataBase dataBase;

    public TransferTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.transferTaxes();
    }
}
