package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    static int[] n1 = new int[]{1, 3};
    static int[] n2 = new int[]{2};

    static void main() {
        System.out.println(findMedianSortedArrays(n1, n2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            list.add(i);
        }

        for (int i : nums2) {
            list.add(i);
        }

        List<Integer> together = list.stream().sorted().toList();

        if (together.size() % 2 == 0) {
            return (double) (together.get((together.size() / 2) - 1) + together.get(((together.size() / 2) - 1) + 1)) / 2;
        } else {
            return together.get((int) (((double) together.size() / 2) - 0.5));
        }

    }

}
