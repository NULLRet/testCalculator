package com.company;

public class StringCals {
    private String str;
    private boolean Er;
    StringCals(){
        str = "";
        Er = false;
    }
    StringCals(String str){
        this.str = str;
        Er = false;
    }
    StringCals(String[] str){
        this.str = "";
        for(int i = 0; i < str.length; i++)
            this.str += str[i];
        System.out.println(this.str);
        Er = false;
    }
    public String toCalculate(){
        return calc(str);
    }
    public String toCalculate(String str){
        this.str = str;
        return calc(str);
    }
    public String toCalculate(String[] str){
        for(int i = 0; i < str.length; i++)
            this.str += str[i];
        return calc(this.str);
    }
    private String calc(final String str){
        boolean checkr=false;
        int ibegin =0,iend=0;
        String temp = str;
        temp = temp.replace('*', 'm');
        temp = temp.replace('/', 'd');
        temp = temp.replace('+', 'a');
        temp = temp.replace('-', 's');
        temp = temp.replace('(', 'o');
        temp = temp.replace(')', 'c');
        for(int i = temp.length() - 1; i > -1; i--){
            if(temp.charAt(i) == 'c'){
                for(int k=i+1; k < temp.length(); k++){
                    if(temp.charAt(k) == 'c' || temp.charAt(k) == 'm' || temp.charAt(k) == 'd' ||
                            temp.charAt(k) == 'a' || temp.charAt(k) == 's') break;
                    else if(temp.charAt(i) != ' '){
                        Er = true;
                        return "Error";
                    }
                }
                if(!checkr)
                    iend = i;
                checkr = true;
            } else if(temp.charAt(i) == 'o'){
                ibegin = i;
                for(int k=i-1; k > 0; k--){
                    if( temp.charAt(k) == 'o' || temp.charAt(k) == 'm' || temp.charAt(k) == 'd' ||
                            temp.charAt(k) == 'a' || temp.charAt(k) == 's') break;
                    else if(temp.charAt(i) != ' '){
                        Er = true;
                        return "Error";
                    }
                }
            }
        }
        if(checkr){
            temp = temp.replaceFirst(temp.substring(ibegin, iend + 1), calc(temp.substring(ibegin + 1, iend)));
        }
        int iss = -1,iCharEnd = temp.length();
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == 'a' || temp.charAt(i) == 's') iss = i;
            if(temp.charAt(i) == 'm' || temp.charAt(i) == 'd'){
                for(int j = i + 1; j < temp.length(); j++){
                    if(temp.charAt(j) == 'a' || temp.charAt(j) == 's' || temp.charAt(j) == 'm' || temp.charAt(j) == 'd'){
                        iCharEnd = j;
                        break;
                    }
                }
                if(temp.charAt(i) == 'm'){
                    String checkError = StrOp.mul(temp.substring(iss + 1, i), temp.substring(i + 1, iCharEnd));
                    if(checkError.equals("E")){
                        Er = true;
                        return "Error";
                    }
                    temp = temp.replaceFirst(temp.substring(iss +1, iCharEnd), checkError);
                    i = iss +1;
                    iss = -1;
                    iCharEnd = temp.length();
                } else if(temp.charAt(i) == 'd'){
                    String checkError = StrOp.div(temp.substring(iss + 1, i), temp.substring(i + 1, iCharEnd));
                    temp = temp.replaceFirst(temp.substring(iss +1, iCharEnd), checkError);
                    i = iss + 1;
                    iss = -1;
                    iCharEnd = temp.length();
                } else Er = true;
            }
        }
        iss = -1;
        iCharEnd = temp.length();
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == 'a' || temp.charAt(i) == 's'){
                for(int j = i + 1; j < temp.length(); j++){
                    if(temp.charAt(j) == 'a' || temp.charAt(j) == 's'){
                        iCharEnd = j;
                        break;
                    }
                }
                if(temp.charAt(i) == 'a'){
                    String checkError = StrOp.add(temp.substring(iss + 1, i), temp.substring(i + 1, iCharEnd));
                    if(checkError.equals("E")){
                        Er = true;
                        return "Error";
                    }
                    temp = temp.replaceFirst(temp.substring(iss +1, iCharEnd), checkError);
                    i = iss +1;
                    iss = -1;
                    iCharEnd = temp.length();
                } else if(temp.charAt(i) == 's'){
                    String checkError = StrOp.sub(temp.substring(iss + 1, i), temp.substring(i + 1, iCharEnd));
                    if(checkError.equals("E")){
                        Er = true;
                        return "Error";
                    }
                    temp = temp.replaceFirst(temp.substring(iss +1, iCharEnd), checkError);
                    i = iss + 1;
                    iss = -1;
                    iCharEnd = temp.length();
                } else Er = true;
            }
        }
        return temp;
    }
    public boolean Error(){
        return Er;
    }
}
