public class Calculator {
    public static void main(String[] args) throws ArithmeticSignException,
            NumberException, NumbersTypeAreDifferentException,
            SecondSignInInputException, IsNumberInInputException,
            ResultOfRomanCalculatingLessThenOneException,
            ResultOfRomanCalculatingLessThenOneException,
            NumberMustBeIntegerException, NegativeNumberException,
            OperandIsZeroException, NumberMore10Exception {
        CalculatorInput calculatorInput = new CalculatorInput();
        calculatorInput.calculatorInput();
        CheckAndResult checkAndResult = new CheckAndResult();
        checkAndResult.main();
    }
}