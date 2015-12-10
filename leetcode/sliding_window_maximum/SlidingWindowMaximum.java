import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0 || nums.length < k)
			return new int[0];

		Deque<Integer> deque = new ArrayDeque<Integer>();
		int[] ans = new int[nums.length - k + 1];

		for (int i = 0; i < k; i++) {
			while (deque.size() > 0 && nums[deque.peekLast()] <= nums[i])
				deque.removeLast();
			deque.addLast(i);
		}

		for (int i = k; i < nums.length; i++) {
			ans[i-k] = nums[deque.peekFirst()];
			while (deque.size() > 0 && deque.peekFirst() <= i-k)
				deque.removeFirst();
			while (deque.size() > 0 && nums[deque.peekLast()] <= nums[i])
				deque.removeLast();
			deque.addLast(i);
		}

		ans[ans.length-1] = nums[deque.peekFirst()];

		return ans;
	}

	public static void main(String[] args) {
		//for (String s : args)
		//	System.out.println(s);
		if (args.length > 1) {
			int k = Integer.valueOf(args[0]);
			int[] nums = new int[args.length-1];
			SlidingWindowMaximum solution = new SlidingWindowMaximum();

			for (int i = 0; i < args.length-1; i++)
				nums[i] = Integer.valueOf(args[i+1]);

			int[] result = solution.maxSlidingWindow(nums, k);
			System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
		}
	}
}
