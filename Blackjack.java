import java.util.Scanner;       // Scanner will be used mutliple times
public class Blackjack {
    public static void main(String [] args) {
        System.out.println();
        System.out.println("BLACKJACK: INSTRUCTIONS");      // instructions
        System.out.println("Hi! I am Joel, a computer, serving as an opponent in the game of Blackjack. Before we begin, let me tell you how it works.");
        System.out.println("I will deal you two cards, and if the sum of all your cards is 21 (face cards count as 10 and ace counts as 1 or 11), you win! Otherwise, I deal");
        System.out.println("myself 2 cards, one face up, one face down. You can choose to take a hit (take a card) or stay (let me have a turn). As you take");
        System.out.println("hits, if you get 21, you win, but if you go over 21, you lose. If you stay, I take hits until I have a total of 17+. If I get 21 ever,");
        System.out.println("I win. If I exceed 21, I lose. If I get in between 17 and 21, whoever has the higher card sum wins. You can bet money as well.");
        System.out.println("LET'S START A NEW GAME - GOOD LUCK");
        System.out.println();
        game(0);
    }
    public static void game(int m) {
        System.out.println("------ NEW GAME ----------------------");
        System.out.println();
        System.out.println();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);            // will be used seperately 3 times
        UserCard [] uCard = new UserCard[21];               // uCard linked with UserCard class
        DealerCard [] dCard = new DealerCard[21];           // dCard linked with DealerCard class
        int i;
        for (i = 0; i < 21; i++) {                          // creating new classes for all 21 of each class
            uCard[i] = new UserCard();
            dCard[i] = new DealerCard();
        }
        int money = m;
        int bet;
        int j = 2;
        int [][] uvalueArray = new int[2][21];
        String [] ucardArray = new String[21];
        int [][] dvalueArray = new int[2][21];
        String [] dcardArray = new String[21];
        System.out.print("How many dollars would you like to bet: ");
        bet = input.nextInt();          // money in pot
        ucardArray[0] = uCard[0].getDeck((int) (52 * Math.random()));       // sets user card #1
        uCard[0].setValue(ucardArray[0].charAt(0));
        uCard[0].setNumber(ucardArray[0].charAt(0));
        uCard[0].setType(ucardArray[0].charAt(1));
        uvalueArray[0][0] = uCard[0].getValue()[0];
        uvalueArray[1][0] = uCard[0].getValue()[1];
        ucardArray[1] = uCard[1].getDeck((int) (52 * Math.random()));       // sets user card #2
        uCard[1].setValue(ucardArray[1].charAt(0));
        uCard[1].setNumber(ucardArray[1].charAt(0));
        uCard[1].setType(ucardArray[1].charAt(1));
        uvalueArray[0][1] = uCard[1].getValue()[0];
        uvalueArray[1][1] = uCard[1].getValue()[1];
        dcardArray[0] = dCard[0].getDeck((int) (52 * Math.random()));       // sets dealer card #1
        dCard[0].setValue(dcardArray[0].charAt(0));
        dCard[0].setNumber(dcardArray[0].charAt(0));
        dCard[0].setType(dcardArray[0].charAt(1));
        dvalueArray[0][0] = dCard[0].getValue()[0];
        dvalueArray[1][0] = dCard[0].getValue()[1];
        dcardArray[1] = dCard[1].getDeck((int) (52 * Math.random()));       // sets dealer card #2
        dCard[1].setValue(dcardArray[1].charAt(0));
        dCard[1].setNumber(dcardArray[1].charAt(0));
        dCard[1].setType(dcardArray[1].charAt(1));
        dvalueArray[0][1] = dCard[1].getValue()[0];
        dvalueArray[1][1] = dCard[1].getValue()[1];
        System.out.println("You have:");                // lists cards
        System.out.println(uCard[0].getNumber() + " of " + uCard[0].getType());
        System.out.println(uCard[1].getNumber() + " of " + uCard[1].getType());
        System.out.println();
        if (sum(uvalueArray[0]) == 21 || sum(uvalueArray[1]) == 21) {
            System.out.println("You win! You got 21.");
            money += bet;               // if you win, your original money is added by the bet
            execution(money);           // lets you play again while keeping the money remembered without constantly resetting it
        }
        else {
            if (sum(dvalueArray[0]) == 21 || sum(dvalueArray[1]) == 21) {
                System.out.println("I have:");
                System.out.println(dCard[0].getNumber() + " of " + dCard[0].getType());
                System.out.println(dCard[1].getNumber() + " of " + dCard[1].getType());
                System.out.println();
                System.out.println("I win! I got 21.");
                money -= bet;           // if you lose, your original money is subtracted by the bet
                execution(money);
            }
            else {
                System.out.println("I have:");
                System.out.println(dCard[0].getNumber() + " of " + dCard[0].getType());
                System.out.println("(HIDDEN CARD)");
                System.out.println();
                System.out.print("Hit me(h) or Stay(s): ");
                char ans = input2.nextLine().charAt(0);
                if (ans == 'h') {       // if player takes hit
                    while (sum(uvalueArray[0]) < 21 || sum(uvalueArray[1]) < 21) {      // while player can still take hit
                        if (ans != 'h') {
                            break;
                        }
                        ucardArray[j] = uCard[j].getDeck((int) (52 * Math.random()));   // sets new card
                        uCard[j].setValue(ucardArray[j].charAt(0));
                        uCard[j].setNumber(ucardArray[j].charAt(0));
                        uCard[j].setType(ucardArray[j].charAt(1));
                        uvalueArray[0][j] = uCard[j].getValue()[0];
                        uvalueArray[1][j] = uCard[j].getValue()[1];
                        System.out.println();
                        System.out.println("You have:");
                        for (i = 0; i < j + 1; i++) {
                            System.out.println(uCard[i].getNumber() + " of " + uCard[i].getType());
                        }
                        j++;
                        if (sum(uvalueArray[0]) < 21 || sum(uvalueArray[1]) < 21) {     // lets player take hit
                            System.out.println();
                            System.out.print("Hit me(h) or Stay(s): ");
                            ans = input3.nextLine().charAt(0);
                        }
                    }
                    if (sum(uvalueArray[0]) == 21 || sum(uvalueArray[1]) == 21) {
                        System.out.println();
                        System.out.println("You win! You got 21.");
                        money += bet;
                        execution(money);
                    }
                    else if (sum(uvalueArray[0]) > 21 && sum(uvalueArray[1]) > 21) {    // exceeding 21 = losing/busted
                        System.out.println();
                        System.out.println("I win! You busted. You got " + sum(uvalueArray[0]));
                        money -= bet;
                        execution(money);
                    }
                }
                if (ans == 's') {       // if player stays
                    System.out.println();
                    System.out.println("I have:");
                    for (i = 0; i < 2; i++) {
                        System.out.println(dCard[i].getNumber() + " of " + dCard[i].getType());
                    }
                    j = 2;
                    while (sum(dvalueArray[0]) < 17 || sum(dvalueArray[1]) < 17) {      // takes hits until 17 or over
                        dcardArray[j] = dCard[j].getDeck((int) (52 * Math.random()));
                        dCard[j].setValue(dcardArray[j].charAt(0));
                        dCard[j].setNumber(dcardArray[j].charAt(0));
                        dCard[j].setType(dcardArray[j].charAt(1));
                        dvalueArray[0][j] = dCard[j].getValue()[0];
                        dvalueArray[1][j] = dCard[j].getValue()[1];
                        System.out.print("Adding on: ");
                        System.out.println(dCard[j].getNumber() + " of " + dCard[j].getType());
                        j++;
                    }
                    System.out.println();
                    if (sum(dvalueArray[0]) == 21 || sum(dvalueArray[1]) == 21) {       // it wins if manages to get 21
                        System.out.println("I win! I got 21.");
                        money -= bet;
                        execution(money);
                    }
                    else if (sum(dvalueArray[0]) > 21 && sum(dvalueArray[1]) > 21) {    // it loses if exceeds 21
                        System.out.println("You win! I busted. I got " + sum(dvalueArray[0]));
                        money += bet;
                        execution(money);
                    }
                    else if (sum(dvalueArray[0]) >= 17) {                               // if 17 <= card sum < 21, whoever has the highest card wins
                        if (sum(uvalueArray[1]) < 21) {
                            if (sum(dvalueArray[0]) < sum(uvalueArray[1])) {
                                System.out.println("You win! " + sum(uvalueArray[1]) + " beats " + sum(dvalueArray[0]));
                                money += bet;
                                execution(money);
                            }
                            else if (sum(dvalueArray[0]) == sum(uvalueArray[1])) {
                                System.out.println("Draw. Nobody wins. " + sum(dvalueArray[0]) + " equals " + sum(uvalueArray[1]));
                                execution(money);
                            }
                            else {
                                System.out.println("I win! " + sum(dvalueArray[0]) + " beats " + sum(uvalueArray[1]));
                                money -= bet;
                                execution(money);
                            }
                        }
                        else {
                            if (sum(dvalueArray[0]) < sum(uvalueArray[0])) {
                                System.out.println("You win! " + sum(uvalueArray[0]) + " beats " + sum(dvalueArray[0]));
                                money += bet;
                                execution(money);
                            }
                            else if (sum(dvalueArray[0]) == sum(uvalueArray[0])) {
                                System.out.println("Draw. Nobody wins. " + sum(dvalueArray[0]) + " equals " + sum(uvalueArray[0]));
                                execution(money);
                            }
                            else {
                                System.out.println("I win! " + sum(dvalueArray[0]) + " beats " + sum(uvalueArray[0]));
                                money -= bet;
                                execution(money);
                            }
                        }
                    }
                    else if (sum(dvalueArray[1]) >= 17) {
                        if (sum(uvalueArray[1]) < 21) {
                            if (sum(dvalueArray[1]) < sum(uvalueArray[1])) {
                                System.out.println("You win! " + sum(uvalueArray[1]) + " beats " + sum(dvalueArray[1]));
                                money += bet;
                                execution(money);
                            }
                            else if (sum(dvalueArray[1]) == sum(uvalueArray[1])) {
                                System.out.println("Draw. Nobody wins. " + sum(dvalueArray[1]) + " equals " + sum(uvalueArray[1]));
                                execution(money);
                            }
                            else {
                                System.out.println("I win! " + sum(dvalueArray[1]) + " beats " + sum(uvalueArray[1]));
                                money -= bet;
                                execution(money);
                            }
                        }
                        else {
                            if (sum(dvalueArray[1]) < sum(uvalueArray[0])) {
                                System.out.println("You win! " + sum(uvalueArray[0]) + " beats " + sum(dvalueArray[1]));
                                money += bet;
                                execution(money);
                            }
                            else if (sum(dvalueArray[1]) == sum(uvalueArray[0])) {
                                System.out.println("Draw. Nobody wins. " + sum(dvalueArray[1]) + " equals " + sum(uvalueArray[0]));
                                execution(money);
                            }
                            else {
                                System.out.println("I win! " + sum(dvalueArray[1]) + " beats " + sum(uvalueArray[0]));
                                money -= bet;
                                execution(money);
                            }
                        }
                    }
                }
                if (ans != 'h' && ans != 's') {
                    System.out.println();
                    System.out.println("ERROR: Not a real action in Blackjack");
                }
            }
        }
    }
    public static void execution(int nM) {
        int i;
        Scanner input = new Scanner(System.in);
        for (i = 0; i < 5; i++) {
            System.out.println();
        }
        System.out.println("Your total money is: " + nM + " dollars");      // displays money
        System.out.print("Play again? yes(y) - no(n) ");
        if (input.nextLine().charAt(0) == 'y') {
            for (i = 0; i < 5; i++) {
                System.out.println();
            }
            game(nM);
        }
        else {
            for (i = 0; i < 5; i++) {
                System.out.println();
            }
            System.out.println("Thank you for playing. You have exited the game.");
            System.out.println();
        }
    }
    public static int sum(int [] arr) {     // quick little method for summing an array (would have taken too long to do individually)
        int i;
        int summation = 0;
        for (i = 0; i < arr.length - 1; i++) {
            summation += arr[i];
        }
        return summation;
    }
}