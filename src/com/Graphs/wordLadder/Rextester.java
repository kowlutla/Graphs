package com.Graphs.wordLadder;

import java.util.Scanner;

public class Rextester {
// Driver code
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int z1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();int z2 = sc.nextInt();
		int x3 = sc.nextInt();int y3 = sc.nextInt();int z3 = sc.nextInt();int x4 = sc.nextInt();int y4 = sc.nextInt();int z4 = sc.nextInt();

		// function calling
		equation_plane(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	static void equation_plane(int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3, int x, int y,
			int z) {
		int a1 = x2 - x1;
		int b1 = y2 - y1;
		int c1 = z2 - z1;
		int a2 = x3 - x1;
		int b2 = y3 - y1;
		int c2 = z3 - z1;
		int a = b1 * c2 - b2 * c1;
		int b = a2 * c1 - a1 * c2;
		int c = a1 * b2 - b1 * a2;
		int d = (-a * x1 - b * y1 - c * z1);

		if (a * x + b * y + c * z + d == 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

// This code is contributed by PrinciRaj1992
