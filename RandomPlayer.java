import java.util.*;
import java.awt.*;
/**
 * Represents a player that makes random moves.
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public class RandomPlayer extends Player
{
    /**
     * Constructor for objects of class RandomPlayer
     * @param b the board the game is played on
     * @param n the name of the player
     * @param col the color the player is representing
     */
    public RandomPlayer(Board b, String n, Color col)
    {
        super(b, n, col);
    }

    /**
     * Finds the next move
     * @return the next random move
     */
    public Move nextMove()
    {
        int rand = (int)(Math.random() * getBoard()
            .allMoves(getColor()).size());
        return getBoard().allMoves(getColor()).get(rand);
    }
}
