/**
 * Team Members: Joseph Yong, and Pavel Kakoshka
 * 
 * Game Name: Tic Tac Toe
 * 
 * For Description of the game, go to the README.txt for more info
 * 
 * Update Date: 3 April 2020
 * 
 * Version: 1.00
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
		JPanel button = new JPanel();
		menu.setLayout(new BorderLayout(0, 20));

		JLabel title = new JLabel("TicTacToe", JLabel.CENTER);
		Font f = new Font(Font.SERIF, Font.BOLD, 28);
		title.setFont(f);

		ImageIcon grap = new ImageIcon("pic.png");
		Image image = grap.getImage();
		Image change = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		grap = new ImageIcon(change);
		JLabel img = new JLabel(grap);
		JLabel text = new JLabel("Press S to start or Press Q to quit");
		text.setFont(new Font(Font.SERIF, Font.BOLD, 18));
		JPanel hold = new JPanel();
		hold.add(img);
		hold.add(text);

		JButton begin = new JButton("Start");
		JButton quit = new JButton("Quit");
		f = new Font(Font.SERIF, Font.BOLD, 18);
		begin.setFont(f);
		begin.setPreferredSize(new Dimension(140, 40));
		begin.addActionListener(this);
		begin.addKeyListener(this);
		quit.setFont(f);
		quit.setPreferredSize(new Dimension(140, 40));
		quit.addActionListener(this);
		quit.addKeyListener(this);
		quit.setActionCommand("quit");
		begin.setActionCommand("begin");

		begin.setBackground(Color.red);
		begin.setForeground(Color.white);
		quit.setBackground(Color.red);
		quit.setForeground(Color.white);

		begin.setBorder(null);
		quit.setBorder(null);

		button.add(begin);
		button.add(quit);

		menu.add(title, BorderLayout.NORTH);
		menu.add(hold, BorderLayout.CENTER);
		menu.add(button, BorderLayout.SOUTH);
		menu.setVisible(true);
		menu.setSize(500, 500);
		menu.setTitle("Main Menu");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		mainMenu hold = new mainMenu();
	}

	// Tracks the click on the UI button
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if (input.equals("begin")) {
			menu.setVisible(false);
			game tic = new game();
		} else if (input.equals("quit")) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch = e.getKeyChar();
		if (ch == 's') {
			menu.setVisible(false);
			game tic = new game();
		} else if (ch == 'q') {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}