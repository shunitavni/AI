# Puzzel - X

**Problem Description**

implement a search engine that supports several search algorithms to solve the following problem: "the X puzzle"
Given an NxN game board, where one slot is empty and each of the other slots contains a number
From 1 to n * n -1 (in any order when the goal is to move the squares so that they are displayed in the goal position.
The target state is set to be an ascending order of the numbers with the empty box at the end.\
<br/>
For example:

![alt text](https://github.com/shunitavni/AI/blob/master/Images/puzzel.png)


The left image represents a (slight) disordered state of a 3x3 board, and the right image represents the
Objective status.


**movement:**<br/>
At each stage, one of the numbered squares can be moved towards the empty square. When the options
Available to us are up, down, right, left - any of the options whenever possible.
Dodge: In the image above the option above is not possible.
The cost of each movement is fixed - a cost of 1.

**implementation:**<br/>
Input - The program will read its input from a single input.txt file. The first line in the file will determine which one
Algorithm to use: We will support 3 searched algorithms: BFS, IDS, and A *.
Determining the type of algorithm using the encoding:

- 1 for IDS
- 2 for BFS
- 3 for A *

The second line will say the size of the board.
The third line will be written in the initial state of the game board.<br/>

***Output*** - The program will write into a file named output.txt and it will contain one line in the following format:
A route is described by the series of actions required to get from the initial state to the end state.

The actions are :
- R (Right) 
- L (Left)
- D (Down)
- U (Up)

** capital letters.

** For example, RDRU describes a right, down, right, and up a route.


***Note:***

In implementing all of the above algorithms an additional CLOSE LIST list should also be used.
Check: If a descendant vertex is already in one of the lists (OPEN \ (CLOSE), there is no need to enter the vertex at all.
In A *, if the child vertex is already in the CLOSE LIST, there is no need to enter the vertex at all.
If it is in OPEN LIST, and now we have a new value lower than that which has the same vertex in OPEN LIST, the OPEN LIST must be updated with the new value.


In implementing the A * algorithm - the Manhattan distance function should be used.

Example: input.txt:
2
4
1-2-3-4-5-6-7-8-9-10-11-12-13-0-14-15

Example of output.txt:
LL
