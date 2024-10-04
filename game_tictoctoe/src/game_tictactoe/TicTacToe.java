package game_tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        int row, col;
        int moves = 0;

        while (true) {
            printBoard(board);

            System.out.println("Vez do jogador " + currentPlayer + ".");
            System.out.print("Digite a linha (0-2): ");
            row = scanner.nextInt();
            System.out.print("Digite a coluna (0-2): ");
            col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Jogada inválida. Tente novamente.");
                continue;
            }

            board[row][col] = currentPlayer;
            moves++;

            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Jogador " + currentPlayer + " venceu!");
                break;
            }

            if (moves == 9) {
                printBoard(board);
                System.out.println("Empate!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        System.out.println("0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("  -+-+-");
        System.out.println("1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("  -+-+-");
        System.out.println("2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public static boolean checkWin(char[][] board, char player) {
       
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

       
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

     
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
