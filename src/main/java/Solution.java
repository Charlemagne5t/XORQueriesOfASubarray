class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < res.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = l == 0 ? prefixXOR[r] : prefixXOR[r] ^ prefixXOR[l - 1];
        }

        return res;
    }
}