import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner (System.in);
        String pilihan;
        boolean isLanjutkan = true;

        clearScreen();
        login();

        while (isLanjutkan) {
            
            System.out.println("\nDatabase Perpustakaan\n");
            System.out.println("1. Lihat Buku");
            System.out.println("2. Update Buku");
            System.out.println("3. Tambah Buku");
            System.out.println("4. Hapus Buku");

            System.out.println("\n\nPilihan Anda: ");
            pilihan = input.next();

            switch (pilihan){
                case "1":
                    System.out.println("==========");
                    System.out.println("List Buku");
                    System.out.println("==========");
                    tampilkanBuku();
                    break;
                case "2":
                    System.out.println("===========");
                    System.out.println("Update Buku");
                    System.out.println("===========");
                    updateBuku();
                    break;
                case "3":
                    System.out.println("================");
                    System.out.println("Menambahkan Buku");
                    System.out.println("================");
                    tambahBuku();
                    break;
                case "4":
                    System.out.println("==============");
                    System.out.println("Menghapus Buku");
                    System.out.println("==============");
                    hapusBuku();
                    break;
                default:
                    System.err.println("\nInput Anda Tidak Ditemukan\nSilahkan pilih opsi 1 - 5");
            }
            isLanjutkan = getYesorNO("Apakah anda ingin melanjutkan");
            clearScreen();
        }
    }    

    private static void tampilkanBuku() throws IOException{
        ReadBuku baca = new ReadBuku();
        baca.ReadBuku();
    }

    private static void updateBuku() throws IOException{
        Scanner scan = new Scanner(System.in);
        UpdateBuku.updateDataBuku(scan);
        System.out.println("");
    }

    private static void tambahBuku() throws IOException{
        Scanner scanner = new Scanner(System.in);
        CreateBuku.insertDataBuku(scanner);
        System.out.println("");
    }

    private static void hapusBuku() throws IOException{
        DeleteBuku.deleteBukuById();
        System.out.println(""); 
    }

    private static boolean getYesorNO(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihan = input.next();
    
        while (!pilihan.equalsIgnoreCase("y") && (!pilihan.equalsIgnoreCase("n"))) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihan = input.next();
        }

        return pilihan.equalsIgnoreCase("y");
    }

    private static void clearScreen(){
        try{
            if (System.getProperty("os.name").contains("windows")){
                new ProcessBuilder ("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        }catch (Exception ex){
            System.err.println("Tidak bisa clear screen");
        }
    }

    public static void login(){
          Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Membuat objek Administrator
        Administrator admin = new Administrator("admin", "admin123");

        // Melakukan autentikasi
        if (admin.authenticate(username, password, "")) {
            admin.displayLoginMessage();
            // Lakukan tindakan setelah login berhasil
        } else {
            System.out.println("Login gagal. Periksa kembali username, password, dan captcha.");
        }
    }
}

    

