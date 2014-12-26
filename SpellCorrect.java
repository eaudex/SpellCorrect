
import java.util.*;

public class SpellCorrect {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static Set<String> edit2(String word) {
        if (word == null)
            return null;

        Set<String> out = new HashSet<String>();
        Set<String> out1 = edit(word);
        for (String wd : out1) {
            out.addAll( edit(wd) );
        }
        return out;
    }

    public static Set<String> edit(String word) {
        if (word == null)
            return null;

        Set<String> out = new HashSet<String>();

        // delete
        for (int i=0; i<word.length(); ++i) {
            String wd = word.substring(0,i) + word.substring(i+1,word.length());
            out.add(wd);
        }
        // insert
        for (int i=0; i<=word.length(); ++i) {
            for (int j=0; j<alphabet.length(); ++j) {
                char c = alphabet.charAt(j);
                String wd = word.substring(0,i) + c + word.substring(i,word.length());
                out.add(wd);
            }
        }
        // replace
        for (int i=0; i<word.length(); ++i) {
            for (int j=0; j<alphabet.length(); ++j) {
                char c = alphabet.charAt(j);
                String wd = word.substring(0,i) + c + word.substring(i+1,word.length());
                out.add(wd);
            }
        }
        // transpose
        for (int i=1; i<word.length(); ++i) {
            char c1 = word.charAt(i-1);
            char c2 = word.charAt(i);
            String wd = word.substring(0,i-1) + c2 + c1 + word.substring(i+1,word.length());
            out.add(wd);
        }

        return out;
    }

    public static void main(String[] args) {
        String word = "ps";
        System.out.println( edit(word) );
        System.out.println( edit2(word) );
    }
}
