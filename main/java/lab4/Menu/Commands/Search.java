package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class Search implements Command {
    DataBase dataBase = new DataBase();

    public Search(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.search();
    }
}
