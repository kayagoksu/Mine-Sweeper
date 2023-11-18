import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int row;
    int col;
    int bomb;
    Random rand = new Random();

    MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.bomb = 0;
    }

    void run() {

        System.out.println("Tarla boyutu: " + this.row + " x " + this.col);
        int[][] matrix = new int[this.row][this.col];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                matrix[i][j] = -2;
//                System.out.print("- ");
            }
//            System.out.println();
        }

        this.bomb = (this.row * this.col) / 4;
        System.out.println("Mayın sayısı : " + this.bomb);
        int randomRow;
        int randomCol;
        int bombCount = 0;
        while (bombCount < bomb) {
            randomRow = rand.nextInt(this.row);
            randomCol = rand.nextInt(this.col);
            if (matrix[randomRow][randomCol] != -1) {
                matrix[randomRow][randomCol] = -1;
                bombCount++;
            }
        }

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (matrix[i][j] == -2) {
//                    System.out.print("- ");
                } else if (matrix[i][j] == -1) {
//                    System.out.print("* ");
                }
            }
//            System.out.println();
        }

        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print("- ");
            }
            System.out.println();
        }

        Scanner input = new Scanner(System.in);
        int selectedRow, selectedCol;
        int count = 0;

        do {
            System.out.print("Satır giriniz : ");
            selectedRow = input.nextInt();
            System.out.print("Sütun giriniz : ");
            selectedCol = input.nextInt();

            while (selectedRow >= matrix.length || selectedRow < 0 || selectedCol >= matrix[this.row - 1].length || selectedCol < 0) {
                System.out.println("Geçersiz koordinat !");
                System.out.print("Satır giriniz : ");
                selectedRow = input.nextInt();
                System.out.print("Sütun giriniz : ");
                selectedCol = input.nextInt();
            }

            int kalan = this.row * this.col;
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                    if (matrix[i][j] != -2) {
                        kalan--;
                    }
                }
            }

            if (matrix[selectedRow][selectedCol] == -1) {
                System.out.println("Game Over !");
                for (int i = 0; i < this.row; i++) {
                    for (int j = 0; j < this.col; j++) {
                        if (matrix[i][j] == -1) {
                            System.out.print("* ");
                        } else if (matrix[i][j] == -2) {
                            System.out.print("- ");
                        } else System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            }

            if (selectedCol - 1 >= 0) {
                if (matrix[selectedRow][selectedCol - 1] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedCol + 1 < matrix[selectedRow].length)) {
                if (matrix[selectedRow][selectedCol + 1] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedRow - 1 >= 0)) {
                if (matrix[selectedRow - 1][selectedCol] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedRow + 1 < matrix.length)) {
                if (matrix[selectedRow + 1][selectedCol] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedRow - 1 >= 0) && (selectedCol - 1 >= 0)) {
                if (matrix[selectedRow - 1][selectedCol - 1] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedRow - 1 >= 0) && (selectedCol + 1 < matrix[selectedRow].length)) {
                if (matrix[selectedRow - 1][selectedCol + 1] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedRow + 1 < matrix.length) && (selectedCol - 1 >= 0)) {
                if (matrix[selectedRow + 1][selectedCol - 1] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if ((selectedRow + 1 < matrix.length) && (selectedCol + 1 < matrix[selectedRow].length)) {
                if (matrix[selectedRow + 1][selectedCol + 1] == -1) {
                    matrix[selectedRow][selectedCol] = count + 1;
                    count++;
                } else {
                    matrix[selectedRow][selectedCol] = count;
                }
            }

            if (kalan == 1) {
                System.out.println("Oyunu Kazandınız !");
                for (int i = 0; i < this.row; i++) {
                    for (int j = 0; j < this.col; j++) {
                        if (matrix[i][j] == -1) {
                            System.out.print("* ");
                        } else System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            }

            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                    if (matrix[i][j] == -2 || matrix[i][j] == -1) {
                        System.out.print("- ");
                    } else {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
                System.out.println();
            }

            System.out.println("count : " + count);
            count = 0;

        } while (matrix[selectedRow][selectedCol] != -1);

    }

}
