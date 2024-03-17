import java.util.Arrays;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);
        int len = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                len++;
            }
        }

        int[] nonZero = new int[len];
        int j = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                nonZero[j++] = freq[i];
            }
        }
        int res = Integer.MAX_VALUE;
        int countDeletions = 0;
        for (int i = 0; i < nonZero.length - 1; i++) {
            int c = 0;
            for (int l = nonZero.length - 1; l >= i; l--) {
                if (nonZero[l] - nonZero[i] - k > 0) {
                    c += nonZero[l] - nonZero[i] - k;
                }
            }
            res = Math.min(res, countDeletions + c);
            countDeletions += nonZero[i];

        }


        return Math.min(countDeletions, res);
    }
}