public class Money {

    // variables
    private int initialBudget = 50;
    private int betAmount;
    private int moneyAfterBet;

    // constructor

    // Getters

    public int getBetAmount() {
        return betAmount;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public int getMoneyAfterBet() {
        // initial budget minus bet amount / wins / loss
        moneyAfterBet = initialBudget - betAmount;
        // initialBudget = moneyAfterBet;
        return moneyAfterBet;

    }

    // Setters

    public void setInitialBudget(int moneyAfterBetWinLoss) {
        this.initialBudget = moneyAfterBetWinLoss;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

}
