/* The knows API is defined in the parent class Relation.
    boolean knows(int a, int b); */

class Solution extends Relation {
    public int findCelebrity(int n) {
        int possibleCelebrity = 0;
        for (int i = 1; i < n; i++) {
            // if true, then possibleCelebrity cannot be the real celebrity because real celebrity should know nobody
            // if false, then i cannot be the celebrity because celebrity should be known by all the other ones
            if (knows(possibleCelebrity, i)) {
                possibleCelebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            // this possibleCelebrity do know i
            // real celebrity should know nobody, so the possibleCelebrity is not the real celebrity
            if (i != possibleCelebrity && knows(possibleCelebrity, i)) {
                return -1;
            }

            // this possibleCelebrity are not known by i
            // real celebrity should be known by all the other ones, so the possibleCelebrity is not the real celebrity
            if (i != possibleCelebrity && !knows(i, possibleCelebrity)) {
                return -1;
            }
        }

        return possibleCelebrity;
    }
}