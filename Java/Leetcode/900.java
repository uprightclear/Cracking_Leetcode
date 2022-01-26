class RLEIterator {
    int index;
    int [] encoding;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        index = 0;
    }
    
    public int next(int n) {
        while(index < encoding.length && n > encoding[index]){
            n = n - encoding[index];
            index += 2;
        }
        
        if(index >= encoding.length){
            return -1;
        }
        
        encoding[index] = encoding[index] - n;
        return encoding[index + 1];
    }
}