class Backend {
	private int credits = 20;
	final private int price = 4;
	private int win = 0;
	private int turns = 0;
	private int Slots[] = new int[3];
	private String result;
	
	void play() {
		credits -= price;
		turns++;
		Slots[0] = (int) (Math.random() * 6); // from 0 to 5;
		Slots[1] = (int) (Math.random() * 6);
		Slots[2] = (int) (Math.random() * 6);
	}
	
	void checkWin() {
		if ((Slots[0] == Slots [1]) && (Slots[1] == Slots[2])) {
			win = (1 + Slots[0]) * 5;
			result = "Jackpot! You win " + win + " credits!!!";
		} 
		else if (Slots[0] == Slots[1]) {
			win = (1 + Slots[0]) * 2;
			result = "You win " + win + " credits!";
		}
		else if (Slots[0] == Slots[2]) {
			win = (1 + Slots[0]) * 2;
			result = "You win " + win + " credits!";
		}
		else if (Slots[2] == Slots[1]) {
			win = (1 + Slots[2]) * 2;
			result = "You win " + win + " credits!";
		}
		else result = "Try again.";
		
		credits += win;
		win = 0;
	}
	
	boolean check() {
		if (credits < price) return false;
		return true;
	}
	
	void gameOver() {
		result = "Game Over";
	}
	
	int getCredits() {return credits;}
	int getTurns() {return turns;}
	int getSlot(int i) {return Slots[i];}
	String getResult() {return result;}
}