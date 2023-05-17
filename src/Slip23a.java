import java.util.Scanner;

 

public class Slip23a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");

        String input = scanner.nextLine().toLowerCase();

 

        for (char c : input.toCharArray()) {

            if (isVowel(c)) {

                System.out.println(c);

                try {

                    Thread.sleep(3000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        }

    }

 

    private static boolean isVowel(char c) {

        return "aeiou".indexOf(c) != -1;

    }

}

 