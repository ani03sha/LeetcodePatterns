package org.redquark.leetcode.patterns.arrays;

public class FindTheDuplicateNumber {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int findDuplicate(int[] nums) {
        // The catch in this problem is that the repeated
        // number can occur any number of times (not just
        // two times). We need to keep this thing in mind
        // while thinking about the solution.

        // We can also leverage the fact that the array
        // contains elements only from 1 to n + 1, and we
        // can play around with the array indices.

        // We can use Floyd's cycle detection algorithm here.

        // Slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];
        // Moving slow pointer one hop
        slow = nums[slow];
        // Moving fast pointer two hops
        fast = nums[nums[fast]];
        // Loop until the two pointers meet
        while (slow != fast) {
            // One hop
            slow = nums[slow];
            // Two hops
            fast = nums[nums[fast]];
        }
        // At this point, the slow and fast pointers will be pointing
        // to the same element. Thus, we can move slow pointer to the
        // start and move both pointers one hop.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
