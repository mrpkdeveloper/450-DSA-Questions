package Backtracking_And_Memoraization;

import java.util.ArrayList;
import java.util.List;

public class splitintofibbonacciseq {

    public List<Integer> splitIntoFibonacci(String num) {

        int len = num.length();
        ArrayList<Integer> answer = new ArrayList<>();
        if (len == 0)
            return answer;
        // ArrayList<Integer> helper = new ArrayList<>();
        split(answer, 0, len, num, 0, 0, 0);
        return answer;
    }

    private static boolean split(ArrayList<Integer> helper, int index, int len, String num, int prev1, int prev2,
            int c) {

        if (index == len) {
            if (helper.size() <= 2)
                return false;
            return true;
        }
        for (int i = index; i < len; i++) {

            String n = num.substring(index, i + 1);
            long b = Long.parseLong(n);
            if (Integer.MAX_VALUE <= b)
                return false;
            int number = Integer.parseInt(n);
            if (n.charAt(0) == '0' && n.length() > 1)
                return false;
            else if (helper.size() < 2) {
                helper.add(number);
                // System.out.println(helper +" "+c+" "+n);
                if (split(helper, i + 1, len, num, prev2, number, c + 1))
                    return true;
                helper.remove(helper.size() - 1);
            } else if (prev1 + prev2 < number)
                return false;
            else if (helper.size() >= 2 && prev1 + prev2 == number) {
                helper.add(number);
                // System.out.println(helper+" "+c);
                if (split(helper, i + 1, len, num, prev2, number, c + 1))
                    return true;
                helper.remove(helper.size() - 1);
            }
        }
        return false;
    }
}