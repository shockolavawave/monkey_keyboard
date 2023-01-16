import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class monkeyGo {

    private int length;
    private String rawString;
    private String[] words;


    public int getLength() {    return length;    }
    public void setLength(int length) {     this.length = length;    }
    ///
    public String getRawString() {      return rawString;    }
    public void setRawString(String rawString) {    this.rawString = rawString;    }
    ///
    public String[] getWords() {    return words;    }
    public void setWords(String[] words) {      this.words = words;    }

    public monkeyGo(int len) {

        this.setLength(len);

        String[] letters = {" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random rd = new Random();

        StringBuilder buf = new StringBuilder();

        // getting raw string
        for (int i = 0; i < this.getLength(); i++)
            buf.append(letters[rd.nextInt(27)]);

        this.setRawString(buf.toString());

        this.setWords(this.getRawString().split(" "));
        Arrays.sort(this.getWords(), Comparator.comparingInt(String::length));

    }
}
