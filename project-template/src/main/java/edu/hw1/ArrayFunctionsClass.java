package edu.hw1;

import java.util.Arrays;

public class ArrayFunctionsClass {
    private ArrayFunctionsClass() {
    }

    @SuppressWarnings("MagicNumber")
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

    public static boolean isNestable(int[] a1, int[] a2) {
        if (Arrays.stream(a1).min().getAsInt() > Arrays.stream(a2).min().getAsInt()) {
            if (Arrays.stream(a2).max().getAsInt() > Arrays.stream(a1).max().getAsInt()) {
                return true;
            }
        }
        return false;
    }
}
