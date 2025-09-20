//https://leetcode.com/problems/design-task-manager

class TaskManager {
    private PriorityQueue<int[]> priorityQueue;
    private Map<Integer, Integer> taskIdPriority;
    private Map<Integer, Integer> taskIdOwner;

    public TaskManager(List<List<Integer>> tasks) {
        priorityQueue = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) 
                return b[0] - a[0]; // more priority first
            return b[1] - a[1]; // in a draw, one with higher taskId 
        });
        taskIdPriority = new HashMap<>();
        taskIdOwner = new HashMap<>();
        
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId, taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        priorityQueue.add(new int[]{priority, taskId});
        taskIdPriority.put(taskId, priority);
        taskIdOwner.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        priorityQueue.add(new int[]{newPriority, taskId});
        taskIdPriority.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        taskIdPriority.put(taskId, -1);
    }
    
    public int execTop() {
        while (!priorityQueue.isEmpty()) {
            int[] task = priorityQueue.poll();
            int priority = task[0], taskId = task[1];

            if (taskIdPriority.getOrDefault(taskId, -2) == priority) {
                taskIdPriority.put(taskId, -1);
                return taskIdOwner.getOrDefault(taskId, -1);
            }
        }

        return -1;
    }
}