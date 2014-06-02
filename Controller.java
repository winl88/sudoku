/**
	Controls model.

	@author Wenlong Zhang
	@version for Assignment 4, CS 151, Spring 2013, SJSU
*/

public class Controller implements Runnable
{
	private Model model ;
	
	/**
	    Constructs a Controller object
	    @param m the model
	 */
	public Controller (Model m)
	{
		model = m;
	}
	
	/**
	    Runs the program to solve problem
	 */
	public void run()
	{
		try
		{
			Thread.sleep( 1000 ); // delay to see the initial position
			model.solve(0,0); // to solve the puzzle in the top left corner
		}
		catch( Exception e ){ }
	}
}