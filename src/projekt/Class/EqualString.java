/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Class;


public class EqualString {
    /**
     * * Metoda porównująca dwa łańcuchy znaków pomija uwzgledniając jedynie znaki ASCI.
     *
     * @param s  łańcuch znaków
     * @param s2 łańcuch znaków
     * @return true jezeli oba znaki są takie same
     */
    public static boolean equals(String s, String s2) {
        StringBuilder sTmp = new StringBuilder();
        StringBuilder s2Tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (((int) s.charAt(i) > 64 && (int) s.charAt(i) <= 90) || ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122)) {
                sTmp.append(s.charAt(i));
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (((int) s2.charAt(i) > 64 && (int) s2.charAt(i) <= 90) || ((int) s2.charAt(i) >= 97 && (int) s2.charAt(i) <= 122)) {
                s2Tmp.append(s2.charAt(i));
            }
        }
        if (s2Tmp.length() != sTmp.length()) {
            return false;
        } else {
            for (int i = 0; i < sTmp.length(); i++) {
                if (sTmp.charAt(i) != s2Tmp.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String removeChar(String s) {
        StringBuilder sTmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (((int) s.charAt(i) > 64 && (int) s.charAt(i) <= 90) || ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122)) {
                sTmp.append(s.charAt(i));
            }
        }
        return sTmp.toString();
    }
}
