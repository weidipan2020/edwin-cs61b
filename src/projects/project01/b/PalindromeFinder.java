package projects.project01.b;

import edu.princeton.cs.introcs.In;

public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("src/projects/project01/b/words.txt");
        Palindrome palindrome = new Palindrome();

        OffByN cc = new OffByN(1);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }
}