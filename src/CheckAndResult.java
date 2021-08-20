import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Создаем класс, объект которого получает от пользователя строку с арифметическим
выражением для дальнейшей обработки этого выражения */
class CalculatorInput {
    static String input;

    public void calculatorInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Input:\n");
        input = s.nextLine();
        input = input.replace(" ", ""); //удаляем пробелы
    }
}

/*Создаем класс, объект которого проверяет введенное пользователем выражение
 на наличие любого из необходимых арифметических операторов,
  и разбивает строку на подстроки используя в качестве разделителя найденный оператор. */
class SplitInput {
    String input;
    String sign;
    String[] splittedInputOfUser;

    public SplitInput() {
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

/* Создаем класс, который проверяет введенное пользоваелем выражение на наличие ошибок,
 и выдает результат вычисления либо выбрасывает исключение */
class CheckAndResult {
    String[] splittedInputOfUser;

    public void main() {
        // Создаем паттерн для проверки наличия любой из подходящих цифр в введенной строке
        String patternNumber = "[1,2,3,4,5,6,7,8,9,10,I,II,III,IV,V,VI,VII,VIII,IX,X]";
        Pattern patternNumberObj = Pattern.compile(patternNumber);
        Matcher matcherNumberObj = patternNumberObj.matcher(CalculatorInput.input);
        // Создаем паттерн для проверки наличия более одного оператора в введенной строке
        String patternSecondSign = "[+,-,*,/][1,2,3,4,5,6,7,8,9,10,I,II,III,IV,V,VI,VII,VIII,IX,X][+,-,*,/]";
        Pattern patternSecondSignObj = Pattern.compile(patternSecondSign);
        Matcher matcherSecondSign = patternSecondSignObj.matcher(CalculatorInput.input);
        boolean isSecondSignInInput = matcherSecondSign.find();
        //Проверяем наличие более одного оператора в введенной строке
        if (isSecondSignInInput) {
            try {
                throw new SecondSignInInputException();
            } catch (SecondSignInInputException e) {
                e.secondSignInInputException();
                return;
            }
        }
        boolean isNumberInInput = matcherNumberObj.find();
        //Проверяем наличие в введенной строке цифр от 1 до 10 или от I до X
        if (!isNumberInInput) {
            try {
                throw new IsNumberInInputException();
            } catch (IsNumberInInputException e) {
                e.isNumberInInputException();
                return;
            }
        }
        char[] inputToArr = CalculatorInput.input.toCharArray();
        //Проверяем наличие в введенной строке отрицательных чисел
        if (inputToArr[0] == '-' || CalculatorInput.input.contains("(-")) {
            try {
                throw new NegativeNumberException();
            } catch (NegativeNumberException e) {
                e.negativeNumberException();
                return;
            }
        }
        /* Создаём объек класса SplitInput и из него получаем введенную пользователем
         строку, разбитую на массив, состоящий из введенных операнд */
        SplitInput splitInput = new SplitInput();
        splittedInputOfUser = splitInput.splittedInputOfUser;
        //Проверяем, ввел ли пользователь арифметический оператор.
        if (splittedInputOfUser == null) {
            try {
                throw new ArithmeticSignException();
            } catch (ArithmeticSignException e) {
                e.arithmeticSignException();
                return;
            }
        }
        //Проверяем, не ввел ли пользователь в качестве операнда 0.
        if (splitInput.splittedInputOfUser[0].equals("0") || splitInput.splittedInputOfUser[1].equals("0")) {
            try {
                throw new OperandIsZeroException();
            } catch (OperandIsZeroException e) {
                e.operandIsZeroException();
                return;
            }
        }
        /* Создаём объект класса ArithmeticOperator, который осуществит вычисление
        введенной арифметической операции */
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        /* Создаём объект класса RomanToArab, который осуществит преобразование
        введенных пользователем римских цифр в арабские для последующего вычисления результата */
        RomanToArab romanToArab = new RomanToArab();
        // Создаём паттерн для проверки наличия арабских цифр в введенной пользователем сроке
        Pattern patternOfDigit = Pattern.compile("\\d");
        Matcher matcherOfFirstNumber = patternOfDigit.matcher(splittedInputOfUser[0]);
        Matcher matcherOfSecondNumber = patternOfDigit.matcher(splittedInputOfUser[1]);
        boolean isFirstNumberArabic = matcherOfFirstNumber.find();
        boolean isSecondNumberArabic = matcherOfSecondNumber.find();
        // Проверяем состоят ли оба операнда из арабских цифр
        if (isFirstNumberArabic && isSecondNumberArabic) {
            /* Если оба операнда состоят из арабских цифр, проверяем
            - не являются ли они дробными числами */
            if (splittedInputOfUser[0].contains(".") || splittedInputOfUser[0].contains(",") || splittedInputOfUser[1].contains(".") || splittedInputOfUser[1].contains(",")) {
                try {
                    throw new NumberMustBeIntegerException();
                } catch (NumberMustBeIntegerException e) {
                    e.numberMustBeIntegerException();
                    return;
                }
            } else {
                // Проверяем не являются ли введенные операнды числами больше 10
                if (Integer.parseInt(splittedInputOfUser[0]) > 10 || Integer.parseInt(splittedInputOfUser[1]) > 10) {
                    try {
                        throw new NumberMore10Exception();
                    } catch (NumberMore10Exception e) {
                        e.numberMore10Exception();
                        return;
                    }
                }
                /* Из объека класса ArithmeticOperator вызываем метод arithmeticOperator,
                в качестве аргументов передавая ему введенные пользователем операнды */
                arithmeticOperator.arithmeticOperator(Integer.parseInt(splittedInputOfUser[0]), Integer.parseInt(splittedInputOfUser[1]));
                // Выводим в консоль результат вычислений
                System.out.println("Output:\n" + arithmeticOperator.resultOfCalculating);
            }
        } else
            //Если оба операнда состоят из римских цифр
            if (!isFirstNumberArabic && !isSecondNumberArabic && (romanToArab.romanToArab(splittedInputOfUser[0]) != 0 && romanToArab.romanToArab(splittedInputOfUser[1]) != 0)) {
                /* Из объека класса ArithmeticOperator вызываем метод arithmeticOperator,
                в качестве аргументов передавая ему введенные пользователем операнды,
                преобразованные в арабские цифры с помощью объекта класса RomanToArab */
                arithmeticOperator.arithmeticOperator(romanToArab.romanToArab(splittedInputOfUser[0]), romanToArab.romanToArab(splittedInputOfUser[1]));
                // Проверяем не является ли результат вычисления меньше 1
                if (arithmeticOperator.resultOfCalculating >= 1) {
                /* Создаём объект класса ResultOfCalculatingToRoman для преобразования
                 результата вычисления  в римские цифры для последующего вывода в консоль */
                    ResultOfCalculatingToRoman resultOfCalculatingToRomanObj = new ResultOfCalculatingToRoman(ArithmeticOperator.resultOfCalculating);
                    resultOfCalculatingToRomanObj.returnResult();
                    // Выводим в консоль результат вычислений
                    System.out.println("Output:\n" + resultOfCalculatingToRomanObj.resultOfCalculatingInRoman);
                } else {
                    try {
                        throw new ResultOfRomanCalculatingLessThenOneException();
                    } catch (ResultOfRomanCalculatingLessThenOneException e) {
                        e.resultOfRomanCalculatingLessThenOneException();
                        return;
                    }
                }
            } else
                // Проверяем не ввел ли пользователь римские и арабские цифры одновременно
                if (isFirstNumberArabic && !isSecondNumberArabic || !isFirstNumberArabic && isSecondNumberArabic) {
                    try {
                        throw new NumbersTypeAreDifferentException();
                    } catch (NumbersTypeAreDifferentException e) {
                        e.numbersTypeAreDifferentException();
                        return;
                    }
                }
                // Проверяем не ввел ли пользователь число больше X
                else {
                    try {
                        throw new NumberException();
                    } catch (NumberException e) {
                        e.numberException();
                        return;
                    }
                }

    }
}

/* Создаём класс, метод объекта которого будет принимать введенные пользователем операнды
 и результат вычисления записывать в статическую переменную "resultOfCalculating" */
class ArithmeticOperator {
    static int resultOfCalculating;

    public void arithmeticOperator(int a, int b) {
        /* Создаём объект класса SplitInput для получения введённого пользователем
         арифметического оператора */
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

/* Создаём класс, метод объекта которого преобразует римские цифры в арабские
 для вычисления результата арифметической операции */
class RomanToArab {
    public int romanToArab(String str) {
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
            default:
                return 0;
        }
    }
}
