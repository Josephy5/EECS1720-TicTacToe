/**
 * Team Members: Joseph Yong, and Pavel Kakoshka
 * 
 * Game Name: Tic Tac Toe
 * 
 * For Description of the game, go to the README.txt for more info
 * 
 * Update Date: 19 March 2020
 * 
 * Version: 0.80
 * 
 */

/**
 * Class name: mainMenu
 * 
 * Description: Creates the main menu of the game, which prompts the user to start 
 * or quit the game.
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class mainMenu implements ActionListener, KeyListener {
	private JFrame menu = new JFrame();

	public mainMenu() {
		menu.getContentPane().setLayout(new BorderLayout(0, 20));

		JPanel panel = new JPanel();
		JLabel title = new JLabel("TicTacToe", JLabel.CENTER);
		Font f = new Font(Font.SERIF, Font.BOLD, 28);
		title.setFont(f);

		ImageIcon grap = new ImageIcon("pic.png");
		Image image = grap.getImage();
		Image change = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		grap = new ImageIcon(change);
		JLabel img = new JLabel(grap);

		JButton begin = new JButton("Click here or Press S to start");
		begin.setFocusable(false);
		begin.setBorder(null);
		begin.setPreferredSize(new Dimension(171, 75));
		f = new Font(Font.SERIF, Font.BOLD, 18);
		begin.setFont(new Font("Serif", Font.BOLD, 30));
		begin.addActionListener(this);
		begin.addKeyListener(this);

		JButton quit = new JButton("Click here or Press Q to quit");
		quit.setBorder(null);
		f = new Font(Font.SERIF, Font.BOLD, 18);
		quit.setFont(f);
		quit.addActionListener(this);
		quit.addKeyListener(this);
		quit.setActionCommand("quit");

		JButton restart = new JButton("Restart");
		f = new Font(Font.SERIF, Font.BOLD, 18);
		restart.setFont(f);
		restart.addActionListener(this);
		restart.addKeyListener(this);
		restart.setActionCommand("restart");

		menu.getContentPane().add(title, BorderLayout.NORTH);
		menu.getContentPane().add(img, BorderLayout.CENTER);
		menu.getContentPane().add(begin, BorderLayout.SOUTH);
		menu.getContentPane().add(quit, BorderLayout.NORTH);
		menu.setVisible(true);
		menu.setSize(525, 500);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		mainMenu hold = new mainMenu();
	}

	// Tracks the click on the UI button
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("quit".equals(e.getActionCommand())) {
			System.exit(0);
		} else {
			menu.setVisible(false);
			game tic = new game();
		}
	}

	// Tracks the keypress (the S and Q button on the keyboard)
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char ch = arg0.getKeyChar();
		if (ch == 's') {
			menu.setVisible(false);
			game tic = new game();
		} else if (ch == 'q')
			System.exit(0);
	}

	// Not important, only there for the implement to run
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
