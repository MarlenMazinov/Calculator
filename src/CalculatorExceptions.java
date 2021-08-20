public class CalculatorExceptions extends Exception{
}
class ArithmeticSignException extends Exception{
    public void arithmeticSignException() {
        System.out.println("Вы не ввели арифметический оператор.");
    }
}
class NumberException extends Exception{
    public void numberException() {
        System.out.println("Вы не ввели число от 1 до 10 или от I до X");
    }
}
class NumbersTypeAreDifferentException extends Exception{
    public void numbersTypeAreDifferentException() {
        System.out.println("Неправильный ввод! Вы должны были ввести ТОЛЬКО арабские, либо ТОЛЬКО римские цифры.");
    }
}
class IsNumberInInputException extends Exception{
public void isNumberInInputException(){
    System.out.println("Вы не ввели число.");
}
}
class SecondSignInInputException extends Exception{
    public void secondSignInInputException(){
        System.out.println("Неправильный ввод! Вы можете ввести только два операнда и один оператор (+,-,*,/)");
    }
}
class ResultOfRomanCalculatingLessThenOneException extends Exception{
    public void resultOfRomanCalculatingLessThenOneException(){
        System.out.println("Неверный ввод! Результат арифметической операции с римскими цифрами не может быть меньше 1.");
    }
}
class NumberMustBeIntegerException extends Exception{
    public void numberMustBeIntegerException(){
        System.out.println("Неверный ввод! Вы можете ввести только целые числа.");
    }
}
class NegativeNumberException extends Exception{
    public void negativeNumberException(){
        System.out.println("Неверный ввод! Вводимые числа должны быть положительными.");
    }
}
class OperandIsZeroException extends Exception{
    public void operandIsZeroException(){
        System.out.println("Неверный ввод! Операнды должны быть больше нуля.");
    }
}
class NumberMore10Exception extends Exception{
    public void numberMore10Exception(){
        System.out.println("Неверный ввод! Вы должны ввести число не больше 10.");
    }
}

