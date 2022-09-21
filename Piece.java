import java.awt.*;
import java.util.*;
/**
 * This class represents a chess piece and provides general
 * abstract methods for all pieces.
 * @author Dawson Chen
 * @version 5/10/19
 */
public abstract class Piece
{
    //the board this piece is on
    private Board board;

    //the location of this piece on the board
    private Location location;

    //the color of the piece
    private Color color;

    //the file used to display this piece
    private String imageFileName;

    //the approximate value of this piece in a game of chess
    private int value;

    /**
     * Constructs a new Piece with the given attributes.
     * @param col the color of the piece
     * @param fileName the name of the image of the piece
     * @param val the value of the piece in a chess game
     */
    public Piece(Color col, String fileName, int val)
    {
        color = col;
        imageFileName = fileName;
        value = val;
    }

    /**
     * Gets the board this piece is on
     * @return the board this piece is on
     */
    public Board getBoard()
    {
        return board;
    }

    /**
     * Get the location of this piece on the board
     * @return the location of this piece on the board
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Gets the color of this piece
     * @return the color of this piece
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Gets the name of the file used to display this piece
     * @return the name of the file used to display this piece
     */
    public String getImageFileName()
    {
        return imageFileName;
    }

    /**
     * Gets a number representing the relative value of this piece
     * @return a number representing the relative value of this piece
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Puts this piece into a board. If there is another piece at the given
     * location, it is removed. <br />
     * Precondition: (1) This piece is not contained in a grid (2)
     * <code>loc</code> is valid in <code>gr</code>
     * @param brd the board into which this piece should be placed
     * @param loc the location into which the piece should be placed
     */
    public void putSelfInGrid(Board brd, Location loc)
    {
        if (board != null)
            throw new IllegalStateException(
                "This piece is already contained in a board.");

        Piece piece = brd.get(loc);
        if (piece != null)
            piece.removeSelfFromGrid();
        brd.put(loc, this);
        board = brd;
        location = loc;
    }

    /**
     * Removes this piece from its board. <br />
     * @precondition This piece is contained in a board
     */
    public void removeSelfFromGrid()
    {
        if (board == null)
            throw new IllegalStateException(
                "This piece is not contained in a board.");
        if (board.get(location) != this)
            throw new IllegalStateException(
                "The board contains a different piece at location "
                + location + ".");

        board.remove(location);
        board = null;
        location = null;
    }

    /**
     * Moves this piece to a new location. If there is another piece at the
     * given location, it is removed. <br />
     * Precondition: (1) This piece is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this piece
     * @param newLocation the new location
     */
    public void moveTo(Location newLocation)
    {
        if (board == null)
            throw new IllegalStateException("This piece is not on a board.");
        if (board.get(location) != this)
            throw new IllegalStateException(
                "The board contains a different piece at location "
                + location + ".");
        if (!board.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation
                + " is not valid.");

        if (newLocation.equals(location))
            return;
        board.remove(location);
        Piece other = board.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();
        location = newLocation;
        board.put(location, this);
    }
    
    /**
     * Gets whether a destination is valid
     * @param dest the destination to be considered valid
     * @return true if dest is valid; otherwise false
     */
    public boolean isValidDestination(Location dest)
    {
        return dest != null && (board.isValid(dest)) && 
            (board.get(dest) == null || board.get(dest).getColor() != color);
    }

    /**
     * @return an arraylist of possible destinations
     */
    public abstract ArrayList<Location> destinations();

    /**
     * @param dests the destinations in a row that are valid
     * @param direction the rows in this direction that are to be sweeped
     */
    public void sweep(ArrayList<Location> dests, int direction)
    {
        Location temp = location;
        while (isValidDestination(temp.getAdjacentLocation(direction)))
        {
            dests.add(temp.getAdjacentLocation(direction));
            temp = temp.getAdjacentLocation(direction);
            if (board.get(temp) != null)
                return;
        }
    }
}