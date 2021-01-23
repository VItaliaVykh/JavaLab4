package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class RoyaltiesTaxes implements Command {
    DataBase dataBase;

    public RoyaltiesTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.RoyaltiesTaxes();
    }
}
