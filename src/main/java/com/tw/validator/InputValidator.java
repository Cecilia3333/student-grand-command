package com.tw.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private String input;
    public InputValidator(String input) {
        this.input = input;
    }

    public boolean validate1() {
        String[] inputs = input.split(",");
        if (inputs.length <= 2){
            return false;
        }
        for (int i = 2; i < inputs.length; i++) {
            String[] grades = inputs[i].split(":");
            if (grades.length != 2 || !isNumber(grades[1])) {
                return false;
            }
        }
        return true;
    }

    public boolean validate2(){
        String[] inputs = input.split(",");
        for (String s:inputs
             ) {
            if(!isNumber(s)){
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
