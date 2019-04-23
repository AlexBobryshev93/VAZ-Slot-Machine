import java.io.*;

class TD {
	public static void main(String[] args) throws IOException {
		char ch;
		Backend Game = new Backend();
		
		do {
			System.out.println("Press ENTER to try ");
			do {
				ch = (char) System.in.read();
			} while (ch != '\n');
			Game.play();
		} while (Game.check());
		
		Game.gameover();
	}
}