import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Mayın Tarlası oyununa hoşgeldiniz !");
        System.out.println("1- Classic: 8x8\n2- Easy: 9x9\n3- Medium: 16x16\n4- Expert: 30x16\n5- Custom: ?x?");
        int selection = 0;

        do {
            System.out.print("Lütfen seçiniz : ");
            selection = scan.nextInt();
            if (selection < 1 || selection > 5) {

                System.out.println("Seçiminiz geçersizdir !");
            }
        } while (selection < 1 || selection > 5);

        int row, col;
        MineSweeper mine;

        switch (selection) {
            case 1:
                mine = new MineSweeper(8, 8);
                break;
            case 2:
                mine = new MineSweeper(9, 9);
                break;
            case 3:
                mine = new MineSweeper(16, 16);
                break;
            case 4:
                mine = new MineSweeper(30, 16);
                break;
            case 5:

                do {
                    System.out.print("Satır sayısını giriniz : ");
                    row = scan.nextInt();
                    System.out.print("Sütun sayısını giriniz : ");
                    col = scan.nextInt();
                    if ((row < 2 || col < 2)) {
                        System.out.println("Tarlanın boyutu 2x2'den küçük olamaz !");
                    }
                } while (row < 2 || col < 2);
                mine = new MineSweeper(row, col);
                break;
            default:
                mine = new MineSweeper(2, 2);
                break;
        }

        mine.run();

    }
}
