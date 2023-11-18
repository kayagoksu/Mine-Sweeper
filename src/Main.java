import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Mayın tarlası satır sayısını belirtiniz : ");
        int row = input.nextInt();
        System.out.print("Mayın tarlası sütun sayısını belirtiniz : ");
        int col = input.nextInt();

        MineSweeper mine = new MineSweeper(row, col);
        mine.run();

    }
}