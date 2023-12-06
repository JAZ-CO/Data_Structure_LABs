package LAB11;

import java.util.Arrays;
import java.util.Scanner;

public class PSuffix {
    // task 1
    public static String findLongestPrefixSuffix(String str) {
        String prefix = "";
        String LPS = "";

        for (int i = 0; i < str.length()/2; i++) {
            // Add the current character to the prefix string
            prefix += str.charAt(i);
            // Store the suffix string
            String suffix = str.substring(str.length() - 1 - i, str.length());

            // Check if both the strings are equal or not
            if (prefix.equals(suffix))
                LPS = prefix;
        }
        return LPS;
    }

    // task 2
    public static void overlappingPatternSearch(String T, String P){
        //check if pattern exist anywhere
        if (T.indexOf(P) == -1){
            System.out.println("Pattern not found.");
            return;
        }

        for (int i = 0; i < T.length()-P.length()+1; i++) {
            // check if pattern equals to the next strings that has the same length
            if (P.equals(T.substring(i,P.length()+i))){
                //print
                System.out.println(T);
                System.out.println(" ".repeat(i)+P);
                System.out.println(" ".repeat(i)+i);
            }
        }

    }

    // task 3
    static void countSamePrefixSuffix(String s, int n)
    {
        // Stores the prefix string
        String prefix = "";
        for (int i = 0; i < n+1; i++) {
            // store a current string
            String current = s.substring(0,i);
            System.out.println("Substring: " + s.substring(0,i));
            prefix = "";
            for (int j = 0; j < i-1; j++) {
                // Add the current character to the prefix string
                prefix += s.charAt(j);

                // Store the suffix string
                String suffix = current.substring(current.length()-j-1, current.length());

                System.out.print("Proper prefix: " + prefix + ", Proper suffix: " + suffix);

                // Check if both the strings are equal or not
                if (prefix.equals(suffix)) {
                    System.out.print(" *" + prefix.length());
                }

                System.out.println();
            }
            System.out.println("-------------------------------");
        }
    }
    // task 4
    public static String searchKMP(String pattern, String text)
    {
        int M = pattern.length();
        int N = text.length();
        String indexes = "";

        // Preprocess the pattern (calculate lps[] array)
        // lps[] will hold the longest prefix suffix values for pattern
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                indexes += (i - j) + "  ";
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        if (indexes.isEmpty())
            return "Pattern not in text.";
        return indexes;
    }

    static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int lps[] = new int[M];
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args)
    {
        // task 1
        System.out.println("Enter a pattern to search for: ABABCABAB");
        String pattern = "ABABCABAB";
        String result = findLongestPrefixSuffix(pattern);
        System.out.println("Longest non-overlapping suffix that is also a prefix is: "+result+" its length is: "+ result.length());

        System.out.println("Enter a pattern to search for: ABCDE");
        String input = "ABCDE";
        String longestPrefixSuffix = findLongestPrefixSuffix(input);

        if (longestPrefixSuffix.isEmpty()) {
            System.out.println("No non-overlapping suffix that is also a prefix.");
        } else {
            System.out.println("Longest non-overlapping prefix-suffix: " + longestPrefixSuffix+" its length is: "+longestPrefixSuffix.length());
        }
        System.out.println();

        System.out.println("Enter a text string T: THIS IS KFUPM");
        String text = "THIS IS KFUPM";
        System.out.println("Enter a pattern string P: YES");
        pattern = "YES";
        overlappingPatternSearch(text,pattern);

        String S =  "ABCAABC";
        int N = S.length();
        countSamePrefixSuffix(S, N);

        System.out.println("Enter a text : ABABCABABABCABABCABABCABABKKKABABCABAB");
        text = "ABABCABABABCABABCABABCABABKKKABABCABAB";
        System.out.println("Enter a pattern to search for: ABABCABAB");
        pattern = "ABABAMK";
        System.out.println("Pattern found at these text starting indexes: "+searchKMP(pattern,text));

        System.out.println(Arrays.toString(computeLPSArray("ABCDE")));
    }
}


