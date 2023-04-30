# Disk-Schedualing
Simutlation to OS  Disk Schedualing algorithms schedule I/O requests arriving for the disk.
Scheduling Algorithms:

1 - FCFS scheduling algorithm -> It services the IO requests in the order in which they arrive. There is no starvation in this algorithm, every request is                                  serviced.
2-SSTF (shortest seek time first) algorithm -> It allows the head to move to the closest track in the service queue.
3-SCAN scheduling and C-SCAN scheduling -> It works in the way an elevator works, elevator moves in a direction completely till the last floor of that                                                direction and then turns back.
4-LOOK Scheduling -> This algorithm tries to overcome the overhead of SCAN algorithm which forces disk arm to move in one direction till the end regardless                      of knowing if any request exists in the direction or not.
5-C-LOOK scheduling ->In this algorithm, the arm of the disk moves outwards servicing requests until it reaches the highest request cylinder, then it jumps                       to the lowest request cylinder without servicing any request then it again start moving outwards servicing the remaining requests.
