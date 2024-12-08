import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    // Sorting, O(nlogn) time, O(1) space
    public static int singleNumberSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    // Hash Table, O(n) time, O(n) space
    public static int singleNumberHashTable(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    // Math & Set, O(n) time, O(n) space
    public static int singleNumberMathSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            set.add(num);
            sum += num;
        }
        int sumSet = 0;
        for (int num : set) {
            sumSet += num;
        }
        return 2 * sumSet - sum;
    }

    // Set, O(n) time, O(n) space
    public static int singleNumberSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }

    // Bit Manipulation, O(n) time, O(1) space
    public static int singleNumberBitManipulation(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println();
        System.out.println("Sorting: " + singleNumberSort(nums));
        System.out.println("Hash Table: " + singleNumberHashTable(nums));
        System.out.println("Math & Set: " + singleNumberMathSet(nums));
        System.out.println("Set: " + singleNumberSet(nums));
        System.out.println("Bit Manipulation: " + singleNumberBitManipulation(nums));
    }
}

// Output:
// Array: [4, 1, 2, 1, 2]

// Sorting: 4
// Hash Table: 4
// Math & Set: 4
// Set: 4
// Bit Manipulation: 4
