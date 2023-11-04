package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class ClusterizerClass {

    private ClusterizerClass() {

    }

    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int openCount = 0;
        int closeCount = 0;
        int clusterStart = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                closeCount++;
            }

            if (openCount == closeCount) {
                clusters.add(input.substring(clusterStart, i + 1));
                clusterStart = i + 1;
            }
        }

        return clusters;
    }

}
