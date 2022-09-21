import java.util.*;
import java.awt.*;
/**
 * Represents a pawn piece in a traditional chess game.
 *
 * @author Dawson
 * @version 4/27/19
 */
public class Pawn extends Piece
{
    //the location of this piece on the board
    private Location location;

    /**
     * Constructor for objects of class pawn
     * @param col the color of the pawn
     * @param fileName the image to use to represent this piece
     * @param loc where the pawn starts
     */
    public Pawn (Color col, String fileName, Location loc)
    {
        super(col, fileName, 1);
        location = loc;
    }

    /**
     * Finds the destinations to which this King can move
     * @return ArrayList of locations where the King can move to
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        location = getLocation();
        if (getColor().equals(Color.WHITE))
        {
            Location topLeft = new Location(location.getRow() - 1, 
                location.getCol() - 1);
            Location topRight = new Location(location.getRow() - 1, 
                location.getCol() + 1);
            Location topMid = new Location(location.getRow() - 1, 
                location.getCol());
            Location topTopMid = new Location(location.getRow() - 2, 
                location.getCol());
            if (isValidDestination(topMid) && getBoard().get(topMid) == null &&
                location.getRow() == 6 && isValidDestination(topTopMid) &&
                getBoard().get(topTopMid) == null)
            {
                locs.add(topTopMid);
            }
            if (isValidDestination(topMid) && getBoard().get(topMid) == null)
                locs.add(topMid);
            if (isValidDestination(topRight) && 
                getBoard().get(topRight) != null)
                locs.add(topRight);
            if (isValidDestination(topLeft) && getBoard().get(topLeft) != null)
                locs.add(topLeft);
        } 
        else 
        {
            Location topLeft = new Location(location.getRow() + 1, 
                location.getCol() + 1);
            Location topRight = new Location(location.getRow() + 1, 
                location.getCol() - 1);
            Location topMid = new Location(location.getRow() + 1, 
                location.getCol());
            Location topTopMid = new Location(location.getRow() + 2, 
                location.getCol());
            if (isValidDestination(topMid) && getBoard().get(topMid) == null &&
                location.getRow() == 1 && isValidDestination(topTopMid) &&
                getBoard().get(topTopMid) == null)
            {
                locs.add(topTopMid);
            }
            if (isValidDestination(topMid) && 
                getBoard().get(topMid) == null)
                locs.add(topMid);
            if (isValidDestination(topRight) && 
                getBoard().get(topRight) != null)
                locs.add(topRight);
            if (isValidDestination(topLeft) && 
                getBoard().get(topLeft) != null)
                locs.add(topLeft);
        }
        return locs;
    }
}
