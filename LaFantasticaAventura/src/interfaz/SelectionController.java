package interfaz;

import model.StartGame;

public class SelectionController {

		private Main main;
		private StartGame start;
		
		public void link(Main main,StartGame start) {
			this.main= main;
			this.start=start;
		}
}
