package com.company;

public class RomanNumerals {
    private int num;
    private boolean checkSub(char a, char b, int i){
        if(i == 500 && a == 'D' && b == 'M') return true;
        if(i == 100 && a == 'C' && (b == 'D' || b == 'M')) return true;
        if(i == 50  && a == 'L' && (b == 'C' || b == 'D' || b == 'M')) return true;
        if(i == 10  && a == 'X' && (b == 'L' || b == 'C' || b == 'D' || b == 'M')) return true;
        if(i == 5   && a == 'V' && (b == 'X' || b == 'L' || b == 'C' || b == 'D' || b == 'M')) return true;
        if(i == 1   && a == 'I' && (b == 'V' || b == 'X' || b == 'L' || b == 'C' || b == 'D' || b == 'M')) return true;
        return false;
    }
    public String get(){
        return checkC(num);
    }
    public String toString(){
        return checkC(num);
    }
    private String checkC(int num){
        int tempNum = num;
        String temp = new String();
        int num1000 = tempNum / 1000;
        tempNum %= 1000;
        int num100 = tempNum / 100;
        tempNum %= 100;
        int num10 = tempNum / 10;
        tempNum %= 10;
        int num1 = tempNum;
        if(num1000 == 3) temp += "MMM";
        else if(num1000 == 2) temp += "MM";
        else if(num1000 == 1) temp += "M";
        if(num100 == 9) temp += "CM";
        else if(num100 == 8) temp += "DCCC";
        else if(num100 == 7) temp += "DCC";
        else if(num100 == 6) temp += "DC";
        else if(num100 == 5) temp += "D";
        else if(num100 == 4) temp += "CD";
        else if(num100 == 3) temp += "CCC";
        else if(num100 == 2) temp += "CC";
        else if(num100 == 1) temp += "C";
        if(num10 == 9) temp += "XC";
        else if(num10 == 8) temp += "LXXX";
        else if(num10 == 7) temp += "LXX";
        else if(num10 == 6) temp += "LX";
        else if(num10 == 5) temp += "L";
        else if(num10 == 4) temp += "XL";
        else if(num10 == 3) temp += "XXX";
        else if(num10 == 2) temp += "XX";
        else if(num10 == 1) temp += "X";
        if(num1 == 9) temp += "IX";
        else if(num1 == 8) temp += "VIII";
        else if(num1 == 7) temp += "VII";
        else if(num1 == 6) temp += "VI";
        else if(num1 == 5) temp += "V";
        else if(num1 == 4) temp += "IV";
        else if(num1 == 3) temp += "III";
        else if(num1 == 2) temp += "II";
        else if(num1 == 1) temp += "I";
        return temp;
    }
    public int toInt(){
        return num;
    }
    public RomanNumerals add(RomanNumerals a){
        return new RomanNumerals(checkC(num + a.toInt()));
    }
    public RomanNumerals sub(RomanNumerals a){
        return new RomanNumerals(checkC(num - a.toInt()));
    }
    public RomanNumerals mul(RomanNumerals a){
        return new RomanNumerals(checkC(num * a.toInt()));
    }
    public RomanNumerals div(RomanNumerals a){
        return new RomanNumerals(checkC(num / a.toInt()));
    }
    RomanNumerals(String str){
        num = 0;
        for(int i=0; i < str.length(); i++) {
            char b = 0, a = str.charAt(i);
            if (i != str.length() - 1) b = str.charAt(i + 1);
            if (a == 'M') num += 1000;
            else if ((i != str.length() - 1) && checkSub(a, b, 500)) num -= 500;
            else if (a == 'D') num += 500;
            else if ((i != str.length() - 1) && checkSub(a, b, 100)) num -= 100;
            else if (a == 'C') num += 100;
            else if ((i != str.length() - 1) && checkSub(a, b, 50)) num -= 50;
            else if (a == 'L') num += 50;
            else if ((i != str.length() - 1) && checkSub(a, b, 10)) num -= 10;
            else if (a == 'X') num += 10;
            else if ((i != str.length() - 1) && checkSub(a, b, 5)) num -= 5;
            else if (a == 'V') num += 5;
            else if ((i != str.length() - 1) && checkSub(a, b, 1))
                num -= 1;
            else if (a == 'I') num += 1;
            else {
                num = -1;
                break;
            }
        }
    }
    RomanNumerals(RomanNumerals Rn){
        num = Rn.toInt();
    }
    public boolean Error(){
        return num == -1;
    }
}
