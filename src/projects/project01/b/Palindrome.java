package projects.project01.b;

import projects.project01.a.ArrayDeque;
import projects.project01.a.LinkedListDeque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (Character c : word.toCharArray()) {
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return helperIsPalindrome(deque);
    }

    private boolean helperIsPalindrome(Deque deque) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        }

        boolean flag1 = deque.removeFirst() == deque.removeLast();
        boolean flag2 = helperIsPalindrome(deque);
        return flag1 && flag2;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (Character c : word.toCharArray()) {
            deque.addLast(c);
        }
        return helperIsPalindrome(deque, cc);
    }

    private boolean helperIsPalindrome(Deque<Character> deque, CharacterComparator cc) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        }
        return cc.equalChars(deque.removeFirst(), deque.removeLast()) && helperIsPalindrome(deque, cc);
    }
}
