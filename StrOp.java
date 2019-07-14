package com.company;

public class StrOp {
    public static String add(String a, String b){
        a = a.trim();
        b = b.trim();
        RomanNumerals aR = new RomanNumerals(a);
        RomanNumerals bR = new RomanNumerals(b);
        if(aR.Error() && bR.Error()) {
            int ai = Integer.parseInt(a);
            int bi = Integer.parseInt(b);
            return Integer.toString(ai + bi);
        } else if(!(aR.Error() || bR.Error())){
            return new RomanNumerals(aR.add(bR)).toString();
        } else return "E";
    }
    public static String sub(String a, String b){
        a = a.trim();
        b = b.trim();
        RomanNumerals aR = new RomanNumerals(a);
        RomanNumerals bR = new RomanNumerals(b);
        if(aR.Error() && bR.Error()) {
            int ai = Integer.parseInt(a);
            int bi = Integer.parseInt(b);
            return Integer.toString(ai - bi);
        } else if(!(aR.Error() || bR.Error())){
            return new RomanNumerals(aR.sub(bR)).toString();
        } else return "E";
    }
    public static String mul(String a, String b){
        a = a.trim();
        b = b.trim();
        RomanNumerals aR = new RomanNumerals(a);
        RomanNumerals bR = new RomanNumerals(b);
        if(aR.Error() && bR.Error()) {
            int ai = Integer.parseInt(a);
            int bi = Integer.parseInt(b);
            return Integer.toString(ai * bi);
        } else if(!(aR.Error() || bR.Error())){
            return new RomanNumerals(aR.mul(bR)).toString();
        } else return "E";
    }
    public static String div(String a, String b){
        a = a.trim();
        b = b.trim();
        RomanNumerals aR = new RomanNumerals(a);
        RomanNumerals bR = new RomanNumerals(b);
        if(aR.Error() && bR.Error()) {
            int ai = Integer.parseInt(a);
            int bi = Integer.parseInt(b);
            return Integer.toString(ai / bi);
        } else if(!(aR.Error() || bR.Error())){
            return new RomanNumerals(aR.div(bR)).toString();
        } else return "E";
    }
}
