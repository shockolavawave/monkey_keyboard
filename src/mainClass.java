import java.io.FileWriter;
import java.io.IOException;
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

        String[] len_final = lengths.toArray(new String[0]);
        String[] cou_final = counts.toArray(new String[0]);

        try (FileWriter fw = new FileWriter("./" + limit + "_list.csv")) {

            for (int i = 0; i < len_final.length; i++)
                fw.write(len_final[i] + "," + cou_final[i] + "\n");

            System.out.println("file printed successfully!\n" +
                    "Total words: " + bufArr.length);

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    } // end of main function
} // end of main clas