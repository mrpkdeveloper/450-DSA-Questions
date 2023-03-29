package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Schedule Tasks on Minimum Machines
 *
 * Given a set of n number of tasks, implement a task scheduler method, tasks(), to run in O(n logn) time that finds the minimum number of machines required to complete these n tasks.
 * Constraints:
 *
 * Task start time ≤ Task end time
 */
public class MinMachineScheduledTasks {


        /**
         * Explanation:
         *
         * We first sort the tasks based on their start times.
         * Then we iterate through the tasks and use a min heap to store the end times of the tasks that are currently being processed.
         * For each task, we check the min heap to see if there are any tasks that have ended before the current task starts. If so, we remove them from the min heap.
         * We add the end time of the current task to the min heap.
         * We update the number of machines needed for the current task by comparing the current size of the min heap with the previous number of machines.
         * @param tasksList
         * @return
         */
        public static int tasks(ArrayList<ArrayList<Integer>> tasksList) {
            int machines = 0;

            // Create a min heap to store end times of tasks
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Sort the tasks based on start times
            tasksList.sort(Comparator.comparingInt(a -> a.get(0)));

            // Iterate through the tasks
            for (ArrayList<Integer> task : tasksList) {
                int startTime = task.get(0);
                int endTime = task.get(1);

                // While there are tasks in the min heap that have ended before the current task starts
                while (!minHeap.isEmpty() && minHeap.peek() <= startTime) {
                    minHeap.poll();
                }

                // Add the end time of the current task to the min heap
                minHeap.offer(endTime);

                // Update the number of machines needed for the current task
                machines = Math.max(machines, minHeap.size());
            }

            return machines;
        }

        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> tasksList = new ArrayList<>();
            tasksList.add(new ArrayList<>(Arrays.asList(1, 7)));
            tasksList.add(new ArrayList<>(Arrays.asList(8, 9)));
            tasksList.add(new ArrayList<>(Arrays.asList(3, 6)));
            tasksList.add(new ArrayList<>(Arrays.asList(9, 14)));
            tasksList.add(new ArrayList<>(Arrays.asList(6, 7)));

            int minMachines = tasks(tasksList);
            System.out.println("Minimum number of machines required: " + minMachines);
            // Output: Minimum number of machines required: 2
        }
}
