import java.util.Arrays;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

    }
}