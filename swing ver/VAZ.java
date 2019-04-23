import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class VAZ implements ActionListener {
	Backend Game = new Backend();
	JLabel cred, trn, res, lab1, lab2, lab3;
	JButton btn;
	ImageIcon LADA;
	ImageIcon[] images = new ImageIcon[6];
	
	VAZ() {
		JFrame jfrm = new JFrame("VAZ Slot Machine");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(480, 360);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LADA = new ImageIcon("images\\LADA.png");
		images[0] = new ImageIcon("images\\01.png");
		images[1] = new ImageIcon("images\\02.png");
		images[2] = new ImageIcon("images\\03.png");
		images[3] = new ImageIcon("images\\04.png");
		images[4] = new ImageIcon("images\\05.png");
		images[5] = new ImageIcon("images\\06.png");
		
		cred = new JLabel("Credits: " + Game.getCredits());
		cred.setPreferredSize(new Dimension(400,10));
		trn = new JLabel("Turns: " + Game.getTurns());
		trn.setPreferredSize(new Dimension(400,75));
		res = new JLabel("Press PLAY to start", SwingConstants.CENTER);
		res.setPreferredSize(new Dimension(400,100));
		lab1 = new JLabel(LADA);
		lab2 = new JLabel(LADA);
		lab3 = new JLabel(LADA);
		
		btn = new JButton("PLAY");
		btn.setPreferredSize(new Dimension(100,50));
		btn.addActionListener(this);
		
		jfrm.add(cred);
		jfrm.add(trn);
		jfrm.add(lab1);
		jfrm.add(lab2);
		jfrm.add(lab3);
		jfrm.add(btn);
		jfrm.add(res);
		jfrm.setResizable(false);
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Game.play();
		//animate();
		try {
			Thread.sleep(200);
		} catch (InterruptedException exc) {
			return;
		}
		
		lab1.setIcon(images[Game.getSlot(0)]);
		lab2.setIcon(images[Game.getSlot(1)]);
		lab3.setIcon(images[Game.getSlot(2)]);
		
		Game.checkwin();
		trn.setText("Turns: " + Game.getTurns());
		cred.setText("Credits: " + Game.getCredits());
		if (!Game.check()) {
			btn.removeActionListener(this);
			Game.gameover();
		}
		res.setText(Game.getResult());
	}
/*
	public void animate() {
		for (int i = 0; i < images.length; i++) {
			lab1.setIcon(images[i]);
			lab2.setIcon(images[i]);
			lab3.setIcon(images[i]);
			try {
				Thread.sleep(50);
			} catch (InterruptedException exc) {
				break;
			}
			
			lab1.setIcon(LADA);
			lab2.setIcon(LADA);
			lab3.setIcon(LADA);
			try {
				Thread.sleep(50);
			} catch (InterruptedException exc) {
				break;
			}
		}
	}
*/	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VAZ();
			}
		});
	}
}