# CourtneyThanHW2
## How to run:
### Download ProblemOne.java and ProblemTwo.java<br/>Open command prompt and run "javac ProblemOne.java" or "javac ProblemTwo.java" and "java ProblemOne" or "java ProblemTwo"<br/>The result will be printed out in the command line
## Documentation:
## Problem One:
### (Explaination): Before the game starts, the guests decided that the first version that goes in will be the leader. When a guest enter the maze, they'll eat the cake if they have not done so already. The leader is responible to check whether or not there's a cake on the plate. If there's no cake, then the leader will increment the counter representing the number of guest that enter the maze. All the guests will enter the maze in order but the guests didn't know that. So the leader will keep counting and keep playing even though every guests will be guaranteed enter in the first iteration to make sure that no matter what order the guests enter in.
### (Code Analysis): My program simulates this problem by initializing an array of threads with the size equal too the number of guests then creating the queue representing the order of in which the guests enter the maze, then iterating through the while loop that runs each thread in the array and breaks when the leader has counted n number of empty plates. Inside each thread, the run function first checks whether or not the current thread is a leader or a guest. If the current thread is a leader, then it increments the counter and prints it out. If the current thread is a guest, then it checks if the guest already ate the cake, if they already ate the cake, then the program will prints out that the guest already ate the cake. If not, then it will flag that the guest just ate the cake and the program will prints that the guest ate the cake.
## Problem One Excecution Time:
|   N   | Time (sec)|
|-------|----------|
| 10    | 0.0027 
| 100   | 0.0145 
| 1000  | 0.8411 
| 10000 | 23.8349
## Problem Two:
### (Explaination): The strategy that I chose is strategy 3. I chose this strategy out of the other two because it can perform more effectively. The first strategy is worse than strategy 3 because every thread is guaranteed to visit the room and there could be one thread that spends the entire execution time inside the room. The second strategy is also worse than strategy 3 because the sign can be implemented using a queue lock which is similar to my solution in problem 3.
### (Code Analysis): I started this problem off similar to the last problem where I created an array of thread of size n and initialize them. Then I created a queue and added each index of the array of threads into the queue in order. Then I created a for loop that will remove each index in the queue one by one and run the thread at that index. Inside each thread, the run function will prints that the guest has entered the room follow by the guest's leaving the room. Inside the run function, there is a 50% chance that the guest will want to re-enter the queue, if this happen then the index of the thread will be readded into the queue.
## Problem Two Excecution Time:
|   N   | Time (sec)|
|-------|----------|
| 10    | 0.0009
| 100   | 0.0027 
| 1000  | 0.0126 
| 10000 | 0.0794
