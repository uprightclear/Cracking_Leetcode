class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        // If the current rectangle does not contain any ships, return 0.         
        if (bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1])
            return 0;
        if (!sea.hasShips(topRight, bottomLeft))
            return 0;

        // If the rectangle represents a single point, a ship is located
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1])
            return 1;

        // Recursively check each of the 4 sub-rectangles for ships
        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;
        return countShips(sea, new int[]{midX, midY}, bottomLeft) +
               countShips(sea, topRight, new int[]{midX + 1, midY + 1}) +
               countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1}) +
               countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
    }
}