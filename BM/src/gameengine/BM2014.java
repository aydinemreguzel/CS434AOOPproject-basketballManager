package gameengine;

import java.util.Scanner;

public class BM2014 {

	public static void main(String[] args) {
		new BM2014();
	}

	private BM2014() {
		startApp();
	}

	void startApp() {
		Game game = new Game(new Time(1, 1, 2014));
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("enter something: ");
			String str = sc.nextLine();
			if (str.equals("exit"))
				break;
			game.advanceInTime();
		}
	}
}
