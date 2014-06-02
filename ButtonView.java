/**
	Draws a sudoku board.

	@author Wenlong Zhang
	@version for Assignment 4, CS 151, Spring 2013, SJSU
*/

import java.awt.*;
import javax.swing.*;

public class ButtonView extends Frame
{
	//represents 9x9 grid
	private JButton[][] board = new JButton[9][9];
	
	/**
	    Constructs a ButtonView object
	 */
	public ButtonView()
	{
		JPanel panel = new JPanel ();
		panel.setLayout(new GridLayout(9, 9));
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
			{
				board[i][j] = new JButton();
				panel.add(board[i][j]);
			}
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	    Updates the board and repaints it
	    @param data the data to board
	 */
	public void boardChange(Integer[][] data)
	{
		//sets up the display content of each button
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				board[i][j].setText(data[i][j].toString());
		
		this.repaint();
	}
}
