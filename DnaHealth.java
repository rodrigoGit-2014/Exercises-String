package com.example.demo.DNAHealth;

import java.util.*;

public class DnaHealth {


    public static void main(String[] args) {
       /* String search = "caaab";// "AABAACAADAABAABA";
        String pattern = "b";
        System.out.println(countSubstring(search, pattern));*/
        String[] genes = genes();
        int[] health = health();
        String[][] matrix = matrixADN();


        ADNManager(genes, health, matrix);


    }

    public static void ADNManager(String[] genes, int[] health, String[][] matrixADN) {


        int healthiest = 0, unhealthiest = Integer.MAX_VALUE;
        Map<String, Integer> adnMapValue = initADNMap(genes, health);
        for (int i = 0; i < matrixADN.length; i++) {
            Set<String> patterns = getPattern(matrixADN[i], genes);
            int totalGenes = 0;
            for (String pattern : patterns) {
                int numberOfOccurrences = countSubstring(matrixADN[i][2], pattern);
                totalGenes += adnMapValue.get(pattern) * numberOfOccurrences;
            }
            if (totalGenes > healthiest) healthiest = totalGenes;
            if (totalGenes < unhealthiest) unhealthiest = totalGenes;
        }
        System.out.println(unhealthiest + " " + healthiest);
    }

    public static Set<String> getPattern(String[] adn, String[] genes) {

        int start = Integer.valueOf(adn[0]);
        int end = Integer.valueOf(adn[1]);
        Set<String> pattern = new HashSet();
        for (int ind = start; ind <= end; ind++) {
            pattern.add(genes[ind]);
        }
        return pattern;

    }

    public static Map<String, Integer> initADNMap(String[] genes, int[] health) {
        Map<String, Integer> adnMap = new HashMap<>();
        for (int i = 0; i < genes.length; i++) {
            if (adnMap.get(genes[i]) == null) {
                adnMap.put(genes[i], health[i]);
            } else {
                adnMap.put(genes[i], adnMap.get(genes[i]) + health[i]);
            }
        }
        return adnMap;
    }

    public static int countSubstring(String search, String pattern) {

        int count = 0;
        int total = (search.length() - pattern.length()) + 1;
        int match = pattern.length() * 2;

        for (int ind = 0; ind < total; ind++) {
            String auxSearch = search.substring(ind, pattern.length() + ind);
            int auxSearchInd = 0, patternInd = 0;
            while (auxSearchInd < auxSearch.length() &&
                    auxSearch.charAt(auxSearchInd) == pattern.charAt(patternInd)) {
                auxSearchInd++;
                patternInd++;

            }
            if (auxSearchInd == patternInd && auxSearchInd + patternInd == match) count++;
        }
        return count;
    }


    public static String[][] matrixADN() {
        String[][] matrix = new String[3][3];
        matrix[0][0] = "1";
        matrix[0][1] = "5";
        matrix[0][2] = "caaab";

        matrix[1][0] = "0";
        matrix[1][1] = "4";
        matrix[1][2] = "xyz";

        matrix[2][0] = "2";
        matrix[2][1] = "4";
        matrix[2][2] = "bcdybc";

        return matrix;
    }

    public static String[] genes() {
        String[] genes = new String[6];
        genes[0] = "a";
        genes[1] = "b";
        genes[2] = "c";
        genes[3] = "aa";
        genes[4] = "d";
        genes[5] = "b";
        return genes;
    }

    public static int[] health() {
        int[] health = new int[6];
        health[0] = 1;
        health[1] = 2;
        health[2] = 3;
        health[3] = 4;
        health[4] = 5;
        health[5] = 6;
        return health;
    }
}
