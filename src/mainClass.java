import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {

    static Scanner scObj = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Hello world!");


        int limit = 0;
        try {
            System.out.print("Enter character limit (min. 100) : ");
            limit = scObj.nextInt();

            if (limit < 100)
                throw new Exception("number too short");

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input! Try re-running");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Limit too short. Try re-running.");
            System.exit(0);
        }

        monkeyGo bulk =  new monkeyGo(limit); // remote call

        // printing a word per line
        for (String s :
                bulk.getWords()) {
            System.out.println(s);
        }

        String[] bufArr = bulk.getWords();
        ArrayList<String> lengths = new ArrayList<>();
        ArrayList<String> counts = new ArrayList<>();

        // counting all words with respect to length
        for (int i = 0, j = 0, cou = 0; j < bufArr.length; i++) {

            // i is for length's and counts' length
            // j is for traversing through bufArr
            // cou is for counting elements of respective length

            // initiation
            lengths.add(i, Integer.toString(bufArr[j].length()));
            cou++;
            j++;

            while ( j < bufArr.length &&
                    (bufArr[j].length() == Integer.parseInt(lengths.get(i)))) {
                cou++;
                j++;
            } // of while loop

            counts.add(i, Integer.toString(cou));
            cou = 0;

        } // end of for loop

        for (int i = 0; i < lengths.size(); i++)
            System.out.println(lengths.get(i) + "   ->   " + counts.get(i));

    } // end of main function
} // end of main clas