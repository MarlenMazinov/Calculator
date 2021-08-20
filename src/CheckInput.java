import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CalculatorInput {
    static String input;
    public void calculatorInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Input:\n");
        input = s.nextLine();
        input = input.replace(" ", "");
    }
}

class SplitInput {
    String input;
    String sign;
    String[] splittedInputOfUser;
    public SplitInput(){
        input = CalculatorInput.input;
        String[] signs = {"\\+", "-", "\\*", "/"};
        for (int i = 0; i < signs.length; i++) {
            String patternSign = signs[i];
            Pattern p = Pattern.compile(patternSign);
            Matcher m = p.matcher(input);
            boolean isArithmeticSign = m.find();
            if (isArithmeticSign) {
                splittedInputOfUser = input.split(signs[i]);
                sign = signs[i];
                break;
            } else {
                if (!isArithmeticSign && i == signs.length - 1) {
                    splittedInputOfUser = null;
                }
            }
        }
    }
}

class ChekInput {
    String[] splittedInputOfUser;
    public void chekInput(){
        String patternNumber = "[1,2,3,4,5,6,7,8,9,10,I,II,III,IV,V,VI,VII,VIII,IX,X]";
        Pattern patternNumberObj = Pattern.compile(patternNumber);
        Matcher matcherNumberObj = patternNumberObj.matcher(CalculatorInput.input);
        String patternSecondSign = "[+,-,*,/][1,2,3,4,5,6,7,8,9,10,I,II,III,IV,V,VI,VII,VIII,IX,X][+,-,*,/]";
        Pattern patternSecondSignObj = Pattern.compile(patternSecondSign);
        Matcher matcherSecondSign = patternSecondSignObj.matcher(CalculatorInput.input);
        boolean isSecondSignInInput = matcherSecondSign.find();
        if (isSecondSignInInput) {
            try {
                throw new SecondSignInInputException();
            } catch (SecondSignInInputException e) {
                e.secondSignInInputException();
                return;
            }
        }
        boolean isNumberInInput = matcherNumberObj.find();
        if (!isNumberInInput) {
            try {
                throw new IsNumberInInputException();
            } catch (IsNumberInInputException e) {
                e.isNumberInInputException();
                return;
            }
        }
        char[] inputToArr = CalculatorInput.input.toCharArray();
        if (inputToArr[0] == '-' || CalculatorInput.input.contains("(-")) {
            try {
                throw new NegativeNumberException();
            } catch (NegativeNumberException e) {
                e.negativeNumberException();
                return;
            }
        }
        SplitInput splitInput = new SplitInput();
        splittedInputOfUser = splitInput.splittedInputOfUser;
        if(splittedInputOfUser == null){
            try {
                throw new ArithmeticSignException();
            } catch (ArithmeticSignException e) {
                e.arithmeticSignException();
                return;
            }
        }
        if (splitInput.splittedInputOfUser[0].equals("0") || splitInput.splittedInputOfUser[1].equals("0")) {
            try {
                throw new OperandIsZeroException();
            } catch (OperandIsZeroException e) {
                e.operandIsZeroException();
                return;
            }
        }
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        RomanToArab romanToArab = new RomanToArab();
        Pattern patternOfDigit = Pattern.compile("\\d");
        Matcher matcherOfFirstNumber = patternOfDigit.matcher(splittedInputOfUser[0]);
        Matcher matcherOfSecondNumber = patternOfDigit.matcher(splittedInputOfUser[1]);
        boolean isFirstNumberArabic = matcherOfFirstNumber.find();
        boolean isSecondNumberArabic = matcherOfSecondNumber.find();
        if (isFirstNumberArabic && isSecondNumberArabic) {
            if (splittedInputOfUser[0].contains(".") || splittedInputOfUser[0].contains(",") || splittedInputOfUser[1].contains(".") || splittedInputOfUser[1].contains(",")) {
                try {
                    throw new NumberMustBeIntegerException();
                } catch (NumberMustBeIntegerException e) {
                    e.numberMustBeIntegerException();
                    return;
                }
            } else {
                arithmeticOperator.arithmeticOperator(Integer.parseInt(splittedInputOfUser[0]), Integer.parseInt(splittedInputOfUser[1]));
                if (Integer.parseInt(splittedInputOfUser[0]) > 10 || Integer.parseInt(splittedInputOfUser[1]) > 10){
                    try {
                        throw new NumberMore10Exception();
                    } catch (NumberMore10Exception e) {
                        e.numberMore10Exception();
                        return;
                    }
                }
                System.out.println("Output:\n" + arithmeticOperator.resultOfCalculating);
            }
        } else if (!isFirstNumberArabic && !isSecondNumberArabic && (romanToArab.romanToArab(splittedInputOfUser[0]) != 0 && romanToArab.romanToArab(splittedInputOfUser[1]) != 0)) {
            arithmeticOperator.arithmeticOperator(romanToArab.romanToArab(splittedInputOfUser[0]), romanToArab.romanToArab(splittedInputOfUser[1]));
            if (arithmeticOperator.resultOfCalculating >= 1) {
                ResultOfCalculatingToRoman resultOfCalculatingToRomanObj = new ResultOfCalculatingToRoman(ArithmeticOperator.resultOfCalculating);
                resultOfCalculatingToRomanObj.returnResult();
                System.out.println("Output:\n" + resultOfCalculatingToRomanObj.resultOfCalculatingInRoman);
            } else {
                try {
                    throw new ResultOfRomanCalculatingLessThenOneException();
                } catch (ResultOfRomanCalculatingLessThenOneException e) {
                    e.resultOfRomanCalculatingLessThenOneException();
                    return;
                }
            }
        } else if (isFirstNumberArabic && !isSecondNumberArabic || !isFirstNumberArabic && isSecondNumberArabic) {
            try {
                throw new NumbersTypeAreDifferentException();
            } catch (NumbersTypeAreDifferentException e) {
                e.numbersTypeAreDifferentException();
                return;
            }
        } else {
            try {
                throw new NumberException();
            } catch (NumberException e) {
                e.numberException();
                return;
            }
        }

    }
}

class ArithmeticOperator {
    static int resultOfCalculating;
    public void arithmeticOperator(int a, int b){
        SplitInput splitInput = new SplitInput();
        switch (splitInput.sign) {
            case "\\+":
                resultOfCalculating = a + b;
                break;
            case "-":
                resultOfCalculating = a - b;
                break;
            case "\\*":
                resultOfCalculating = a * b;
                break;
            case "/":
                resultOfCalculating = a / b;
                break;
        }

    }
}

class RomanToArab {
    public int romanToArab(String str){
        switch (str) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default: return 0;
        }
    }
    }
