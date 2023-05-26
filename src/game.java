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
 * Start this program at mainMenu.java instead of this
 * 
 */

/**
 * Class name: game
 * 
 * Description: The brains behind the tic tac toe game. This is where the logic and the main
 * code resides. Things like games graphics, win logic, check logic, etc
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;

public class game extends JPanel {
	private static JFrame frame = new JFrame("Tic Tac Toe");
	private JButton buttons[] = new JButton[9];
	public JLabel turn, player1WinsLabel, player2WinsLabel, tieLabel, gamesLabel;
	public int turns = 0, menu = 0, player1Win = 0, player2Win = 0, ties = 0, games = 0;
	public String win = "";
	private JTextArea pressRToRestart;

	public game() {
		// this is where the game begins (from being called in main menu)

		JPanel winPanel = new JPanel();
		Font f = new Font(Font.SERIF, Font.BOLD, 14);
		frame.getContentPane().setLayout(new GridLayout(4, 3, 5, 5));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(525, 500);
		frame.setVisible(true);

		JLabel stats = new JLabel("Stats", JLabel.CENTER);
		turn = new JLabel("X's turn", JLabel.CENTER);
		turn.setForeground(Color.RED);
		player1WinsLabel = new JLabel("X wins = 0", JLabel.CENTER);
		player1WinsLabel.setForeground(Color.RED);
		player2WinsLabel = new JLabel("O wins = 0", JLabel.CENTER);
		player2WinsLabel.setForeground(Color.BLUE);
		tieLabel = new JLabel("Number of Ties = 0", JLabel.CENTER);
		gamesLabel = new JLabel("Number of games = 0", JLabel.CENTER);

		stats.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		turn.setFont(new Font("Serif", Font.BOLD, 30));
		player1WinsLabel.setFont(f);
		player2WinsLabel.setFont(f);
		tieLabel.setFont(f);
		gamesLabel.setFont(f);

		winPanel.add(stats);
		winPanel.add(player1WinsLabel);
		winPanel.add(player2WinsLabel);
		winPanel.add(tieLabel);
		winPanel.add(gamesLabel);
		winPanel.setLayout(new GridLayout(5, 1));

		pressRToRestart = new JTextArea();
		pressRToRestart.setForeground(Color.BLACK);
		pressRToRestart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char ch = e.getKeyChar();
				if (ch == 'r') {
					restart();
				} else if (ch == 'q')
					System.exit(0);
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		pressRToRestart.setBackground(SystemColor.menu);
		pressRToRestart.setDisabledTextColor(Color.BLACK);
		pressRToRestart.setTabSize(15);
		pressRToRestart.setText("\r\nPress R to Restart\r\n\r\nPress Q to Quit");
		pressRToRestart.setRows(2);
		pressRToRestart.setFont(new Font("Serif", Font.BOLD, 15));
		pressRToRestart.setEditable(false);
		frame.getContentPane().add(pressRToRestart);
		frame.getContentPane().add(turn);
		frame.getContentPane().add(winPanel);
		start();
	}

	public void start() {
		// Creates and instantized the Buttons
		Font f = new Font(Font.SERIF, Font.BOLD, 52);
		for (int i = 0; i <= 8; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("");
			buttons[i].setBorder(BorderFactory.createLineBorder(Color.black, 3));
			buttons[i].setBackground(Color.lightGray);
			buttons[i].setFont(f);
			buttons[i].setActionCommand(Integer.toString(i));
			buttons[i].addActionListener(new buttonListener());
			frame.getContentPane().add(buttons[i]);

		}
	}

	public void restart() {
		// resets the buttons back to default
		for (int i = 0; i <= 8; i++) {
			buttons[i].setText("");
			buttons[i].setBorder(BorderFactory.createLineBorder(Color.black, 3));
			turns = 0;
			
		}
		
		if (("O's turn").equals("O's turn")) {
			turn.setForeground(Color.RED);
			turn.setFont(new Font("Serif", Font.BOLD, 30));
			turn.setText("X's turn");
		}

	}

	public class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// Checks for click on UI button and makes appropriate judgment on what to do
			int input = 0;
			JButton begin = (JButton) e.getSource();

			begin.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					char ch = e.getKeyChar();
					if (ch == 'r') {
						restart();
					} else if (ch == 'q')
						System.exit(0);
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}

				@Override
				public void keyTyped(KeyEvent e) {
				}
			});
			if (buttons[Integer.parseInt(e.getActionCommand())].getText().equals("X")
					|| buttons[Integer.parseInt(e.getActionCommand())].getText().equals("O")) {
				JOptionPane.showConfirmDialog(null, "You cannot place on this tile!", "Oops!",
						JOptionPane.DEFAULT_OPTION);
			} else {
				if (turns % 2 == 0 || turns == 0) {
					begin.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					begin.setForeground(Color.red);
					begin.setText("X");
					turn.setForeground(Color.BLUE);
					turn.setFont(new Font("Serif", Font.BOLD, 30));
					turn.setText("O's turn");

				} else {
					begin.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
					begin.setForeground(Color.blue);
					begin.setText("O");
					turn.setForeground(Color.RED);
					turn.setFont(new Font("Serif", Font.BOLD, 30));
					turn.setText("X's turn");

				}
				if (win() == true) {
					if (win.equals("X")) {
						input = JOptionPane.showConfirmDialog(null, "X wins!\n\nDo you want to play again?", "Winner!",
								JOptionPane.YES_NO_OPTION);
						turn.setForeground(Color.RED);
						turn.setFont(new Font("Serif", Font.BOLD, 30));
						turn.setText("X's turn");
						player1Win++;
						player1WinsLabel.setText("X wins = " + player1Win);
					} else if (win.equals("O")) {
						input = JOptionPane.showConfirmDialog(null, "O wins!\n\nDo you want to play again?", "Winner!",
								JOptionPane.YES_NO_OPTION);
						player2Win++;
						player2WinsLabel.setText("O wins = " + player2Win);
					} else {
						input = JOptionPane.showConfirmDialog(null, "Cat's game (Tie)\n\nDo you want to play again?",
								"Cat's game (Tie)", JOptionPane.YES_NO_OPTION);
						turn.setForeground(Color.RED);
						turn.setFont(new Font("Serif", Font.BOLD, 30));
						turn.setText("X's turn");
						ties++;
						tieLabel.setText("Number of Ties = " + ties);
					}
					switch (input) {
					case 0:
						games++;
						gamesLabel.setText("Number of games = " + games);
						restart();
						turns = -1;
						break;
					case 1:
						System.exit(0);
					}
				
				}
				turns++;
			}
		
		}
		
	}

	public boolean win() {
		boolean result = false;
		// Check the player wins
		for (int i = 0; i < buttons.length - 1; i++) {
			if (i == 0 || i == 3 || i == 6) {
				if (check(i, i + 1) && check(i + 1, Math.min(i + 2, 8))) {
					win = buttons[i].getText();
					result = true;
				}
			}
			if (i == 0 || i == 1 || i == 2) {
				if (check(i, i + 3) && check(i + 3, i + 6)) {
					win = buttons[i].getText();
					return true;
				} else if (i == 0 && (check(i, i + 4) && check(i + 4, i + 8))) {
					win = buttons[i].getText();
					return true;
				} else if (i == 2 && (check(2, 4) && check(4, 6))) {
					win = buttons[i].getText();
					return true;
				}
			} else if (checkEmpty()) {
				return true;
			}
			
		}
		return result;
		
	}

	public boolean check(int x, int y) {
		// checking logic
		if (buttons[x].getText().equals(buttons[y].getText()) && !buttons[x].getText().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkEmpty() {
		boolean check = true;
		// Checks for ties
		for (int i = 0; i < 9; i++) {
			if (buttons[i].getText().equals("")) {
				check = false;
				return check;
			}
		}
		if (check == true) {
			win = "T";
		}
		return check;
	}

}