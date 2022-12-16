package org.redquark.leetcode.patterns.bucketsort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

    /**
     * Time complexity - O(1)
     * Space complexity - O(n)
     */
    static class FreqStack {
        // Map to store frequencies of elements
        private final Map<Integer, Integer> frequencies;
        // Map to store a frequency and a stack of elements
        // with that frequency
        private final Map<Integer, Stack<Integer>> frequencyStackMappings;
        // Variable to represent maximum frequency
        private int maximumFrequency;

        public FreqStack() {
            this.frequencies = new HashMap<>();
            this.frequencyStackMappings = new HashMap<>();
        }

        public void push(int val) {
            // Get the current frequency of the element val
            int frequency = this.frequencies.getOrDefault(val, 0);
            // Update the frequency by 1
            frequency++;
            // Add this frequency to the map
            this.frequencies.put(val, frequency);
            // Update the maximum frequency, if required
            this.maximumFrequency = Math.max(this.maximumFrequency, frequency);
            // Create/update the frequency and stack mapping
            if (!this.frequencyStackMappings.containsKey(frequency)) {
                this.frequencyStackMappings.put(frequency, new Stack<>());
            }
            this.frequencyStackMappings.get(frequency).push(val);
        }

        public int pop() {
            // Get the stack corresponding to the maximum frequency
            final Stack<Integer> elements = this.frequencyStackMappings.get(this.maximumFrequency);
            // Get the element to be returned
            int top = elements.pop();
            // Reduce the frequency of this element in the mappings
            this.frequencies.put(top, this.maximumFrequency - 1);
            // Check if the stack is empty against the current maximum frequency
            if (this.frequencyStackMappings.get(maximumFrequency).isEmpty()) {
                this.maximumFrequency--;
            }
            return top;
        }
    }
}
