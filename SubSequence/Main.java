package SubSequence;

import java.util.*;

public class Main {
    public void getAllSubSequence(
            List<List<Integer>> result,
            List<Integer> subSeq,
            int idx, int sum, int k, int nums[]) {
        if (idx == nums.length) {
            if (sum == k) {
                result.add(new ArrayList<>(subSeq));
            }
            return;
        }
        subSeq.add(nums[idx]);
        sum += nums[idx];
        getAllSubSequence(result, subSeq, idx + 1, sum, k, nums);

        subSeq.remove(subSeq.size() - 1);
        sum -= nums[idx];
        getAllSubSequence(result, subSeq, idx + 1, sum, k, nums);
    }

    public boolean getFirstSubSequence(
            List<List<Integer>> result,
            List<Integer> subSeq,
            int idx, int sum, int k, int nums[]) {
        if (idx == nums.length) {
            if (sum == k) {
                result.add(new ArrayList<>(subSeq));
                return true;
            }
            return false;
        }
        subSeq.add(nums[idx]);
        sum += nums[idx];
        if (getFirstSubSequence(result, subSeq, idx + 1, sum, k, nums)) {
            return true;
        }

        subSeq.remove(subSeq.size() - 1);
        sum -= nums[idx];
        return getFirstSubSequence(result, subSeq, idx + 1, sum, k, nums);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int k = 3;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSeq = new ArrayList<>();
        Main obj = new Main();
        obj.getAllSubSequence(result, subSeq, 0, 0, k, nums);
        System.out.println("All Sub Sequences Equal To K: ");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        result.clear();
        subSeq.clear();
        if (obj.getFirstSubSequence(result, subSeq, 0, 0, k, nums)) {
            System.out.println("First Sub Sequence Equal To K: ");
            System.out.println(result.get(0));
        } else {
            System.out.println("No Sub Sequence Equal To K");
        }
    }
}
