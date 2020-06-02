import java.util.Random;
import java.util.Scanner;

public class playGame {
    private double initialBudget = 200;
    private double money = 4;
    private double betAmount;

    // constructor
    public playGame() {

    }

    // Play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");
        // System.out.println("Your starting budget is " + Money.getInitialBudget());
        System.out.println("Your starting budget is " + initialBudget);
        System.out.println(
                "How much would you like to bet?: Type in the number corresponding to your bet: $5(5), $25(25), $50(50), $100(100) OR type 0 to leave table");
        money.setBetAmount() = scanner.nextInt();
        while (money.getBetAmount() != 0 && money.getMoney > 4) {

            System.out.println("your bet is $" + betAmount);
            if (betAmount != 5 || betAmount != 25 || betAmount != 50 || betAmount != 100) {
                System.out.println(
                        "Enter in a valid bet amount please!\nType in the number corresponding to your bet: $5(5), $25(25), $50(50), $100(100)");
            }

        }
        System.out.println("We will see you next time!");
    }

    public void Deal() {

        Deck.shuffle();

    }

}