import java.util.Random;
import java.util.Scanner;

public class playGame {
    // private double initialBudget = 200;
    // private double money = 4;
    // private double betAmount;

    // constructor
    public playGame() {

    }

    // Play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        // int response = 1;
        boolean endOfHand = false;
        boolean endOfGame = false;
        Money money = new Money();
        System.out.println("Welcome to Blackjack!");
        // System.out.println("Your starting budget is " + Money.getInitialBudget());

        System.out.println("Your starting budget is " + money.getInitialBudget());
        System.out.println(
                "How much would you like to bet?: Type in the number corresponding to your bet: $5(5), $25(25), $50(50), $100(100) OR type 0 to leave table");
        int bet = scanner.nextInt();
        money.setBetAmount(bet);
        while (bet != 0 && money.getInitialBudget() > 0 && money.getMoneyAfterBet() >= 0) {

            while (bet != 5 && bet != 25 && bet != 50 && bet != 100) {
                System.out.println(
                        "Enter in a valid bet amount please!\nType in the number corresponding to your bet: $5(5), $25(25), $50(50), $100(100)");
                bet = scanner.nextInt();
                break;
            }

            money.setBetAmount(bet);
            System.out.println("Your bet amount is $" + money.getBetAmount());
            // System.out.println("Your remaining money is " + money.getMoneyAfterBet());
            money.setInitialBudget(money.getMoneyAfterBet());
            System.out.println("your remaining money is $" + money.getInitialBudget());

            Deck deck1 = new Deck();
            deck1.createFullDeck();
            deck1.shuffle();
            // System.out.println(deck1);

            Deck playerHand = new Deck();
            Deck computerHand = new Deck();

            playerHand.draw(deck1);
            computerHand.draw(deck1);
            playerHand.draw(deck1);
            computerHand.draw(deck1);

            System.out.println("Your hand is:");
            System.out.println(playerHand.toString());
            // System.out.println("Your cards are " + playerHand.getCard(0) + " and " +
            // playerHand.getCard(1));
            System.out.println("The total value of your hand is " + playerHand.cardsValue());

            System.out.println("The dealer's hand is " + computerHand.getCard(0).toString() + " and [hidden]");

            // System.out.println(playerHand);
            // System.out.println(computerHand);
            // System.out.println(deck1);

            /*
             * while (endOfHand == false) {
             * 
             * if (computerHand.cardsValue() == 21 && playerHand.cardsValue() != 21) {
             * System.out.println("Dealer has 21, you lose the hand and your bet.");
             * endOfHand = true; }
             * 
             * if (computerHand.cardsValue() == 21 && playerHand.cardsValue() == 21) {
             * System.out.println(
             * "You and the dealer have 21, so it's a push. You keep your bet but don't win any money."
             * ); endOfHand = true; }
             * 
             * System.out.println(
             * "Would you like to Hit(1) or Stand(2)? Enter the number corresponding to the commands."
             * ); int response = scanner.nextInt();
             * 
             * while (response == 1 && playerHand.cardsValue() <= 21) { if (response == 1) {
             * playerHand.draw(deck1); System.out.println("Your drew a " +
             * playerHand.getCard(playerHand.deckSize() - 1)); }
             * 
             * if (playerHand.cardsValue() > 21) { System.out.println(
             * "You busted since your hand value is over 21.\n Dealer wins and you lose your bet."
             * ); endOfHand = true; }
             * 
             * } }
             */
            break;
        }

        System.out.println("We will see you next time!");
    }

}
