package leetcode;

public class Array1 {

    public int[] getConcatenation(int[] nums) { //Q1
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }

        return res;
    }

    public int[] shuffle(int[] nums, int n) { //Q2
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[i + n];
        }

        return res;
    }

}
