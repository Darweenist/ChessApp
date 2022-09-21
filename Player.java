import java.awt.*;
import java.util.*;
/**
 * Represents a generic chess player
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public abstract class Player
{
    private String name;
    private Board board;
    private Color color;
    /**
     * Constructor for Player
     * @param b the board the game will be played on
     * @param n the name of the player
     * @param col the color of the player's pieces
     */
    public Player(Board b, String n, Color col)
    {
        board = b;
        name = n;
        color = col;
    }

    /**
     * @return the board the game is played on
     */
    public Board getBoard()
    {
        return board;
    }

    /**
     * @return the name of the player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the color of the player's pieces/side
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * @return the next move of the player, to be determined
     * by what type of player this is
     */
    public abstract Move nextMove();
    
}
