import java.util.*;
import java.awt.*;
/**
 * Human Player represents a player who is human...
 * meaning they can make their own
 * decisions and moves.
 *
 * @author Dawson Chen
 * @version 5/1/19
 */
public class HumanPlayer extends Player
{
    // instance variables - replace the example below with your own
    private BoardDisplay display;

    /**
     * Constructor for objects of class Player
     * @param col the color of the player
     * @param n the name of the player
     * @param b the board the game is played on
     * @param dspl is the display that shows the game of chess
     */
    public HumanPlayer(Board b, String n, Color col, BoardDisplay dspl)
    {
        super(b, n, col);
        display = dspl;
    }

    /**
     * Asks for the next move that the HumanPlayer wants to make
     * @return the next move
     */
    public Move nextMove()
    {
        Move selected = display.selectMove();
        while (!getBoard().allMoves(getColor()).contains(selected))
        {
            selected = display.selectMove();
        }
        return selected;
    }
}
