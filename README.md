# Cracking_Leetcode
leetcode solution

## Advanced
| Id  | Name                         | Difficulty | Similar Problems |      |     |     |     |     | Comments         |
|-----|------------------------------|------------|------------------|------|-----|-----|-----|-----|------------------|
| 208 | Implement Trie (Prefix Tree) | ★★★        | 648              | 676  | 677 | 720 | 745 | 211 | Trie             |
| 307 | Range Sum Query - Mutable    | ★★★        |                  |      |     |     |     |     | BIT/Segment Tree |
| 901 | Online Stock Span            | ★★★        | 907              | 1019 |     |     |     |     | monotonic stack  |
| 239 | Sliding Window Maximum       | ★★★        |                  |      |     |     |     |     | monotonic queue  |


## Search
| Id  | Name                                  | Difficulty | Similar Problems |     |     |     |     |     | Comments    |
|-----|---------------------------------------|------------|------------------|-----|-----|-----|-----|-----|-------------|
| 17  | Letter Combinations of a Phone Number | ★★         | 39               | 40  | 77  | 78  | 90  | 216 | Combination |
| 46  | Permutations                          | ★★         | 47               | 784 | 943 | 996 |     |     | Permutation |
| 22  | Generate Parentheses                  | ★★★        | 301              |     |     |     |     |     | DFS         |
| 37  | Sudoku Solver                         | ★★★        | 51               | 52  |     |     |     |     | DFS         |
| 79  | Word Search                           | ★★★        | 212              |     |     |     |     |     | DFS         |
| 127 | Word Ladder                           | ★★★★       | 126              | 752 | 818 |     |     |     | BFS         |
| 542 | 01 Matrix                             | ★★★        | 675              | 934 |     |     |     |     | BFS         |
| 698 | Partition to K Equal Sum Subsets      | ★★★        | 93               | 131 | 241 | 282 | 842 |     | Partition   |


## DP
| Id                           | Name                             | Difficulty | Similar Problems |      |      |      |      | Comments                          |
|------------------------------|----------------------------------|------------|------------------|------|------|------|------|-----------------------------------|
| 70                           | Climbing Stairs                  | ★          | 746              | 1137 |      |      |      | I: O(n), S = O(n), T = O(n)       |
| 303                          | Range Sum Query - Immutable      | ★          | 1218             |      |      |      |      |                                   |
| 53                           | Maximum Subarray                 | ★★         | 121              |      |      |      |      |                                   |
| 62                           | Unique Paths                     | ★★         | 63               | 64   | 120  | 174  | 931  | I: O(mn), S = O(mn), T = O(mn)    |
|                              |                                  |            | 1210             |      |      |      |      |                                   |
| 85                           | Maximal Rectangle                | ★★★        | 221              | 304  | 1277 |      |      |                                   |
| 198                          | House Robber                     | ★★★        | 213              | 309  | 740  | 790  | 801  | I: O(n), S = O(3n), T = O(3n)     |
| 279                          | Perfect Squares                  | ★★★        |                  |      |      |      |      | I: n, S = O(n), T = O(n*sqrt(n))  |
| 139                          | Word Break                       | ★★★        | 140              | 818  |      |      |      | I: O(n), S = O(n), T = O(n^2)     |
| 300                          | Longest Increasing Subsequence   | ★★★        | 673              | 1048 |      |      |      |                                   |
| 96                           | Unique Binary Search Trees       | ★★★        |                  |      |      |      |      |                                   |
| 1105                         | Filling Bookcase Shelves         | ★★★        |                  |      |      |      |      | I: O(n) + t, S = O(n), T = O(n^2) |
| 131                          | Palindrome Partitioning          | ★★★        | 89               |      |      |      |      | I: O(n), S = O(2^n), T = O(2^n)   |
| 72                           | Edit Distance                    | ★★★        | 10               | 44   | 97   | 115  | 583  | I: O(m+n), S = O(mn), T = O(mn)   |
|                              |                                  |            | 712              | 1187 | 1143 | 1092 | 718  |                                   |
| 1139                         | Largest 1-Bordered Square        | ★★★        |                  |      |      |      |      | "I: O(mn), S = O(mn)              |
| T = O(mn*min(n,m))"          |
| 688                          | Knight Probability in Chessboard | ★★★        | 576              | 935  |      |      |      | "I: O(mn) + k                     |
| S = O(kmn), T = O(kmn)"      |
| 322                          | Coin Change                      | ★★★        | 377              | 416  | 494  | 1043 | 1049 | I: O(n) + k, S = O(n), T = O(kn)  |
|                              |                                  |            | 1220             | 1230 | 1262 | 1269 |      |                                   |
| 813                          | Largest Sum of Averages          | ★★★★       | 1278             | 1335 | 410  |      |      | "I: O(n) + k                      |
| S = O(n*k), T = O(kn^2)"     |
| 1223                         | Dice Roll Simulation             | ★★★★       |                  |      |      |      |      | "I: O(n) + k + p                  |
| S = O(k*p), T = O(n^2kp)"    |
| 312                          | Burst Balloons                   | ★★★★       | 664              | 1024 | 1039 | 1140 | 1130 | I: O(n), S = O(n^2), T = O(n^3)   |
| 741                          | Cherry Pickup                    | ★★★★       |                  |      |      |      |      | I: O(n^2), S = O(n^3), T = O(n^3) |
| 546                          | Remove Boxes                     | ★★★★★      |                  |      |      |      |      | I: O(n), S = O(n^3), T = O(n^4)   |
| 943                          | Find the Shortest Superstring    | ★★★★★      | 980              | 996  | 1125 |      |      | "I: O(n)                          |
| S = O(n*2^n), T = (n^2*2^n)" |


## Graph
| Id   | Name                              | Difficulty | Similar Problems |      |      |      |      | Comments                       |
|------|-----------------------------------|------------|------------------|------|------|------|------|--------------------------------|
| 133  | Clone Graph                       | ★★         | 138              |      |      |      |      | queue + hashtable              |
| 200  | Number of Islands                 | ★★         | 547              | 695  | 733  | 827  | 1162 | grid + connected components    |
| 841  | Keys and Rooms                    | ★★         | 1202             |      |      |      |      | DFS, connected components      |
| 207  | Course Schedule                   | ★★★        | 210              | 802  |      |      |      | topology sorting               |
| 399  | Evaluate Division                 | ★★★        | 839              | 952  | 990  | 721  | 737  | union find                     |
| 785  | Is Graph Bipartite?               | ★★★        | 886              | 1042 |      |      |      | bipartition, graph coloring    |
| 997  | Find the Town Judge               | ★★★        |                  |      |      |      |      | in/out degrees                 |
| 433  | Minimum Genetic Mutation          | ★★★        | 815              | 863  | 1129 | 1263 |      | unweighted shortest path / BFS |
| 684  | Redundant Connection              | ★★★★       | 685              | 1319 |      |      |      | cycle, union find              |
| 743  | Network Delay Time                | ★★★★       | 787              | 882  | 924  | 1334 |      | weighted shortest path         |
| 847  | Shortest Path Visiting All Nodes  | ★★★★       | 864              | 1298 |      |      |      | BFS                            |
| 332  | Reconstruct Itinerary             | ★★★★       |                  |      |      |      |      | Eulerian path                  |
| 1192 | Critical Connections in a Network | ★★★★       |                  |      |      |      |      | Tarjan                         |
| 943  | Find the Shortest Superstring     | ★★★★★      | 980              | 996  |      |      |      | Hamiltonian path (DFS / DP)    |
| 959  | Regions Cut By Slashes            | ★★★★★      |                  |      |      |      |      | union find / grid + CCs        |


## Tree
| Id  | Name                                    | Difficulty | Similar Problems |      |     |     |     | Comments                      |
|-----|-----------------------------------------|------------|------------------|------|-----|-----|-----|-------------------------------|
| 94  | Binary Tree Inorder Traversal           | ★          | 144              | 145  | 429 | 589 | 590 | traversal                     |
|     |                                         |            | 987              | 1302 |     |     |     |                               |
| 100 | Same Tree                               | ★★         | 101              | 104  | 110 | 111 | 572 |                               |
|     |                                         |            | 965              |      |     |     |     |                               |
| 102 | Binary Tree Level Order Traversal       | ★★         | 107              | 429  | 872 |     |     | collecting nodes              |
| 814 | Binary Tree Pruning                     | ★★★        | 669              | 1325 |     |     |     |                               |
| 112 | Path Sum                                | ★★★        | 113              | 437  |     |     |     |                               |
| 129 | Sum Root to Leaf Numbers                | ★★★        | 257              |      |     |     |     |                               |
| 236 | Lowest Common Ancestor of a Binary Tree | ★★★        | 235              |      |     |     |     |                               |
| 297 | Serialize and Deserialize Binary Tree   | ★★★        | 449              |      |     |     |     |                               |
| 508 | Most Frequent Subtree Sum               | ★★★        |                  |      |     |     |     |                               |
| 124 | Binary Tree Maximum Path Sum            | ★★★        | 543              | 687  |     |     |     | Use both children, return one |
| 968 | Binary Tree Cameras                     | ★★★★       | 337              | 979  |     |     |     |                               |


## Binary Search
| Id  | Name                                    | Difficulty | Similar Problems |     |     |     |     |   |   | Comments            |
|-----|-----------------------------------------|------------|------------------|-----|-----|-----|-----|---|---|---------------------|
| 35  | Search Insert Position                  | ★★         | 34               | 704 | 981 |     |     |   |   | upper_bound         |
| 33  | Search in Rotated Sorted Array          | ★★★        | 81               | 153 | 154 | 162 | 852 |   |   | rotated / peak      |
| 69  | Sqrt(x)                                 | ★★★        |                  |     |     |     |     |   |   | upper_bound         |
| 74  | Search a 2D Matrix                      | ★★★        |                  |     |     |     |     |   |   | treat 2d as 1d      |
| 875 | Koko Eating Bananas                     | ★★★        | 1011             |     |     |     |     |   |   | guess ans and check |
| 4   | Median of Two Sorted Arrays             | ★★★★       |                  |     |     |     |     |   |   |                     |
| 378 | Kth Smallest Element in a Sorted Matrix | ★★★★       | 668              |     |     |     |     |   |   | kth + matrix        |
| 719 | Find K-th Smallest Pair Distance        | ★★★★       | 786              |     |     |     |     |   |   | kth + two pointers  |


## BST
| Id  | Name                                       | Difficulty | Similar Problems |   |   |   |   | Comments      |
|-----|--------------------------------------------|------------|------------------|---|---|---|---|---------------|
| 98  | Validate Binary Search Tree                | ★★         | 530              |   |   |   |   | inorder       |
| 700 | Search in a Binary Search Tree             | ★★         | 701              |   |   |   |   | binary search |
| 230 | Kth Smallest Element in a BST              | ★★★        |                  |   |   |   |   | inorder       |
| 99  | Recover Binary Search Tree                 | ★★★        |                  |   |   |   |   | inorder       |
| 108 | Convert Sorted Array to Binary Search Tree | ★★★        |                  |   |   |   |   | build BST     |
| 501 | Find Mode in Binary Search Tree            | ★★★        |                  |   |   |   |   | inorder       |
| 450 | Delete Node in a BST                       | ★★★★       |                  |   |   |   |   | binary search |


## List
| Id  | Name                 | Difficulty | Similar Problems |   |   |   |   |   |   | Comments                   |
|-----|----------------------|------------|------------------|---|---|---|---|---|---|----------------------------|
| 2   | Add Two Numbers      | ★★         | 445              |   |   |   |   |   |   | traversal                  |
| 24  | Swap Nodes in Pairs  | ★★         |                  |   |   |   |   |   |   | reverse                    |
| 206 | Reverse Linked List  | ★★         |                  |   |   |   |   |   |   | reverse                    |
| 141 | Linked List Cycle    | ★★         | 142              |   |   |   |   |   |   | fast/slow                  |
| 23  | Merge k Sorted Lists | ★★★        | 21               |   |   |   |   |   |   | priority_queue / mergesort |
| 147 | Insertion Sort List  | ★★★        |                  |   |   |   |   |   |   | insertion sort             |
| 148 | Sort List            | ★★★★       |                  |   |   |   |   |   |   | merge sort O(1) space      |
| 707 | Design Linked List   | ★★★★       |                  |   |   |   |   |   |   |                            |


## Two Pointers
| Id  | Name                                | Difficulty | Similar Problems |     |     |   |   |   |   | Comments   |
|-----|-------------------------------------|------------|------------------|-----|-----|---|---|---|---|------------|
| 11  | Container With Most Water           | ★★         | 42               |     |     |   |   |   |   |            |
| 125 | Valid Palindrome                    | ★★         | 455              |     |     |   |   |   |   |            |
| 917 | Reverse Only Letters                | ★★         | 925              | 986 | 855 |   |   |   |   |            |
| 167 | Two Sum II - Input array is sorted  | ★★★        | 15               | 16  |     |   |   |   |   |            |
| 977 | Squares of a Sorted Array           | ★★         |                  |     |     |   |   |   |   | merge sort |
| 992 | Subarrays with K Different Integers | ★★★★       |                  |     |     |   |   |   |   |            |


## Divide and Conquer
| Id  | Name                                 | Difficulty | Similar Problems |   |   |   |   | Comments         |
|-----|--------------------------------------|------------|------------------|---|---|---|---|------------------|
| 169 | Majority Element                     | ★★         |                  |   |   |   |   | 你知道茴香豆的茴有几种写法吗？  |
| 153 | Find Minimum in Rotated Sorted Array | ★★         | 154              |   |   |   |   |                  |
| 912 | Sort and Array                       | ★★★        |                  |   |   |   |   | merge sort       |
| 315 | Count of Smaller Numbers After Self  | ★★★★       |                  |   |   |   |   | merge sort / BIT |
