/**
	Solves sudoku.

	@author Wenlong Zhang
	@version for Assignment 4, CS 151, Spring 2013, SJSU
*/

public class SudokuSolver
{
	/**
	    Creates model, view, and controller and lets them
	    	communicate each other
	    @param args unused
	 */
	public static void main(String[] args)
	{	
		ButtonView view = new ButtonView();
		Model model = new Model(view);
		Runnable r = new Controller(model);
		Thread t = new Thread(r);
		t.start();
	}
}
