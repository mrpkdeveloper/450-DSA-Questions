import java.util.ArrayList;
import java.util.List;

public class isValidIP {
    public List<String> restoreIpAddresses(String s) {

        int len = s.length();
        List<String> answer = new ArrayList<>();
        ArrayList<String> helper = new ArrayList<>();
        validity(s, 0, helper, answer, len, 4);
        return answer;
    }

    private static void validity(String ip, int index, ArrayList<String> helper, List<String> answer, int len,
            int partition) {

        if (partition < 0)
            return;
        if (index == len) {
            if (partition == 0) {
                StringBuffer ans = new StringBuffer();
                for (int i = 0; i < 4; i++) {
                    if (i == 0)
                        ans.append(helper.get(i) + ".");
                    else if (i == 3)
                        ans.append(helper.get(i));
                    else {
                        ans.append(helper.get(i));
                        ans.append(".");
                    }
                }
                answer.add(ans.toString());
            }
            return;
        }

        for (int i = index; i < len; i++) {
            String sub = ip.substring(index, i + 1);
            if (Integer.parseInt(sub) > 255 || Integer.parseInt(sub) < 0)
                return;
            if (isPossibleIP(sub)) {
                helper.add(sub);
                validity(ip, i + 1, helper, answer, len, partition - 1);
                helper.remove(helper.size() - 1);
            }
        }
    }

    private static boolean isPossibleIP(String ip) {
        int len = ip.length();
        if (len > 1 && ip.charAt(0) == '0')
            return false;
        return true;

    }
}