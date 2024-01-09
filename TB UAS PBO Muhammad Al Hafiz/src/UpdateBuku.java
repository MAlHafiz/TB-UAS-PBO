import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBuku {
     //Driver
     private static final String URL = "jdbc:mysql://localhost:3306/dbperpustakaan";
     private static final String USER = "root";
     private static final String PASSWORD = "";
 
     
     public static void updateDataBuku(Scanner scanner) {
         try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
             String sql = "UPDATE buku SET Judul = ?, Penulis = ? WHERE ID = ?";
             try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                 System.out.print("No. ID Buku: ");
                 int ID = scanner.nextInt();
                 
                 System.out.print("Judul Buku Baru: ");
                 String judulBaru = scanner.next();
 
                 System.out.print("Penulis Buku: ");
                 String penulisBaru = scanner.next();
 
                 preparedStatement.setString(1, judulBaru);
                 preparedStatement.setString(2, penulisBaru);
                 preparedStatement.setInt(3, ID);
 
                 int rowsAffected = preparedStatement.executeUpdate();
 
                 if (rowsAffected > 0) {
                     System.out.println("Data Buku telah diupdate!");
                 } else {
                     System.out.println("tidak ditemukan data buku dengan ID tersebut");
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }

