import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateBuku {
    private static final String URL = "jdbc:mysql://localhost:3306/dbperpustakaan";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertDataBuku(Scanner scan) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO buku (ID, Judul, Penulis) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                System.out.print("\nInputkan ID Buku: ");
                int idBuku = scan.nextInt();

                System.out.print("Inputkan Judul Buku: ");
                String judulBuku = scan.next();

                System.out.print("Inputkan Penulis Buku: ");
                String penulisBuku = scan.next();

                preparedStatement.setInt(1, idBuku);
                preparedStatement.setString(2, judulBuku);
                preparedStatement.setString(3, penulisBuku);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Berhasil menginputkan buku baru");
                } else {
                    System.out.println("Tidak dapat menginputkan buku baru");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

