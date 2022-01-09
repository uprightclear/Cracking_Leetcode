class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        
        int x = 0, y = 0, dir = 0;
        
        for(char c : instructions.toCharArray()) {
            if(c == 'L') {
                dir = (dir + 1) % 4;
            }else if(c == 'R') {
                dir = (dir + 3) % 4;
            }else {
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        
        return (x == 0 && y == 0) || dir != 0;
    }
}

//with comment
class Solution {
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;
        
        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];   
            }    
        }
        
        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}