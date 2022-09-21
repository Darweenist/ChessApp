import java.util.*;
import java.awt.*;
/**
 * Represents a smarter player that looks 2 moves ahead
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public class SmarterPlayer extends SmartPlayer
{
    /**
     * Instantiates player's instance variables
     * @param b is the board the player is playing on
     * @param n is the name of the player
     * @param col is the color of the player
     */
    public SmarterPlayer(Board b, String n, Color col)
    {
        super(b, n, col);
    }

    /**
     * Returns the most optimal move by calculating which move will lead to 
     * the opponent, assuming a smart player, to make a move that results in 
     * a gain of most points.
     * @return the most optimal move
     */
    public Move nextMove()
    {
        Move bigMove = getBoard().allMoves(getColor())
            .get((int)(Math.random() * getBoard().allMoves(getColor()).size()));

        int highScore = score();
        Color other = new Color(0, 0, 0);

        if (getColor().equals(Color.WHITE))
            other = Color.BLACK;
        else
            other = Color.WHITE;
        SmartPlayer opponent = new SmartPlayer(getBoard(), "opp", other);
        for (Move move : getBoard().allMoves(getColor()))
        {
            getBoard().executeMove(move);
            Move move2 = opponent.nextMove();
            getBoard().executeMove(move2);
            if (score() > highScore)
            {
                highScore = score();
                bigMove = move;
            }
            getBoard().undoMove(move2);
            getBoard().undoMove(move);
        }
        return bigMove;
    }
}
