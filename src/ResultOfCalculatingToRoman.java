public class ResultOfCalculatingToRoman {
    int arg;
    String one;
    String dozen;
    String resultOfCalculatingInRoman;
    String argToString;
    String charToString;
    char[] argToCharArray;
    public ResultOfCalculatingToRoman(int arg) {
        this.arg = arg;
    }
    public void returnResult(){
        argToString = Integer.toString(arg);
        argToCharArray = argToString.toCharArray();
        if ( 0 < arg && arg <= 10){
            ones(arg);
            resultOfCalculatingInRoman = one;
        } else {
            if (Integer.parseInt(Character.toString(argToCharArray[1])) != 0 && argToCharArray.length < 3) {
                ones(Integer.parseInt(Character.toString(argToCharArray[1])));
                dozens();
                resultOfCalculatingInRoman = dozen + one;
            } else {
                dozens();
                resultOfCalculatingInRoman = dozen;
            }
        }
    }
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
    public void dozens(){
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
        } else {
            dozen = "C";
        }
    }
}
