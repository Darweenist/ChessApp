import java.awt.*;
import java.util.*;

/**
 * Represesents a rectangular game board, containing Piece objects.
 * @author Dawson Chen
 * @version 5/15/19
 */
public class Board extends BoundedGrid<Piece>
{
    /**
     * Constructs a new Board with the given dimensions
     */
    public Board()
    {
        super(8, 8);
    }

    /**
     * @precondition move has already been made on the board
     * @postcondition piece has moved back to its source,
     * and any captured piece is returned to its location
     * @param move is the move to be undone
     */
    public void undoMove(Move move)
    {
        Piece piece = move.getPiece();
        Location source = move.getSource();
        Location dest = move.getDestination();
        Piece victim = move.getVictim();
        piece.moveTo(source);
        if (victim != null)
            victim.putSelfInGrid(piece.getBoard(), dest);
    }

    /**
     * Defines all the possible legal moves that a player of a 
     * certain color can make
     * @param color the color of the player (white/black)
     * @return an ArrayList<Move> of all possible moves made by 
     * color player
     */
    public ArrayList<Move> allMoves(Color color)
    {
        ArrayList<Move> moves = new ArrayList<Move>();
        for (Location loc : getOccupiedLocations())
        {
            if (get(loc).getColor().equals(color))
            {
                for (int i = 0; i < get(loc).destinations().size(); i++)
                {
                    moves.add(new Move(get(loc), get(loc)
                        .destinations().get(i)));
                }
            }
        }
        return moves;
    }

    /**
     * Executes the move by moving the designated piece to its 
     * designated destination
     * @param move the move containing all the info like piece and destination
     */
    public void executeMove(Move move)
    {
        move.getPiece().moveTo(move.getDestination());
    }
}