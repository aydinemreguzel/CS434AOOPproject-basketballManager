package gameengine;

import controllers.MainController;

public class BM2014 {

	public static void main(String[] args) {
		new BM2014();
	}

	private BM2014() {
		startApp();
	}

	@SuppressWarnings("resource")
	void startApp() {	  
		Game game = new Game(new Time(1, 1, 2014));
		MainController mainController = new MainController(game);
		mainController.start();
	}
}
