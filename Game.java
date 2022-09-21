import java.awt.*;
import java.util.*;
/**
 * Represents a chess game with basic functionalities
 *
 * @author Dawson Chen
 * @version 4/27/19
 */
public class Game
{

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {

    }

    /**
     * Runs the chess game
     * @param args the arguments passed into main
     */
    public static void main(String[] args)
    {
        Board board = new Board();
        Piece blackKing = new King(Color.BLACK, 
                "black_king.gif",  new Location(0,  4));
        blackKing.putSelfInGrid(board,  new Location(0,  4));
        Piece whiteKing = new King(Color.WHITE, 
                "white_king.gif",  new Location(7,  4));
        whiteKing.putSelfInGrid(board,  new Location(7,  4));

        Piece blackRook = new Rook(Color.BLACK,  "black_rook.gif",  
                new Location(0, 0));
        blackRook.putSelfInGrid(board,  new Location(0, 0));

        Piece blackRook2 = new Rook(Color.BLACK,  "black_rook.gif", 
                new Location(0, 7));
        blackRook2.putSelfInGrid(board,  new Location(0, 7));

        Piece whiteRook = new Rook(Color.WHITE,  "white_rook.gif", 
                new Location(7, 0));
        whiteRook.putSelfInGrid(board,  new Location(7, 0));

        Piece whiteRook2 = new Rook(Color.WHITE,  "white_rook.gif",  
                new Location(7, 7));
        whiteRook2.putSelfInGrid(board,  new Location(7, 7));

        Piece whiteBishop = new Bishop(Color.WHITE,  "white_bishop.gif", 
                new Location(7, 2));
        whiteBishop.putSelfInGrid(board,  new Location(7, 2));

        Piece whiteBishop2 = new Bishop(Color.WHITE,  "white_bishop.gif", 
                new Location(7, 5));
        whiteBishop2.putSelfInGrid(board,  new Location(7, 5));

        Piece blackBishop = new Bishop(Color.black,  "black_bishop.gif", 
                new Location(0, 2));
        blackBishop.putSelfInGrid(board,  new Location(0, 2));

        Piece blackBishop2 = new Bishop(Color.black,  "black_bishop.gif", 
                new Location(0, 5));
        blackBishop2.putSelfInGrid(board,  new Location(0, 5));

        Piece whiteQueen = new Queen(Color.WHITE,  "white_queen.gif", 
                new Location(7, 3));
        whiteQueen.putSelfInGrid(board,  new Location(7, 3));

        Piece blackQueen = new Queen(Color.black,  "black_queen.gif", 
                new Location(0, 3));
        blackQueen.putSelfInGrid(board,  new Location(0, 3));

        Piece whiteKnight = new Knight(Color.WHITE,  "white_knight.gif", 
                new Location(7, 1));
        whiteKnight.putSelfInGrid(board,  new Location(7, 1));

        Piece whiteKnight2 = new Knight(Color.WHITE,  "white_knight.gif", 
                new Location(7, 6));
        whiteKnight2.putSelfInGrid(board,  new Location(7, 6));

        Piece blackKnight = new Knight(Color.black,  "black_knight.gif", 
                new Location(0, 1));
        blackKnight.putSelfInGrid(board,  new Location(0, 1));

        Piece blackKnight2 = new Knight(Color.black,  "black_knight.gif", 
                new Location(0, 6));
        blackKnight2.putSelfInGrid(board,  new Location(0, 6));

        for (int i = 0; i < 8; i++)
        {
            Location loc1 = new Location(1, i);
            Location loc2 = new Location(6, i);
            Piece blackPawn = new Pawn(Color.BLACK, 
                "black_pawn.gif",  loc1);
            Piece whitePawn = new Pawn(Color.WHITE,
                 "white_pawn.gif",  loc2);
            blackPawn.putSelfInGrid(board, loc1);
            whitePawn.putSelfInGrid(board, loc2);
        }
        BoardDisplay display = new BoardDisplay(board);
        // for(Location loc: whiteKing.destinations())
        // {
        // display.setColor(loc,  Color.green);
        // }
        Player dude = new HumanPlayer(board, "Dawson", Color.BLACK, display);
        Player dude2 = new HumanPlayer(board, "Dawson2", Color.WHITE, display);
        dude = new SmarterPlayer(board, "Smart", Color.BLACK);

        // Move move = dude.nextMove();
        // display.setColor(move.getDestination(),  Color.GREEN);
        // display.setColor(move.getSource(),  Color.GREEN);

        play(board, display, dude2, dude);
    }

    /**
     * Executes the next turn by calling next move on the player param
     * @param player the next player who is to go their turn
     * @param board is the chess board played on
     * @param display is the BoardDisplay being used to show the game
     */
    private static void nextTurn(Board board,  
        BoardDisplay display,  Player player)
    {
        display.setTitle(player.getName());
        Move nextMove = player.nextMove();
        display.clearColors();
        board.executeMove(nextMove);
        display.setColor(nextMove.getSource(), Color.GREEN);
        display.setColor(nextMove.getDestination(), Color.GREEN);
        try 
        {
            Thread.sleep(500);
        } 
        catch (InterruptedException e) 
        {
            throw new RuntimeException("Display malfunctioning!");
        }
    }

    /**
     * Continues to execute moves,  alternating colors per turn
     * @param board is the chess board played on
     * @param display is the BoardDisplay being used to show the game
     * @param white is the player with white pieces
     * @param black is the player with black pieces
     */
    public static void play(Board board,  BoardDisplay display,  
        Player white,  Player black)
    {
        boolean flag = true;
        while (true)
        {
            if (flag)
                nextTurn(board,  display,  white);
            else
                nextTurn(board,  display,  black);
            flag = !flag;
        }
    }
}
