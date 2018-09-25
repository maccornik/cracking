package lesson1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int solution(int N) {
        String numberToBinary = Integer.toBinaryString(N);
        int longestGapWidth = 0;
        boolean enabled = false;
        int counter = 0;
        char[] numberDigits = numberToBinary.toCharArray();

        for (char numberDigit : numberDigits) {
            if (numberDigit == '1' && !enabled) {
                enabled = true;
            }
            if (numberDigit == '1') {
                if (counter > longestGapWidth) {
                    longestGapWidth = counter;
                    counter = 0;
                }
            }
            if (numberDigit == '0' && enabled) {
                counter++;
            }
        }
        return longestGapWidth;
    }

    public int solution2(int N) {
       return Arrays.stream(Integer.toBinaryString(N)
                .split("1"))
                .max(Comparator.comparingInt(String::length))
                .orElse("").length();
    }

    public static void main(String[] args) {
        //test(9);
        //test(529);
        //test(20);
        //test(15);
        test(7);
        //test(1041);
        //long currentMillis = System.currentTimeMillis();
        //test(2147483647);
        //test(561892); // 10001001001011100100_2
        //System.out.println("Computed in: " + (System.currentTimeMillis() - currentMillis));
    }

    private static void test(int number) {
        System.out.println(number + ": " + new Solution().solution2(number));
    }

}
