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
        boolean endOfPlayerHand = false;
        boolean endOfComputerHand = false;
        int response = 1;
        Money money = new Money();
        System.out.println("Welcome to Blackjack!");
        // System.out.println("Your starting budget is " + Money.getInitialBudget());

        System.out.println("Your starting budget is " + money.getInitialBudget());
        System.out.println(
                "How much would you like to bet?: Type in the number corresponding to your bet: $5(5), $25(25), $50(50), $100(100) OR type 0 to leave table");
        int bet = scanner.nextInt();
        money.setBetAmount(bet);
        while (money.getInitialBudget() > 0 && money.getMoneyAfterBet() >= 0) {

            while (bet != 0 && bet != 5 && bet != 25 && bet != 50 && bet != 100) {
                System.out.println(
                        "Enter in a valid bet amount please!\nType in the number corresponding to your bet: $5(5), $25(25), $50(50), $100(100)");
                bet = scanner.nextInt();

            }

            money.setBetAmount(bet);
            money.setInitialBudget(money.getMoneyAfterBet());
            if (bet == 0) {

                break;
            } else if (money.getInitialBudget() < 0 && money.getMoneyAfterBet() < 0) {
                break;
            }
            // money.setBetAmount(bet);

            System.out.println("Your bet amount is $" + money.getBetAmount());
            // System.out.println("Your remaining money is " + money.getMoneyAfterBet());
            // money.setInitialBudget(money.getMoneyAfterBet());
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

            while (endOfHand == false) {

                if (computerHand.cardsValue() == 21 && playerHand.cardsValue() != 21) {
                    System.out.println("Dealer has 21, you lose the hand and your bet.");
                    endOfPlayerHand = true;
                    endOfComputerHand = true;
                    endOfHand = true;
                }

                if (computerHand.cardsValue() == 21 && playerHand.cardsValue() == 21) {
                    System.out.println(
                            "You and the dealer have 21, so it's a push. You keep your bet but don't win any money.");
                    endOfPlayerHand = true;
                    endOfComputerHand = true;
                    endOfHand = true;
                }
                if (playerHand.cardsValue() == 21) {
                    System.out.println("BLACKJACK! You win!");
                    endOfPlayerHand = true;
                    endOfComputerHand = true;
                    endOfHand = true;
                }

                if (endOfHand == false) {
                    System.out.println(
                            "Would you like to Hit(1) or Stand(2)? Enter the number corresponding to the commands.");
                    response = scanner.nextInt();
                }

                while (endOfPlayerHand == false) {
                    if (playerHand.cardsValue() > 21) {
                        System.out.println("You busted, because your cards value is " + playerHand.cardsValue()
                                + ". The dealer wins and you lose the bet.");
                        endOfPlayerHand = true;
                        endOfComputerHand = true;
                        endOfHand = true;
                    } else if (response == 2) {
                        System.out.println("You stand at " + playerHand.cardsValue());
                        endOfPlayerHand = true;
                    } else if (response == 1) {
                        playerHand.draw(deck1);
                        System.out.println("Your drew a " + playerHand.getCard(playerHand.deckSize() - 1));
                        System.out.println("Your cards value is now " + playerHand.cardsValue());
                        if (playerHand.cardsValue() > 21) {
                            // System.out.println("You busted, because your cards value is " +
                            // playerHand.cardsValue()
                            // + ". The dealer wins and you lose the bet.");
                            endOfComputerHand = true;
                            endOfPlayerHand = true;
                            // endOfHand = true;
                        } else {
                            System.out.println(
                                    "Would you like to Hit(1) or Stand(2)? Enter the number corresponding to the commands.");
                            response = scanner.nextInt();
                        }
                        if (response == 2) {
                            System.out.println("You stand at " + playerHand.cardsValue());
                            endOfPlayerHand = true;
                        } else {
                            endOfPlayerHand = false;
                        }
                    }

                }

                while (endOfComputerHand == false) {
                    while (computerHand.cardsValue() < 17) {
                        computerHand.draw(deck1);
                        System.out.println("Dealer drew a " + computerHand.getCard(computerHand.deckSize() - 1));
                        if (computerHand.cardsValue() > 21) {
                            System.out.println("The dealer busts, you win the hand!");
                            endOfComputerHand = true;
                            endOfHand = true;
                        }

                    }
                    if (computerHand.cardsValue() <= 21) {
                        System.out.println("The dealer stays at " + computerHand.cardsValue());
                        endOfComputerHand = true;
                    }

                }

                // if (playerHand.cardsValue() == computerHand.cardsValue()) {
                // System.out.println("You and the dealer push! You get your money back.");
                // endOfHand = true;
                // } else if (playerHand.cardsValue() > computerHand.cardsValue()) {
                // System.out.println("You win!");
                // endOfHand = true;
                // } else if (playerHand.cardsValue() < computerHand.cardsValue()) {
                // System.out.println("You lost.");
                // endOfHand = true;
                // }
                break;
            }

            System.out.println("Want to bet again or 0 for quit?");
            bet = scanner.nextInt();
            if (bet != 0) {
                endOfHand = false;
                endOfPlayerHand = false;
            }

        }

        System.out.println("We will see you next time!");
    }

}
