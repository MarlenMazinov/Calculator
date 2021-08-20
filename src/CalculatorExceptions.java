public class CalculatorExceptions extends Exception {
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь не ввел
 арифметический оператор.*/
class ArithmeticSignException extends Exception {
    public void arithmeticSignException() {
        System.out.println("Вы не ввели арифметический оператор.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 римские цифры больше X.*/
class NumberException extends Exception {
    public void numberException() {
        System.out.println("Вы ввели число больше X");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 в одном выражении и римские, и арабские цифры.*/
class NumbersTypeAreDifferentException extends Exception {
    public void numbersTypeAreDifferentException() {
        System.out.println("Неправильный ввод! Вы должны были ввести ТОЛЬКО арабские, либо ТОЛЬКО римские цифры.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь не ввел
 числа от 1 до 10 либо от I до X.*/
class IsNumberInInputException extends Exception {
    public void isNumberInInputException() {
        System.out.println("Вы не ввели число.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 в одном выражении более одного арифметического оператора.*/
class SecondSignInInputException extends Exception {
    public void secondSignInInputException() {
        System.out.println("Неправильный ввод! Вы можете ввести только два операнда и один оператор (+,-,*,/)");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если результат вычисления
 операндов в виде римских чисел оказался меьше 1.*/
class ResultOfRomanCalculatingLessThenOneException extends Exception {
    public void resultOfRomanCalculatingLessThenOneException() {
        System.out.println("Неверный ввод! Результат арифметической операции" +
                " с римскими цифрами не может быть меньше 1.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 дробное число/числа.*/
class NumberMustBeIntegerException extends Exception {
    public void numberMustBeIntegerException() {
        System.out.println("Неверный ввод! Вы можете ввести только целые числа.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 отрицательное число.*/
class NegativeNumberException extends Exception {
    public void negativeNumberException() {
        System.out.println("Неверный ввод! Вводимые числа должны быть положительными.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 число меньше 1.*/
class OperandIsZeroException extends Exception {
    public void operandIsZeroException() {
        System.out.println("Неверный ввод! Операнды должны быть больше нуля.");
    }
}

/*Создаем класс исключения, выбрасываемого в случае если пользователь ввел
 число больше 10.*/
class NumberMore10Exception extends Exception {
    public void numberMore10Exception() {
        System.out.println("Неверный ввод! Вы должны ввести число не больше 10.");
    }
}

