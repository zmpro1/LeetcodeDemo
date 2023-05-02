package zm.leetcode.L1twosum;

import java.util.HashMap;
import java.util.Map;

//1.两数之和 https://leetcode.cn/problems/two-sum/
public class TwoNumMain {

    public int[] twoSum_own(int[] nums, int target) {
        if (nums.length == 2)
            return new int[]{0, 1};

        for (int i = 0 ; i < nums.length - 1 ; i++) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum_official(int[] nums, int target) {
        if (nums.length == 2)
            return new int[]{0, 1};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) ){
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        TwoNumMain main = new TwoNumMain();
        int[] ints = main.twoSum_official(new int[]{2, 7, 11, 15}, 26);
        System.out.println(ints[0] + "," + ints[1]);
    }
}
