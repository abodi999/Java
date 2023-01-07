package lab4Package;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameView {

	GameController controller;
	JButton buttons[][];
	JLabel myLabel;
	char[] letters = {' ', 'O' , 'X', 'W', 'Z'};

	public GameView(GameController controller, int rows, int columns) {
		
		this.controller = controller;
		buttons = new JButton[rows][columns];
		
		JFrame frame = new JFrame("X & O");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel ButtonPanel = new JPanel();

		ButtonPanel.setLayout(new GridLayout(rows,columns));

		for(int row = 0; row < rows; row ++) {
			for(int column = 0; column < columns; column++) {
				final int _row = row ;
				final int _column = column;
				JButton button = buttons[_row][_column] = new JButton();
				button.setPreferredSize(new Dimension(100, 100));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						controller.checkIfTheGameEnded(_row, _column);
					}
				});
				ButtonPanel.add(button);
			}
		}
		JPanel myTextPanel = new JPanel();
		myTextPanel.setLayout(new GridLayout(rows,columns));
		myTextPanel.setPreferredSize(new Dimension(150,50));
		myLabel = new JLabel("Player 1's Turn", SwingConstants.CENTER);
		myTextPanel.add(myLabel);

		JPanel myMainPanel = new JPanel();
		myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
		myMainPanel.add(ButtonPanel);
		myMainPanel.add(myTextPanel);

		frame.getContentPane().add(myMainPanel);
		frame.pack();
		frame.setVisible(true);
		
		
	}
    void setTextOfLabel(String text) {
        myLabel.setText(text);
    }
	void setTextOfButton(int row, int column, int player) {
		String text = Character.toString(letters[player]);
        this.buttons[row][column].setText(text);
    }
}
