package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class ChildTaxes implements Command {
    DataBase dataBase;

    public ChildTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.childTaxes();
    }
}
