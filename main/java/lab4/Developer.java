package lab4;


import lab4.Menu.Command;

public class Developer {
    Command help;
    Command incomes;
    Command child;
    Command transfer;
    Command selling;
    Command gifting;
    Command financial;
    Command royalty;
    Command myIncome;
    Command search;

    public Developer(Command help, Command incomes, Command child, Command transfer, Command selling, Command gifting, Command financial, Command royalty,Command myIncome,Command search) {
        this.help = help;
        this.incomes = incomes;
        this.child = child;
        this.transfer = transfer;
        this.selling = selling;
        this.gifting = gifting;
        this.financial = financial;
        this.royalty = royalty;
        this.myIncome= myIncome;
        this.search = search;
    }

    public void helpCommand(){
        help.execute();
    }

    public void incomesCommand(){
        incomes.execute();
    }

    public void childCommand(){
        child.execute();
    }

    public void transferCommand(){
        transfer.execute();
    }

    public void sellingCommand(){
        selling.execute();
    }

    public void giftingCommand(){
        gifting.execute();
    }

    public void financialCommand(){
        financial.execute();
    }

    public void royaltyCommand(){
        royalty.execute();
    }

    public void MyIncomeCommand(){
        myIncome.execute();
    }

    public void searchCommand(){
        search.execute();
    }
}
