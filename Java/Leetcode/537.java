class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String x[] = num1.split("\\+|i");
        String y[] = num2.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int b_real = Integer.parseInt(y[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
    }
}