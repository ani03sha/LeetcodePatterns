package org.redquark.leetcode.patterns.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    /**
     * Time complexity - O(V * E)
     * Space complexity - O(v)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Special cases
        if (numCourses == 0) {
            return new int[]{};
        }
        // Array to represent indegree of each node which shows how many
        // prerequisites are needed to complete this course
        int[] inDegrees = new int[numCourses];
        // Populate the in-degrees
        for (int[] ints : prerequisites) {
            int course = ints[0];
            inDegrees[course]++;
        }
        // List to store the valid order of course completion
        List<Integer> validCourseCompletionOrder = new ArrayList<>();
        // Queue to add independent course (whose in-degree is zero)
        // If the indegree of a course is zero it means we can complete it
        final Queue<Integer> completedCourses = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                completedCourses.offer(i);
                validCourseCompletionOrder.add(i);
            }
        }
        // Count of the courses we can finish successfully
        // Since at this time, all the courses in the queue
        // are finished, we will assign this count to the value
        // of the size of the queue
        int completedCoursesCount = completedCourses.size();
        // Loop through the queue
        while (!completedCourses.isEmpty()) {
            // Get the current independent course as it is already finished
            int completedCourse = completedCourses.remove();
            // Loop through the prerequisites array and check if the current
            // completed course is a prerequisite of any other course
            for (int[] prerequisite : prerequisites) {
                int courseToComplete = prerequisite[0];
                int prerequisiteCourse = prerequisite[1];
                if (prerequisiteCourse == completedCourse) {
                    // Decrease the in-degree of courseToComplete by 1
                    inDegrees[courseToComplete]--;
                    // If all the prerequisite courses are completed, then
                    // we can add this courseToComplete to the completedCourses
                    // queue and increment the completedCoursesCount by 1
                    if (inDegrees[courseToComplete] == 0) {
                        // Add this course to the completed courses list
                        validCourseCompletionOrder.add(courseToComplete);
                        completedCoursesCount++;
                        completedCourses.offer(prerequisite[0]);
                    }
                }
            }
        }
        // If the completed course count is not equal to the total
        // number of courses.
        if (completedCoursesCount != numCourses) {
            return new int[]{};
        }
        // Store the completion order in an array
        int[] validOrderArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            validOrderArray[i] = validCourseCompletionOrder.get(i);
        }
        return validOrderArray;
    }
}
