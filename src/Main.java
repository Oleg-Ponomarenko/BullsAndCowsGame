import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;
        final Random rand = new Random();
        number = rand.nextInt(8999) + 1000;
        System.out.println("I generated a four-digit number. Try to guess it.");

        boolean rightAns = false;
        Scanner in = new Scanner(System.in);
        while (!rightAns) {
            int answer = in.nextInt();
            byte bulls = 0;

            if (answer % 10 == number % 10) {
                bulls += 1;
            }
            if ((answer / 10) % 10 == (number / 10) % 10) {
                bulls += 1;
            }
            if ((answer / 100) % 10 == (number / 100) % 10) {
                bulls += 1;
            }
            if (answer / 1000 == number / 1000) {
                bulls += 1;
            }

            if (bulls == 4) {
                rightAns = true;
            }
            else {
                System.out.println(bulls + " bulls and " + (4 - bulls) + " cows");
            }
        }
        System.out.println("4 bulls. The number was " + number);
    }
}
