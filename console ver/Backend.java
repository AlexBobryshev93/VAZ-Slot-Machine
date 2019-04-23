class Backend {
	private int credits = 20;
	private int price = 4;
	private int win = 0;
	private int Slots[] = new int[3];
	
	Backend() {
		System.out.println("Game start. Credits: " + credits);
		System.out.println();
	}
	
	void play() {
		credits -= price;
		Slots[0] = (int) (Math.random() * 6); // from 0 to 5;
		Slots[1] = (int) (Math.random() * 6);
		Slots[2] = (int) (Math.random() * 6);
		
		System.out.println("[" + Slots[0] + "] " + "[" + Slots[1] + "] " + "[" + Slots[2] + "]");
		checkwin();
	}
	
	void checkwin() {
		if ((Slots[0] == Slots [1]) && (Slots[1] == Slots[2])) {
			win = (1 + Slots[0]) * 5;
			System.out.println("Jackpot! You win " + win + " credits!!!");
		} 
		else if (Slots[0] == Slots[1]) {
			win = (1 + Slots[0]) * 2;
			System.out.println("You win " + win + " credits!");
		}
		else if (Slots[0] == Slots[2]) {
			win = (1 + Slots[0]) * 2;
			System.out.println("You win " + win + " credits!");
		}
		else if (Slots[2] == Slots[1]) {
			win = (1 + Slots[2]) * 2;
			System.out.println("You win " + win + " credits!");
		}
		
		credits += win;
		win = 0;
		System.out.println("Credits: " + credits);
		System.out.println();
	}
	
	boolean check() {
		if (credits < price) return false;
		return true;
	}
	
	void gameover() {
		System.out.println("Game Over");
	}
}