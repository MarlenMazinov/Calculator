/* Создаём класс, объект которого преобразует арабские цифры в римские
 для последующего вывода результата вычисления в консоль */
public class ResultOfCalculatingToRoman {
    int arg;
    String one;
    String dozen;
    String resultOfCalculatingInRoman;
    String argToString;
    String charToString;
    char[] argToCharArray;

    // Создаём конструктор класса, который принимает значение типа int и присваивает его полю arg
    public ResultOfCalculatingToRoman(int arg) {
        this.arg = arg;
    }

    public void returnResult() {
        argToString = Integer.toString(arg);
        argToCharArray = argToString.toCharArray();
        // Если результат вычисления арифметического выражения от 0 до 10
        if (0 < arg && arg <= 10) {
            // Вызываем метод ones(), передав ему в качестве аргумента содержимое поля arg
            ones(arg);
            resultOfCalculatingInRoman = one;
        } else {
            // Если результат вычисления арифметического выражения не больше 99
            if (Integer.parseInt(Character.toString(argToCharArray[1])) != 0 && argToCharArray.length < 3) {
                ones(Integer.parseInt(Character.toString(argToCharArray[1])));
                dozens();
                resultOfCalculatingInRoman = dozen + one;
            } else { // Если результат вычисления арифметического выражения равен 100
                dozens();
                resultOfCalculatingInRoman = dozen;
            }
        }
    }

    // Объявляем метод, которые преобразует арабские циифры от 1 до 10 в римские от I до X соответственно
    public void ones(int arg) {
        switch (arg) {
            case 1:
                one = "I";
                break;
            case 2:
                one = "II";
                break;
            case 3:
                one = "III";
                break;
            case 4:
                one = "IV";
                break;
            case 5:
                one = "V";
                break;
            case 6:
                one = "VI";
                break;
            case 7:
                one = "VII";
                break;
            case 8:
                one = "VIII";
                break;
            case 9:
                one = "IX";
                break;
            case 10:
                one = "X";
                break;

        }
    }

    /* Объявляем метод, который преобразует первую цифру двузначных чисел из арабской
     в римскую либо преобразует число 100 в C */
    public void dozens() {
        // Если в поле arg находится двузначное число
        if (argToCharArray.length < 3) {
            switch (Integer.parseInt(Character.toString(argToCharArray[0]))) {
                case 2:
                    dozen = "XX";
                    break;
                case 3:
                    dozen = "XXX";
                    break;
                case 4:
                    dozen = "XL";
                    break;
                case 5:
                    dozen = "L";
                    break;
                case 6:
                    dozen = "LX";
                    break;
                case 7:
                    dozen = "LXX";
                    break;
                case 8:
                    dozen = "LXXX";
                    break;
                case 9:
                    dozen = "XC";
                    break;
            }
        } else { // Если в поле arg находится число 100
            dozen = "C";
        }
    }
}
