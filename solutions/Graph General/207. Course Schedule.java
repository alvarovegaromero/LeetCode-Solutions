//https://leetcode.com/problems/course-schedule

// Time Complexity - O(V + E) - V is number of vertices (courses) and E is number of edges (prerequisites)
// Space Complexity - O(V + E)

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(course).add(prerequisite);
        }

        // Track visited courses
        Set<Integer> visited = new HashSet<>();
        // Track courses in the current DFS path
        Set<Integer> path = new HashSet<>();

        // Run DFS for each course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visited, path)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course,
                        List<List<Integer>> graph,
                        Set<Integer> visited,
                        Set<Integer> path) {

        // If the course is already in the current path, a cycle is detected
        if (path.contains(course)) {
            return false;
        }

        // If the course has already been visited, it is safe
        if (visited.contains(course)) {
            return true;
        }

        // Add course to the current path
        path.add(course);

        // Visit all prerequisites
        for (int prereq : graph.get(course)) {
            if (!dfs(prereq, graph, visited, path)) {
                return false;
            }
        }

        // Remove course from the current path
        path.remove(course);
        // Mark course as visited
        visited.add(course);

        return true;
    }
}
