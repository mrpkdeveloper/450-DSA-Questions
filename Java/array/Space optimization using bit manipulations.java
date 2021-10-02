// Java program to mark numbers as
// multiple of 2 or 5
import java.lang.*;

class MM {
	
	// Driver code
	public static void main(String[] args)
	{
		int a = 2, b = 10;
		int size = Math.abs(b - a) + 1;
		int array[] = new int[size];
	
		// Iterate through a to b, If
		// it is a multiple of 2 or 5
		// Mark index in array as 1
		for (int i = a; i <= b; i++)
			if (i % 2 == 0 || i % 5 == 0)
				array[i - a] = 1;
	
		System.out.println("MULTIPLES of 2"
							+ " and 5:");
		for (int i = a; i <= b; i++)
			if (array[i - a] == 1)
				System.out.printf(i + " ");
	}
}

// This code is contributed by
// Mohd Mehraj
