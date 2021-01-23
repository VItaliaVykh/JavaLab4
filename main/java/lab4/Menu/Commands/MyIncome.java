package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class MyIncome implements Command {
    DataBase dataBase;

    public MyIncome(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.myIncome();
    }
}
