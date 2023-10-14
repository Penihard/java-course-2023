package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Array;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        //helloWorld();
        /*System.out.println(minutesToSeconds("01:00"));
        System.out.println(minutesToSeconds("13:56"));
        System.out.println(minutesToSeconds("10:60"));*/
        /*System.out.println(countDigits(4666));
        System.out.println(countDigits(-3));
        System.out.println(countDigits(0));*/
        /*int[] a = new int[]
            {
              9,9,8
            };
        int[] b = new int[]
            {
                8,9
            };
        System.out.println(isNestable(a, b));*/
        //System.out.println(fixString("hTsii  s aimex dpus rtni.g"));
        //System.out.println(isPalindromeDescendant(363));
        /*System.out.println(countK(1234));
        System.out.println(rotateRight(8, 1));*/
        //System.out.println(Main.rotateLeft(16, 1));

    }
    public static void helloWorld()
    {
        LOGGER.info("Hello world!");
    }
    public static int minutesToSeconds(String str) {
        String[] splitedStr = str.split(":");

        int minutes = Integer.parseInt(splitedStr[0]);
        int seconds = Integer.parseInt(splitedStr[1]);
        if(seconds>=60 || seconds<=-1)
        {
            return -1;
        }
        return minutes*60+seconds;
    }

    public static int countDigits(int value) {
        int count=0;
        if(value==0)
        {
            return 1;
        }
        if(value<0)
        {
            value = Math.abs(value);
        }
        while(value>0)
        {
            count++;
            value=value/10;
        }
        return count;
    }
    public static boolean isNestable(int[] a1, int[] a2) {
        if(Arrays.stream(a1).min().getAsInt()>Arrays.stream(a2).min().getAsInt())
        {
            if(Arrays.stream(a2).max().getAsInt()>Arrays.stream(a1).max().getAsInt())
            {
                return true;
            }
        }
        return false;
    }

    public static String fixString(String str) {
        char[] charStr = str.toCharArray();

        for (int i = 0; i < charStr.length - 1; i += 2) {
            char tmp = charStr[i];
            charStr[i] = charStr[i + 1];
            charStr[i + 1] = tmp;
        }

        return new String(charStr);
    }


    public static boolean isPalindromeDescendant(int number) {
        while (number >= 10) {
            if (isPalindrome(number)) {
                return true;
            }
            number = foundDescendant(number);
        }

        return false;
    }

    private static int foundDescendant(int number) {
        String descendant = new String();
        String str = Integer.toString(number);
        for (int i = 0; i < str.length() - 1; i+=2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            int digit2 = Character.getNumericValue(str.charAt(i + 1));
            descendant+=(digit1+digit2);
        }

        if (str.length() % 2 != 0) {
            descendant+=(str.charAt(str.length() - 1));
        }

        return Integer.parseInt(descendant);
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static int countK(int value) {
        if (value == 6174) {
            return 0;
        }

        return 1 + countK(sortDigitsInNumber(value));
    }

    private static int sortDigitsInNumber(int number) {
        String numberString = String.valueOf(number);
        char[] digitsArray = numberString.toCharArray();
        Arrays.sort(digitsArray);
        StringBuilder sortedNumberString = new StringBuilder(new String(digitsArray));
        sortedNumberString.reverse();
        int val1 =  Integer.parseInt(sortedNumberString.toString());
        int val2 = Integer.parseInt(new String(digitsArray));
        return val1-val2;
    }
/*
    public static int rotateLeft(int n, int shift) {

        var f= Integer.toBinaryString(n);
        System.out.println(f);
        return (n << shift) | (n >>> (f.length() - shift));
    }

    public static int rotateRight(int n, int shift) {

        return (n >> shift) | (n << (Integer.SIZE - shift));

    }*/
    public static int rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        shift %= binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(binaryStr.length() - shift)
            + binaryStr.substring(0, binaryStr.length() - shift);
        return Integer.parseInt(rotatedBinaryStr, 2);
    }

    public static int rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        shift %= binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(shift) + binaryStr.substring(0, shift);
        return Integer.parseInt(rotatedBinaryStr, 2);
    }
    public static String toBinaryString(int n)
    {
        return String.format("%32s", Integer.toBinaryString(n))
            .replaceAll(" ", "0");
    }

    public static boolean knightBoardCapture(int[][] board) {
         int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
         int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


}
