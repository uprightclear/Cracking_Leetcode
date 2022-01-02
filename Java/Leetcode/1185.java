class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* The days contributed by the year ahead of the current */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* The days contributed by the month ahead of the current in the given year */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献The days contributed by the current month */
        days += day;
        return week[(days + 3) % 7];
    }
}