package strings;

public class immutability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("prateek");
		System.out.println(str);
		str.concat("bansal");
		System.out.println(str); // output is still prateek //this shows string immutability

	}

}
