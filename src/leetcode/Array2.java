package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Array2 {

    static void main() {

    }

    public int[] findErrorNums(int[] nums) { // Q1
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                if (nums[i] == 1) {
                    return new int[]{1, 2};
                }

                return i != 0 ? new int[]{nums[i], nums[i] + 1} : new int[]{2, 1};
            }
        }
        return new int[]{};
    }

    public int[] smallerNumbersThanCurrent(int[] nums) { // Q2
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }

    public static List<Integer> findDisappearedNumbersOLD(int[] nums) {
        List<Integer> res = new ArrayList<>();

        outerLoop:
        for (int i = 1; i <= nums.length; i++) {
            for (int j : nums) {
                if (i == j) {
                    continue outerLoop;
                }
            }
            res.add(i);
        }

        return res;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= nums.length; i++) {
            if (res.contains(i)) {
                res.removeAll(Collections.singleton(i));
            } else {
                res.add(i);
            }
        }

        return res.stream().toList();
    }

}
