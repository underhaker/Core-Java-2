package com.hackbulgaria.corejava;

public class FaultyProblem4 {
    public static boolean areEqual(Integer e, Integer k) {
        k++;
        k--;
        return e.equals(k);
    }

    public static boolean areEqual(float a, float b) {
        //Math.floor(a);Math.floor(b);
        return Math.abs(a-b)<0.01;
    }

    /**
     * Return whether there is an index <b>i</b>,
     * such that a[i,a.length] equals b[i, a.length];
     * @param a
     * @param b
     * @return
     */
    public static boolean haveEqualSubstrings(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String substringA = a.substring(i, a.length());
            String substringB = b.substring(i, a.length());
            if (substringA.equals(substringB) && substringA.length()!=0 && substringB.length()!=0){
                return true;
            }
        }
        return false;
    }
}
