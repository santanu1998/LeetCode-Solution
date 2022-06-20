package com.LeetCode;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matches = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                matches[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> ans = findWinners(matches);
        System.out.println(ans);
    }
    private static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> allPlayers = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> losers = new HashSet<>();
        Set<Integer> noLosers = new HashSet<>();
        Set<Integer> lostOnlyOneMatch = new HashSet<>();
        for (int[] match : matches) {
            allPlayers.add(match[0]);
            allPlayers.add(match[1]);
            losers.add(match[1]);
            int lostCount = map.getOrDefault(match[1], 0);
            map.put(match[1], lostCount + 1);
        }
        for (Integer player : allPlayers) {
            if (!losers.contains(player)) {
                noLosers.add(player);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                lostOnlyOneMatch.add(entry.getKey());
            }
        }
        List<Integer> nonLosersLists = new ArrayList<>(noLosers);
        Collections.sort(nonLosersLists);
        ans.add(new ArrayList<>(nonLosersLists));
        List<Integer> lostOnlyOneMatchList = new ArrayList<>(lostOnlyOneMatch);
        Collections.sort(lostOnlyOneMatchList);
        ans.add(lostOnlyOneMatchList);
        return ans;
    }
}
