package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class Help implements Command {
    DataBase dataBase;

    public Help(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.help();
    }
}
