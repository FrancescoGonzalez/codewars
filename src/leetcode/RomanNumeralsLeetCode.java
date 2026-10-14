package leetcode;

public class RomanNumeralsLeetCode {

    static void main() {
        System.out.println(intToRoman(1111));
    }

    public static String intToRoman(int num) {
        String[] numStringArray = String.valueOf(num).split("");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numStringArray.length; i++) {
            res.append(singleNumberToRoman(Integer.parseInt(numStringArray[i]), numStringArray.length - i));
        }

        return res.toString();
    }

    static String singleNumberToRoman(int num, int exponent) {
        StringBuilder res = new StringBuilder();

        String single = "";
        String middle = "";
        String next = "";

        switch (exponent) {
            case 1:
                single = "I";
                middle = "V";
                next = "X";
                break;
            case 2:
                single = "X";
                middle = "L";
                next = "C";
                break;
            case 3:
                single = "C";
                middle = "D";
                next = "M";
                break;
            case 4:
                for (int i = 0; i < num; i++) {
                    res.append("M");
                }
                return res.toString();
        }

        switch (num) {
            case 1:
            case 2:
            case 3:
                res.append(single.repeat(num));
                break;
            case 4:
                res = new StringBuilder(single + middle);
                break;
            case 5:
                res = new StringBuilder(middle);
                break;
            case 6:
            case 7:
            case 8:
                res = new StringBuilder(middle);
                for (int i = 0; i < num - 5; i++) {
                    res.append(single);
                }
                break;
            case 9:
                res = new StringBuilder(single + next);
                break;
        }

        return res.toString();

    }

}
