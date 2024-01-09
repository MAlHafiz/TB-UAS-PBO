import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBuku {
    private static final String URL = "jdbc:mysql://localhost:3306/dbperpustakaan";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void deleteBukuById() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM buku WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Scanner del = new Scanner(System.in);
                System.out.print("Masukkan ID buku yang dihapus: ");
                int idBuku = del.nextInt();
                preparedStatement.setInt(1, idBuku);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("data buku berhasil dihapus!");
                } else {
                    System.out.println("tidak ditemukan data buku dengan ID tersebut.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

