package NPC;

import java.util.Scanner;

public class DiceRoller {

    public static void main(String[] args) {
        // Dice roller with multiple dice - technically not dice as all numbers can be rolled even if dice cannot be made using that number

        runDiceRoller();
        System.out.println("Would you like to roll again?");

        boolean loop = true;

        while (loop) {

            Scanner input = new Scanner(System.in);
            String runAgain = input.nextLine();

            if (runAgain.equalsIgnoreCase("YES") || runAgain.equalsIgnoreCase("Y")) {
                runDiceRoller();
                System.out.println("Would you like to roll again?");
            } else {
                System.out.println("You didn't answer YES");
                loop = false;
            }
        }
    }

    public static void runDiceRoller() {
        String[] diceParameters = getUserInput();
        // get the user to enter both number and type of dice to roll - outputs as an array

        rollDice(diceParameters);
        // roll the dice, using the parameters defined
    }

    public static String[] getUserInput() {
        System.out.println("Enter the number of dice that you want to roll: ");

        Scanner input = new Scanner(System.in);
        String diceNumber = input.nextLine();
            // input number of dice - need to fix so teh user doesn't enter a non-integer

        System.out.println("Enter the type of dice you want to roll: ");

        String diceType = input.nextLine();
            // input type of dice - need to fix so teh user doesn't enter a non-integer
            // would be nice to get both inputted at once (eg 2d2), but that requires splitting the string into separate ints

        while (diceType.equals("1")) {
            System.out.println("That would be pointless... Dice type needs to be bigger than 1");
            diceType = input.nextLine();
                // Makes the user enter a different dice type (ie bigger than 1)
        }

        return new String[]{diceNumber, diceType};
    }

    private static void rollDice(String[] diceParameters) {
            // rolling the dice time
        System.out.println("rolling " + diceParameters[0]+ "d" + diceParameters[1]);

        int number = Integer.parseInt(diceParameters[0]);
            // changes the string to an int (i think)
        int diceTypeRoll = Integer.parseInt(diceParameters[1]);
            // dice type (i need to check if i have to keep changing the names for each part)
        int resultTotal = 0;

        for (int i = 0; i < number; i++) {
                // need to figure why i can't just use n or what i'm doing wrong if you can
            System.out.println("Roll "+ (i + 1));
            int currentRoll = roll(diceTypeRoll);
            System.out.println(currentRoll);
            resultTotal = resultTotal + currentRoll;
                // start with an empty total and add each roll to it as they are completed
        }

        System.out.println("The total is: " + resultTotal);
    }

    private static int roll(int type) {
        // get the random number generator for 1 to "d"

        return (int) (Math.random() * type + 1);
    }

}