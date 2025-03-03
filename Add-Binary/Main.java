// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> list = new ArrayList<>();
//         int max = 1 << nums.length;

//         System.out.println("max: " + max);

//         List<Integer> l0 = new ArrayList<>();
//         list.add(l0);

//         for (int i = 1; i < max; i++) {
//             int temp = i;
//             int index = 0;
//             List<Integer> l = new ArrayList<>();
//             System.out.println("temp: " + temp);
//             System.out.println("Binary : " + Integer.toBinaryString(temp));
//             while (temp != 0) {
//                 if ((temp & 1) == 1) {
//                     l.add(nums[index]);
//                 }
//                 System.out.println("l -> " + l);
//                 System.out.println("index: " + index);
//                 temp >>= 1;
//                 index++;
//             }
//             list.add(l);
//             System.out.println("LIST -> " + list);
//             System.out.println();

//         }
//         return list;
//     }
// }

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static boolean isPalindrome(String s) {
        char sArr[] = s.toCharArray();
        int sLength = sArr.length;
        char res = 0;
        if ((sLength & 1) == 0) {
            for (char c : sArr) {
                res ^= c;
            }
            if (res == 0) {
                return true;
            }
            return false;
        } else {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : sArr) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            final AtomicInteger countOdd = new AtomicInteger(0);
            map.forEach((_, v) -> {
                if ((v & 1) == 1) {
                    countOdd.incrementAndGet();
                }
            });
            if (countOdd.get() == 1) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abccecba";
        System.out.println(isPalindrome(s));
    }

    // public static void main(String[] args) {
    // Solution s = new Solution();
    // int[] nums = { 1, 2, 3 };
    // List<List<Integer>> result = s.subsets(nums);
    // for (List<Integer> l : result) {
    // System.out.println(l);
    // }
    // }
}
