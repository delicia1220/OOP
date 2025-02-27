import java.util.*;

class Game{
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game(){
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public void start(){
        int turns = 0;
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);
    
        while (!gameWon && turns < 9) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row and column, separated by space):");
    
            int row = -1, col = -1;
    
            boolean validInput = false;
            while (!validInput) {
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    if (scanner.hasNextInt()) {
                        col = scanner.nextInt();
                        
                        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                            if (board.makeMove(row, col, currentPlayer.getSymbol())) {
                                validInput = true;
                            } else {
                                System.out.println("Invalid move. Cell already occupied. Try again:");
                            }
                        } else {
                            System.out.println("Invalid move. Row and column must be between 0 and 2. Try again:");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter two integers:");
                        scanner.next();
                    }
                } else {
                    System.out.println("Invalid input. Please enter two integers:");
                    scanner.next(); 
                }
            }
    
            if (board.checkWin(currentPlayer.getSymbol())) {
                gameWon = true;
                board.printBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
            } else {
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                turns++;
            }
        }
    
        if (!gameWon) {
            board.printBoard();
            System.out.println("It's a draw!");
        }
        scanner.close();
    }
}