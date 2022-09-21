import java.util.*;
import java.awt.*;
/**
 * Represents a knight in chess
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public class Knight extends Piece
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
     * Constructor for objects of class Knight
     * @param col is the color of the knight
     * @param fileName is the name of the image file that 
     * represents the knight
     * @param loc is the starting location of the knight
     * 
     */
    public Knight(Color col, String fileName, Location loc)
    {
        super (col, fileName, 3);
        location = loc;
    }

    /**
     * Finds the destinations to which this Knight can move
     * @return an ArrayList of locations where the Knight can move to
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        location = getLocation();
        Location topLeft = null;
        Location topRight = null;
        for (int i = 0; i < 360; i += 90)
        {
            if (location.getAdjacentLocation(i) != null)
            {
                if (location.getAdjacentLocation(i).getAdjacentLocation(i) 
                    != null)
                {
                    topLeft = location.getAdjacentLocation(i)
                        .getAdjacentLocation(i).getAdjacentLocation(i - 90);
                    topRight = location.getAdjacentLocation(i)
                        .getAdjacentLocation(i).getAdjacentLocation(i + 90);
                    if (isValidDestination(topLeft))
                        locs.add(topLeft);
                    if (isValidDestination(topRight))
                        locs.add(topRight);
                }
            }
        }
        return locs;
    }
}
