package com.GeeksForGeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LongestConsecutiveSubsequence {
    /*static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException e){ e.printStackTrace(); }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); }
            return str;
        }

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int[] a = new int[n];

            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            out.println(findLongestConseqSubseq(a, n));
            t--;
        }
        out.flush();
    }*/
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }*/
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        int n = arr.length;
        int answer = findLongestConseqSubseq(arr, n);
        System.out.println(answer);
    }
    private static int findLongestConseqSubseq(int[] arr, int n) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] temp = new int[max + 1];
        for(int i = 0; i < n; i++) {
            temp[arr[i]]++;
        }
        int answer = Integer.MIN_VALUE;
        int count = 1;
        for(int i = 0; i < temp.length - 1; i++) {
            if(temp[i] != 0 && temp[i + 1] != 0) {
                count++;
                answer = Math.max(answer, count);
            }
            else {
                count = 1;
            }
        }
        if(answer == Integer.MIN_VALUE) {
            return 1;
        }
        return answer;
    }
}
