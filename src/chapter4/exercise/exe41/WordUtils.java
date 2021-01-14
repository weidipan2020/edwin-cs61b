package chapter4.exercise.exe41;

import discussions.disc03.SLList;

public class WordUtils {
    public String longestString(SLList<String> list) {
        String res = "";

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (res.length() < str.length()) {
                res = str;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SLList<String> list = new SLList();
        list.addFirst("21");
        list.insert("123", 1);
        System.out.println(list);
    }
}
