class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //make sure we select two distinct card
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    //put the rare card in list2
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    //choose an operation to deal with the selected two cards
                    for (int k = 0; k < 4; k++) {
                        //if the operation is add or multiply, and we have deal these before, we can avoid doing this again
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            //the divider cannot be 0
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        //backtrack
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}



class Solution {
    private static final double EPS = 1e-6;
    private boolean backtrack(double[] A, int n) {
        if(n == 1) return Math.abs(A[0] - 24) < EPS;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double a = A[i], b = A[j];
                A[j] = A[n-1];
                A[i] = a + b;
                if(backtrack(A, n - 1)) return true;
                A[i] = a - b;
                if(backtrack(A, n - 1)) return true;
                A[i] = b - a;
                if(backtrack(A, n - 1)) return true;
                A[i] = a * b;
                if(backtrack(A, n - 1)) return true;
                if(Math.abs(b) > EPS) {
                    A[i] = a / b;
                    if(backtrack(A, n - 1)) return true;
                }
                if(Math.abs(a) > EPS) {
                    A[i] = b / a;
                    if(backtrack(A, n - 1)) return true;
                }
                A[i] = a; A[j] = b;
            }
        }
        return false;
    }
    public boolean judgePoint24(int[] nums) {
        double[] A = new double[nums.length];
        for(int i = 0; i < nums.length; i++) A[i] = nums[i];
        return backtrack(A, A.length);
    }
}