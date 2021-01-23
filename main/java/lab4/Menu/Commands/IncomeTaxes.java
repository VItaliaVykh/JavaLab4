package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class IncomeTaxes implements Command {
    DataBase dataBase;

    public IncomeTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.incomeTaxes();
    }
}
