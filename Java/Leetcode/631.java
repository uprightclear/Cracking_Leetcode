public class Excel {
    Cell[][] table;

    public Excel(int H, char W) {
        table = new Cell[H+1][W-'A'+1];
    }
    
    public void set(int r, char c, int v) {
        if(table[r][c-'A'] == null) table[r][c-'A'] = new Cell (v); 
        else table[r][c-'A'].setValue(v); 
    }
    
    public int get(int r, char c) {
        if(table[r][c-'A'] == null) return 0;
        else return table[r][c-'A'].getValue();  
    }
    
    public int sum(int r, char c, String[] strs) {
        if (table[r][c-'A'] == null) {
            table[r][c-'A'] = new Cell(strs);
        } else {
            table[r][c-'A'].setFormula(strs);
        }
        
        return table[r][c-'A'].getValue();
    }
    
    
    private class Cell{
        int val = 0;
        HashMap<Cell, Integer> formula = new HashMap<>();//one cell might appear multiple times
        
        public Cell(int val){
            setValue(val); 
        }
        public Cell(String[] formulaStr){
            setFormula(formulaStr);
        }
        
        public void setValue(int val) {           
            formula.clear(); //will not be treated as a formula cell anymore        
            this.val = val;
        }
        
        public void setFormula(String[] formulaStr){
            formula.clear();            
            for(String str : formulaStr){
                if (str.indexOf(":") < 0){
                    int[] pos = getPos(str);
                    addFormulaCell(pos[0], pos[1]);
                } else {
                    String[] pos = str.split(":");
                    int[] startPos = getPos(pos[0]);
                    int[] endPos = getPos(pos[1]);
                    for(int r = startPos[0]; r <= endPos[0]; r++){
                        for(int c = startPos[1]; c <= endPos[1]; c++){
                            addFormulaCell(r, c);
                        }
                    }
                }
            }
        }
        
        private int[] getPos(String str){
            int[] pos = new int[2];
            pos[1] = str.charAt(0)-'A';
            pos[0] = Integer.parseInt(str.substring(1));
            return pos;
        }
        
        private void addFormulaCell(int r, int c){
            if(table[r][c] == null) table[r][c] = new Cell(0);
            Cell rangeCell = table[r][c];                            
            formula.put(rangeCell, (formula.containsKey(rangeCell) ? formula.get(rangeCell) : 0) + 1);
        }
        
        //recursive method
        private int getValue(){
            if(this.formula.isEmpty()) return this.val;
            int sum = 0;
            for(Cell cell : formula.keySet()){
                sum += cell.getValue() * formula.get(cell);
            }
            return sum;
        }
    }
}