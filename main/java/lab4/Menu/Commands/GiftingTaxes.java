package lab4.Menu.Commands;


import lab4.DataBase;
import lab4.Menu.Command;

public class GiftingTaxes implements Command {
    DataBase dataBase;

    public GiftingTaxes(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.giftingTaxes();
    }
}
