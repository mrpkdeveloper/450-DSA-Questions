package Backtracking_And_Memoraization;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutations {
    public List<String> letterCasePermutation(String s) {

        int len = s.length();
        List<String> answer = new ArrayList<>();
        if (len == 0)
            return answer;
        StringBuffer helper = new StringBuffer();
        createPermutations(0, len, answer, s, helper);
        return answer;
    }

    private static void createPermutations(int index, int len, List<String> answer, String s, StringBuffer helper) {

        if (index == len) {
            answer.add(helper.toString());
            return;
        }

        if ('0' <= s.charAt(index) && s.charAt(index) <= '9') {
            helper.append(s.charAt(index));
            createPermutations(index + 1, len, answer, s, helper);
            helper.deleteCharAt(helper.length() - 1);
            return;
        }

        if ('A' <= s.charAt(index) && s.charAt(index) <= 'Z') {
            helper.append(s.charAt(index));
            createPermutations(index + 1, len, answer, s, helper);
            helper.deleteCharAt(helper.length() - 1);
            helper.append((char) (s.charAt(index) + 32));
            createPermutations(index + 1, len, answer, s, helper);
            helper.deleteCharAt(helper.length() - 1);
        } else if ('a' <= s.charAt(index) && s.charAt(index) <= 'z') {
            helper.append(s.charAt(index));
            createPermutations(index + 1, len, answer, s, helper);
            helper.deleteCharAt(helper.length() - 1);
            helper.append((char) (s.charAt(index) - 32));
            createPermutations(index + 1, len, answer, s, helper);
            helper.deleteCharAt(helper.length() - 1);
        }
        return;
    }
}