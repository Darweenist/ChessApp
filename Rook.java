import java.util.*;
import java.awt.*;
/**
 * Represents a rook from a chess game.
 *
 * @author Dawson Chen
 * @version 4/28/19
 */
public class Rook extends Piece
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
    public Rook(Color col, String fileName, Location loc)
    {
        super(col, fileName, 5);
        location = loc;
    }
    
    /**
     * Finds the destinations to which this rook can move
     * @return an ArrayList of locations where the rook can move to
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        //Location temp = location;
        for (int i = 0; i <= 270; i += 90)
            sweep(locs, i);
        return locs;
    }
}
