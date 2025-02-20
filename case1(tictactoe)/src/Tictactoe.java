import java.util.Scanner;

public class Tictactoe {
    
}

class Board{
    private char[][] board = new char[3][3];

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public Board(){
        initializeBoard();
    }

    public void printBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char player){
        if(row>=0 && row<3 && col>=0 && col<3 && board[row][col] == '-'){
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean checkWin(char player){
        for(int i=0; i<3; i++){
            if((board[i][0] == player && board[i][1] == player && board[i][2] == player) || (board[0][i] == player && board[1][i] == player && board[2][i] == player)){
                return true;
            }
        }

        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player)){
            return true;
        }
        return false;
    }
}

class Player{
    private char symbol;

    public Player(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }
}

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

        while(!gameWon && turns < 9){
            board.printBoard();
            System.out.println("Player" + currentPlayer.getSymbol() + ", enter your move(row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(board.makeMove(row, col, currentPlayer.getSymbol())){
                if (board.checkWin(currentPlayer.getSymbol())) {
                    gameWon = true;
                    board.printBoard();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                } else {
                    currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                    turns++;
                }
            }else{
                System.out.println("Invalid move. Try again.");
            }
        }

        if (!gameWon) {
            board.printBoard();
            System.out.println("It's a draw!");
        }

    }
}