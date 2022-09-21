import java.util.*;
import java.awt.*;
/**
 * Represents a queen in a traditional chess game.
 *
 * @author Dawson
 * @version 4/27/19
 */
public class Queen extends Piece
{
    //the board this piece is on
    private Board board;

    //the location of this piece on the board
    private Location location;

    //the color of the piece
    private Color color;

    //the file used to display this piece
    private String imageFileName;

    /**
     * Constructor for objects of class Queen
     * @param col the color of the Queen
     * @param fileName the image to use to represent this piece
     * @param loc where the Queen starts
     */
    public Queen(Color col, String fileName, Location loc)
    {
        super(col, fileName, 10);
        location = loc;
    }
    
    /**
     * Finds the destinations to which this Queen can move
     * @return an ArrayList of locations where the Queen can move to
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        location = getLocation();
        for (int i = 0; i <= 315; i += 45)
        {
            sweep(locs, i);
        }
        return locs;
    }
}
