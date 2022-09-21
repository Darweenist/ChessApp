import java.util.*;
import java.awt.*;
/**
 * Represents a king in chess.
 *
 * @author Dawson
 * @version 4/27/19
 */
public class King extends Piece
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
     * Constructor for objects of class King
     * @param col the color of the King
     * @param fileName the image to use to represent this piece
     * @param loc where the king starts
     */
    public King(Color col, String fileName, Location loc)
    {
        super(col, fileName, 1000);
        location = loc;
    }
    
    /**
     * Finds the destinations to which this King can move
     * @return an ArrayList of locations where the King can move to
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        location = getLocation();
        for (int i = 0; i <= 315; i += 45)
        {
            if (isValidDestination(location.getAdjacentLocation(i)))
            {
                locs.add(location.getAdjacentLocation(i));
            }
        }
        return locs;
    }
}
