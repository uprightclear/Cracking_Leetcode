class Solution {
    public int buildWall(int height, int width, int[] bricks){
        List<Integer> validRows = new ArrayList<>();
        buildRows(0, width, bricks, 0, validRows);
        Map<Integer, Long> dp = new HashMap<>();
        Map<Integer, List<Integer>> transitions = new HashMap<>();
        for(Integer row : validRows){
            transitions.put(row, new ArrayList<>());
            dp.put(row, 1L);
        }
        for(Integer from : validRows)
            for(Integer to : validRows)
                if((from & to) == 0)
                    transitions.get(from).add(to);
        while(--height > 0){
            Map<Integer, Long> nextDp = new HashMap<>();
            for(Integer next : validRows){
                long count = 0;
                for(Integer prev : transitions.get(next))
                    count = (count + dp.get(prev)) % 1_000_000_007;
                nextDp.put(next, count);
            }
            dp = nextDp;
        }
        return (int) (dp.values().stream().mapToLong(n -> n).sum() % 1_000_000_007);
    }

    void buildRows(int currWidth, int width, int[] bricks, int rowMask, List<Integer> r){
        for(int brick : bricks)
            if(currWidth + brick == width)
                r.add(rowMask);
            else if(currWidth + brick < width)
                buildRows(currWidth + brick, width, bricks, rowMask | (1 << (currWidth + brick)), r);
    }
}