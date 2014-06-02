/**
	Contains the data of board.

	@author Wenlong Zhang
	@version for Assignment 4, CS 151, Spring 2013, SJSU
*/

public class Model
{
	//a ButtonView object
	private ButtonView view;
	
	//numbers on 9x9 grid
	Integer[][] board = new Integer[9][9];

	/**
	    Constructs a Model object
	    @param bt the view of 9x9 grid
	 */
	public Model(ButtonView bt)
	{
		//initial the board
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
			{
				board[i][j] = 0;
				
				if((i==1&&j==3) || (i==4&&j==8) || (i==7&&j==4))
					board[i][j] = 1;
				
				if((i==5&&j==4) || (i==6&&j==6))
					board[i][j] = 2;
				
				if((i==0&&j==1) || (i==3&&j==8) || (i==4&&j==5))
					board[i][j] = 3;
				
				if((i==4&&j==0) || (i==7&&j==3))
					board[i][j] = 4;
				
				if((i==0&&j==0) || (i==1&&j==5) || (i==7&&j==8))
					board[i][j] = 5;
				
				if((i==1&&j==0) || (i==2&&j==7) || (i==3&&j==4) || (i==5&&j==8) || (i==6&&j==1))
					board[i][j] = 6;
				
				if((i==0&&j==4) || (i==5&&j==0) || (i==8&&j==7))
					board[i][j] = 7;
				
				if((i==2&&j==2) || (i==3&&j==0) || (i==4&&j==3) || (i==6&&j==7) || (i==8&&j==4))
					board[i][j] = 8;
				
				if((i==1&&j==4) || (i==2&&j==1) || (i==7&&j==5) || (i==8&&j==8))
					board[i][j] = 9;
			}
		
		this.view = bt;
		try
		{
			this.view.boardChange(board);
			Thread.sleep( 1000 );
		}
		catch( Exception e ){ }
	}
	
	/**
	    Solves current cell
	    @param row the number of row
	    @param col the number of column
	 */
	public void solve(int row, int col)
	{
		if(row > 8 && col > 8)
			return;
		
		if(board[row][col] != 0)
			solveNextCell(row, col);
		else
		{
			for(int i = 1; i <= 9; i++)
				if(checkValid(row, col, i))
				{
					board[row][col] = i;
					try
					{
						this.view.boardChange(board);
						Thread.sleep( 1000 );
					}
					catch( Exception e ){ }
					solveNextCell(row, col);
				}
			board[row][col] = 0;
		}		
	}

	/**
	    Solves next cell
	    @param row current row
	    @param col current column
	 */
	private void solveNextCell(int row, int col)
	{
		//check whether col is the end of line
		if(col == 8)
			solve(row + 1, 0);
		else
			solve(row, col + 1);
	}

	/**
	    Checks whether a number can put into current cell
	    @param row current row
	    @param col current column
	    @param num the number is going to be checked
	    @return true the number is valid
	    		false the number is not valid
	 */
	private boolean checkValid(int row, int col, int num)
	{
		//check 3x3 region
		int r = row / 3, c = col / 3;
		for(int i = r * 3; i < (r + 1) * 3; i++)
			for(int j = c * 3; j < (c + 1) * 3; j++)
				if(i != row && j != col && board[i][j] == num)
					return false;
		
		//check horizontal and vertical region
		for(int i = 0; i < 9; i++)
			if((i != col && board[row][i] == num) || (i != row && board[i][col] == num))
				return false;

		return true;
	}
}
