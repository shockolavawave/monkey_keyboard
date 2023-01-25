import java.util.*;

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
        // removing nulls
        List<String> li = new ArrayList<>();

        for (String s :
                this.getWords()) {
            if ( s != null && s.length() > 0 )
                li.add(s);
        }

        this.setWords(li.toArray(new String[0]));

        // sorting length wise
        Arrays.sort(this.getWords(), Comparator.comparingInt(String::length));

    }
}
