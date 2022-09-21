import java.util.*;
import java.awt.*;
/**
 * Represents a smarter player that looks a move ahead
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public class SmartPlayer extends Player
{
    /**
     * Instantiates player's instance variables
     * @param b is the board the player is playing on
     * @param n is the name of the player
     * @param col is the color of the player
     */
    public SmartPlayer(Board b, String n, Color col)
    {
        super(b, n, col);
    }

    /**
     * Calculates the score of the current situation by adding the values of
     * this player's pieces and subtracting the opponent's pieces' values
     * @return score
     */
    public int score()
    {
        int count = 0;
        for (Location loc : getBoard().getOccupiedLocations())
        {
            if (getBoard().get(loc).getColor().equals(getColor()))
            {
                count += getBoard().get(loc).getValue();
            }
            else 
            {
                count -= getBoard().get(loc).getValue();
            }
        }
        return count;
    }
    
    /**
     * Returns the most optimal move by trying a move and 
     * calculating the points 
     * gained from that move. 
     * @return the most optimal move
     */
    public Move nextMove()
    {
        Move bigMove = getBoard().allMoves(getColor())
            .get((int)(Math.random() * getBoard()
            .allMoves(getColor()).size()));
        int highScore = Integer.MIN_VALUE;
        for (Move move : getBoard().allMoves(getColor()))
        {
            getBoard().executeMove(move);
            if (score() > highScore)
            {
                highScore = score();
                bigMove = move;
            }
            getBoard().undoMove(move);
        }
        return bigMove;
    }
}
