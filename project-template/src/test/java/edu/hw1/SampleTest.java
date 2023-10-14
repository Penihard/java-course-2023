package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Тест определения секунд")

    public void testMinutesToSeconds() {
        String[] testCases = new String[] {"01:00", "13:56", "10:60", "10:-1"};
        int[] expectedResults = new int[] {60, 836, -1, -1};

        for (int i = 0; i < testCases.length; i++) {
            var a = Main.minutesToSeconds(testCases[i]);
            var b = expectedResults[i];
            assertThat(b)
                .isEqualTo(a);
        }
    }
    @Test
    @DisplayName("Тест определения цифр в числе")
    public void testCountDigits() {
        int[] testCases = new int[] {4666, 566, 0, -128, -1,1};
        int[] expectedResults = new int[] {4, 3, 1, 3, 1,1};
        for (int i = 0; i < testCases.length; i++)
        {
            var a = Main.countDigits(testCases[i]);
            var b = expectedResults[i];
            assertThat(b)
                .isEqualTo(a);
        }
    }
    @Test
    @DisplayName("Тест на вхождение массивов")

    public void testIsNestable() {

        assertThat(Main.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}))
            .isEqualTo(true);
        assertThat(Main.isNestable(new int[] {3, 1}, new int[]{4, 0}))
            .isEqualTo(true);
        assertThat(Main.isNestable(new int[] {9, 9, 8}, new int[]{8, 9}))
            .isEqualTo(false);
        assertThat(Main.isNestable(new int[] {1, 2, 3, 4}, new int[]{2, 3}))
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Тест на нормализацию строк")

    public void testFixString() {
        String[] testCases = new String[]{"123456", "hTsii  s aimex dpus rtni.g", "badce"};
        String[] expectedResults = new String[]{"214365", "This is a mixed up string.", "abcde"};

        for (int i = 0; i < testCases.length; i++) {
            var a = Main.fixString(testCases[i]);
            var b = expectedResults[i];
            assertThat(b)
                .isEqualTo(a);
        }
    }
    @Test
    @DisplayName("Тест нахождения шагов для постоянной Капрекара")

    public void testCountK() {
        int[] testCases = new int[] {3524, 6621, 6554, 1234};
        int[] expectedResults = new int[] {3, 5, 4, 3};

        for (int i = 0; i < testCases.length; i++) {
            var a = Main.countK(testCases[i]);
            var b = expectedResults[i];
            assertThat(b)
                .isEqualTo(a);
        }
    }
    @Test
    @DisplayName("Тест на нахождение палиндрома у числа")

    public void testIsPalindromeDescendant() {
        int[] testCases = new int[] {11211230, 13001120, 23336014, 11};
        boolean[] expectedResults =
            new boolean[] {true, true, true, true};
        for (int i = 0; i < testCases.length; i++) {
            var a = Main.isPalindromeDescendant(testCases[i]);
            var b = expectedResults[i];
            assertThat(b)
                .isEqualTo(a);
        }
    }
    @Test
    @DisplayName("Тест на сдвиг")

    public void testRotate() {

        assertThat(Main.rotateRight(8, 1))
                .isEqualTo(4);
        assertThat(Main.rotateLeft(16, 1))
            .isEqualTo(1);
        assertThat(Main.rotateLeft(17, 2))
            .isEqualTo(6);

    }
    @Test
    @DisplayName("Тест на коней и шахмат")

    public void testKnightBoardCapture() {
        int[][] board1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] board2 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        int[][] board3 = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        assertThat(Main.knightBoardCapture(board1))
            .isEqualTo(true);
        assertThat(Main.knightBoardCapture(board2))
            .isEqualTo(false);
        assertThat(Main.knightBoardCapture(board3))
            .isEqualTo(false);
    }
}
