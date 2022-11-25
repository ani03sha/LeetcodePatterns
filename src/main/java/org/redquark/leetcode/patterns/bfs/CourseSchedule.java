package org.redquark.leetcode.patterns.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Special cases
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        // Array to represent indegree of each node which shows how many
        // prerequisites are needed to complete this course
        int[] inDegrees = new int[numCourses];
        // Populate the in-degrees
        for (int[] ints : prerequisites) {
            int course = ints[0];
            inDegrees[course]++;
        }
        // Queue to add independent course (whose in-degree is zero)
        // If the indegree of a course is zero it means we can complete it
        final Queue<Integer> completedCourses = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                completedCourses.offer(i);
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
                int preRequistedCourse = prerequisite[1];
                if (preRequistedCourse == completedCourse) {
                    // Decrease the in-degree of courseToComplete by 1
                    inDegrees[courseToComplete]--;
                    // If all the prerequisite courses are completed, then
                    // we can add this courseToComplete to the completedCourses
                    // queue and increment the completedCoursesCount by 1
                    if (inDegrees[courseToComplete] == 0) {
                        completedCoursesCount++;
                        completedCourses.offer(prerequisite[0]);
                    }
                }
            }
        }
        // If the completedCoursesCount is equal to the total number
        // of courses, we return true, else false.
        return completedCoursesCount == numCourses;
    }
}
