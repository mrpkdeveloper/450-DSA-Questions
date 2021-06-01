package backtracking;

import java.util.List;

public class wordbreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void print(List<String> dict, String s, String ans, List<String> fans) {
		if (s.length() == 0) {
			fans.add(ans);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i + 1);
			if (dict.contains(prefix)) {
				String res = s.substring(i + 1);
				if (res.length() == 0) {
					print(dict, res, ans + prefix, fans);
				} else {
					print(dict, res, ans + prefix + " ", fans);
				}
			}
		}
	}

}
