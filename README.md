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
| 10    | 0.0027s 
| 100   | 0.0145s 
| 1000  | 0.8411s 
| 10000 | 23.8349s
