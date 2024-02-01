import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber, colNumber, boardSize;
    String[][] gameBoard;
    String[][] mineBoard;
    boolean isWin = true;
    int mineCount;
    int remained;

    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.gameBoard = new String[this.rowNumber][this.colNumber];
        this.mineBoard = new String[this.rowNumber][this.colNumber];
        this.boardSize = this.rowNumber * this.colNumber;
        this.mineCount = (this.rowNumber * this.colNumber) / 4;
        this.remained = boardSize - mineCount;
        prepareBoards();
        prepareMines();
    }

    public void prepareBoards() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                gameBoard[i][j] = "-";
                mineBoard[i][j] = "0";
            }
        }
    }

    public void prepareMines() {
        int row, col, bomb = 0;
        while (bomb < this.mineCount) {
            row = random.nextInt(this.rowNumber);
            col = random.nextInt(this.colNumber);
            if (!mineBoard[row][col].equals("*")) {
                mineBoard[row][col] = "*";
                bomb++;
            }
        }

    }

    public void print(String[][] arr) {
        System.out.println("=====================");
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void run() {
        print(gameBoard);
        print(mineBoard);
        while (isWin) {
            System.out.print("Oynamak istediğiniz satırı giriniz : ");
            int row = scan.nextInt();
            System.out.print("Oynamak istediğiniz sütunu giriniz : ");
            int col = scan.nextInt();
            game(row, col);
        }

    }

    public boolean isValid(int r, int c) {
        return (r >= 0 && r < this.rowNumber) && (c >= 0 && c < this.colNumber);
    }

    public void game(int row, int col) {
        if (!isValid(row, col)) {
            System.out.println("Lütfen geçerli bir koordinat giriniz !");
            return;
        }
        if (!gameBoard[row][col].equals("-")) {
            System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin!");
            return;
        }
        if (mineBoard[row][col].equals("*")) {
            print(mineBoard);
            System.out.println("GAME OVER !");
            System.exit(0);
        }
        int count = calcMines(row, col);
        gameBoard[row][col] = String.valueOf(count);
        mineBoard[row][col] = String.valueOf(count);
        remained--;
        if (count == 0) {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (isValid(i, j) && gameBoard[i][j].equals("-")) {
                        game(i, j);
                    }
                }
            }
        }
        if (remained == 0) {
            print(mineBoard);
            System.out.println("OYUNU KAZANDINIZ !");
            System.exit(0);
        } else {
            print(gameBoard);
        }
    }

    public int calcMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValid(i, j) && mineBoard[i][j].equals("*")) {
                    count++;
                }
            }
        }
        return count;
    }
}
