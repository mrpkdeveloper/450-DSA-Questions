package Recusrion;

public class countAndSay {
    public String __countAndSay__(int n) {
        return countAndMerge(n);
    }

    private static String countAndMerge(int n) {
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        else if (n == 3)
            return "21";
        else if (n == 4)
            return "1211";
        else {
            StringBuilder answer = new StringBuilder();
            String xyz = (countAndMerge(n - 1));
            int[] helper = new int[10];
            int prev = xyz.charAt(0) - '0';
            for (int i = 0; i < xyz.length(); i++) {
                int current = xyz.charAt(i) - '0';
                helper[xyz.charAt(i) - '0']++;
                if (prev != current) {
                    answer.append(helper[prev]);
                    answer.append(prev);
                    helper[prev] = 0;
                    prev = current;
                }
                if (i == xyz.length() - 1) {
                    answer.append(helper[xyz.charAt(i) - '0']);
                    answer.append(xyz.charAt(i));
                }
            }

            return answer.toString();

        }
    }
}
