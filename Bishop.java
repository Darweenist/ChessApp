import java.util.*;
import java.awt.*;
/**
 * Represents a bishop in chess which can move diagonally as far as desired.
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public class Bishop extends Piece
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
     * Constructor for objects of class Bishop
     * @param col the color of the bishop
     * @param fileName the image to use to represent this piece
     * @param loc where the bishop starts
     */
    public Bishop(Color col, String fileName, Location loc)
    {
        super(col, fileName, 3);
        location = loc;
    }
    
    /**
     * Finds the destinations to which this Bishop can move
     * @return an ArrayList of locations where the Bishop can move to
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        //Location temp = location;
        location = getLocation();
        for (int i = 45; i <= 315; i += 90)
            sweep(locs, i);
        return locs;
    }
}
