import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Main {
    // Brute Force, TC: O(n^2), SC: O(1)
    public static int[] twoSumBruteForce(int nums[], int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // Two Pointer( Sorted Array ), TC: O(n), SC: O(1)
    public static int[] twoSumTwoPointer(int nums[], int target) {

        // if array is not sorted
        // Arrays.sort(nums); // TC: O(nlogn), so the overall TC: O(nlogn)
        int numsLength = nums.length;
        int left = 0, right = numsLength - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    // Two Pass Hash Table, TC: O(n), SC: O(n)
    public static int[] twoSumTwoPassHashTable(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < numsLength; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[] { -1, -1 };
    }

    // One Pass Hash Table, TC: O(n), SC: O(n)
    public static int[] twoSumOnePassHashTable(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // Set, TC: O(n), SC: O(n)
    public static int[] twoSumSet(int nums[], int target) {
        HashSet<Integer> set = new HashSet<>();
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            int complement = target - nums[i];
            if (set.contains(complement)) {
                return new int[] { indexOf(nums, complement), i };
            }
            set.add(nums[i]);
        }
        return new int[] { -1, -1 };
    }

    private static int indexOf(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int nums[] = { 2, 7, 11, 15 }; // This will work for Two Pointer
        int nums[] = { 4, 6, 3, 2 }; // This will not work for Two Pointer as it requires sorted array
        int target = 9;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println();

        System.out.println("Brute Force: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("Two Pointer (Sorted Array): " + Arrays.toString(twoSumTwoPointer(nums, target)));
        System.out.println("Two Pass Hash Table : " + Arrays.toString(twoSumTwoPassHashTable(nums, target)));
        System.out.println("One Pass Hash Table : " + Arrays.toString(twoSumOnePassHashTable(nums, target)));
        System.out.println("Set : " + Arrays.toString(twoSumSet(nums, target)));
    }
}

// Output:
// Array: [4, 6, 3, 2]
// Target: 9

// Brute Force: [1, 2]
// Two Pointer (Sorted Array): [-1, -1]
// Two Pass Hash Table : [1, 2]
// One Pass Hash Table : [1, 2]
// Set : [1, 2]
