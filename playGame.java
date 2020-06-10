import java.util.Scanner;

public class playGame {
    // constructor
    public playGame() {

    }

    // Play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        // int response = 1;
        boolean endOfHand = false;
        boolean endOfPlayerHand = false;
        boolean endOfComputerHand = false;
        int response = 1;
        Money money = new Money();

        System.out.println(
                "\n$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$");
        System.out.println(
                "$                                                                                                           $");
        System.out.println(
                "$                ######  ##       #####   #####  ##   ##  ##### #####   #####  ##   ##                      $");
        System.out.println(
                "$                ##   ## ##      ##   ## ##   ## ##   ##    ## ##   ## ##   ## ##   ##                      $");
        System.out.println(
                "$                ##   ## ##      ##   ## ##      ##  ##     ## ##   ## ##      ##  ##                       $");
        System.out.println(
                "$                ######  ##      ####### ##      #####      ## ####### ##      #####                        $");
        System.out.println(
                "$                ##   ## ##      ##   ## ##      ##  ##     ## ##   ## ##      ##  ##                       $");
        System.out.println(
                "$                ##   ## ##      ##   ## ##   ## ##   ## ## ## ##   ## ##   ## ##   ##                      $");
        System.out.println(
                "$                ######  ####### ##   ##  #####  ##   ##  ###  ##   ##  #####  ##   ##                      $");
        System.out.println(
                "$                                                                                                           $");
        System.out.println(
                "$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$");

        System.out.println("\nWelcome to Blackjack!\n");
        System.out.println("Your starting balance is $" + money.getInitialBudget());
        System.out.println(
                "\nHow much would you like to bet?: \nBet in increments of 5. \nType in the number corresponding to your bet (ex: $5(5) or $10(10)) \n OR \nType 0 to leave table");
        int bet = scanner.nextInt();
        money.setBetAmount(bet);
        while (money.getInitialBudget() > 0 && money.getMoneyAfterBet() >= 0) {

            // while (bet != 0 && bet != 5 && bet != 25 && bet != 50 && bet != 100) {
            while (bet % 5 != 0 && bet != 0) {
                // System.out.println(
                // "Enter in a valid bet amount please!\nType in the number corresponding to
                // your bet: $5(5), $25(25), $50(50), $100(100)");
                System.out.println("Enter in a valid bet amount please!\nBet in increments of 5.");
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

            System.out.println("\nYour bet amount is $" + money.getBetAmount());
            // System.out.println("Your remaining money is " + money.getMoneyAfterBet());
            // money.setInitialBudget(money.getMoneyAfterBet());
            System.out.println("your remaining balance is $" + money.getInitialBudget());

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

            System.out.println("\n---------------------------\nYour hand is:");
            System.out.println(playerHand.toString());
            // System.out.println("Your cards are " + playerHand.getCard(0) + " and " +
            // playerHand.getCard(1));
            System.out.println("\nThe total value of your hand is " + playerHand.cardsValue());

            System.out.println("The dealer's hand is " + computerHand.getCard(0).toString()
                    + " and [hidden]\n---------------------------");

            // System.out.println(playerHand);
            // System.out.println(computerHand);
            // System.out.println(deck1);

            while (endOfHand == false) {

                if (computerHand.cardsValue() == 21 && playerHand.cardsValue() != 21) {
                    System.out.println("Dealer has 21, you lose the hand and your bet.");
                    // endOfPlayerHand = true;
                    // endOfComputerHand = true;
                    // endOfHand = true;
                    break;
                }

                if (computerHand.cardsValue() == 21 && playerHand.cardsValue() == 21) {
                    System.out.println(
                            "You and the dealer have 21, so it's a push. You keep your bet but don't win any money.");
                    money.setInitialBudgetAfterPush(bet);
                    // endOfPlayerHand = true;
                    // endOfComputerHand = true;
                    // endOfHand = true;
                    break;
                }
                if (playerHand.cardsValue() == 21) {
                    System.out.println("BLACKJACK! You win!");
                    money.setInitialBudgetAfterWin(bet);
                    // endOfPlayerHand = true;
                    // endOfComputerHand = true;
                    // endOfHand = true;
                    break;
                }

                if (endOfHand == false) {
                    System.out.println(
                            "Would you like to Hit(1) or Stand(2)? Enter the number corresponding to the commands.");
                    response = scanner.nextInt();
                }

                while (endOfPlayerHand == false) {
                    if (playerHand.cardsValue() > 21) {
                        System.out.println("---------------------------\nThe dealer's hand is "
                                + computerHand.getCard(0).toString() + " and " + computerHand.getCard(1).toString()
                                + "\nYou busted, because your cards value is " + playerHand.cardsValue()
                                + ". The dealer wins and you lose the bet.");
                        endOfPlayerHand = true;
                        endOfComputerHand = true;
                        endOfHand = true;

                    } else if (response == 2) {
                        System.out.println("---------------------------\nYou stand at " + playerHand.cardsValue());
                        endOfPlayerHand = true;
                        endOfComputerHand = false;
                    } else if (response == 1) {
                        playerHand.draw(deck1);
                        System.out.println("---------------------------\nYour drew a "
                                + playerHand.getCard(playerHand.deckSize() - 1));
                        System.out.println("Your cards value is now " + playerHand.cardsValue());
                        System.out.println(
                                "The dealer's hand is " + computerHand.getCard(0).toString() + " and [hidden]");
                        if (playerHand.cardsValue() > 21) {
                            // System.out.println("You busted, because your cards value is " +
                            // playerHand.cardsValue()
                            // + ". The dealer wins and you lose the bet.");
                            endOfComputerHand = true;
                            endOfPlayerHand = true;
                            // endOfHand = true;
                        } else {
                            System.out.println(
                                    "---------------------------\nWould you like to Hit(1) or Stand(2)? Enter the number corresponding to the commands.");
                            response = scanner.nextInt();
                        }
                        if (response == 2) {
                            System.out.println("---------------------------\nYou stand at " + playerHand.cardsValue());
                            endOfPlayerHand = true;
                            endOfComputerHand = false;
                        } else {
                            endOfPlayerHand = false;
                        }
                    }

                }

                while (endOfComputerHand == false) {
                    System.out.println("---------------------------\nThe dealer's hand is "
                            + computerHand.getCard(0).toString() + " and " + computerHand.getCard(1).toString());
                    while (computerHand.cardsValue() < 17) {
                        computerHand.draw(deck1);
                        System.out.println("Dealer drew a " + computerHand.getCard(computerHand.deckSize() - 1));
                        if (computerHand.cardsValue() > 21) {
                            System.out.println("The dealer busts, you win the hand!");
                            money.setInitialBudgetAfterWin(bet);
                            endOfComputerHand = true;
                            endOfHand = true;

                        }

                    }
                    if (computerHand.cardsValue() <= 21) {
                        System.out.println("The dealer stays at " + computerHand.cardsValue());
                        endOfComputerHand = true;
                    }

                }

                while (endOfComputerHand == true && endOfPlayerHand == true && computerHand.cardsValue() <= 21
                        && playerHand.cardsValue() <= 21) {
                    if (playerHand.cardsValue() == computerHand.cardsValue()) {
                        System.out.println(
                                "---------------------------\nYou and the dealer push! You get your money back.");
                        money.setInitialBudgetAfterPush(bet);
                        endOfHand = true;
                        break;
                    } else if (playerHand.cardsValue() > computerHand.cardsValue()) {
                        System.out.println("---------------------------\nYou win!");
                        money.setInitialBudgetAfterWin(bet);
                        endOfHand = true;
                        break;
                    } else if (playerHand.cardsValue() < computerHand.cardsValue()) {
                        System.out.println("---------------------------\nYou lost.");
                        endOfHand = true;
                        break;
                    }

                }

            }

            playerHand.moveAllToDeck(deck1);
            computerHand.moveAllToDeck(deck1);

            System.out.println("Your remaining balance is $" + money.getInitialBudget());
            System.out.println("---------------------------\nWant to bet again or 0 for quit?");
            bet = scanner.nextInt();
            if (bet != 0) {
                endOfHand = false;
                endOfPlayerHand = false;
                endOfComputerHand = false;
            }

        }

        if (money.getInitialBudget() == 0) {
            System.out.println("You are out of money. Come back when you have more to lose!");
        } else if (money.getMoneyAfterBet() < 0) {
            System.out.println("You bet more than you have. Bet within your means please");
        } else {
            System.out.println("We will see you next time!");
        }
    }

}
