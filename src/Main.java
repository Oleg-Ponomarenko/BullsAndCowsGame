import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;
        final Random rand = new Random();
        number = rand.nextInt(8999) + 1000;
        System.out.println("I generated a four-digit number. Try to guess it." + number);

        //Массив для хранения недоопределённых чисел
        boolean[][] unused;
        unused = new boolean[4][10];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j ++) {
                unused[i][j] = true;
            }
        }

        boolean rightAns = false;
        boolean otherNums = true;
        Scanner in = new Scanner(System.in);
        while (!rightAns && otherNums) {
            int answer = in.nextInt();

            unused[0][answer / 1000] = false;
            unused[1][(answer / 100) % 10] = false;
            unused[2][(answer / 10) % 10] = false;
            unused[3][answer % 10] = false;

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

            if (rightAns) {
                otherNums = false;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 10; j ++) {
                        if (unused[i][j]) {
                            otherNums = true;
                            number = (number - (number / (int)Math.pow(10, (3 - i))) % (int)Math.pow(10, i)) + j * (int)Math.pow(10, (3 - i));
                            rightAns = false;
                            System.out.println("Number changed: " + number);
                        }
                    }
                }
            }
        }
        System.out.println("4 bulls. The number was " + number);
    }
}
