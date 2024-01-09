import java.sql.*;

public class ReadBuku {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbperpustakaan";
    static final String USER = "root";
    static final String PASSWORD = "";

    public void ReadBuku(){
        try {
            // Menghubungkan ke database
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Membuat statement SQL
            String query = "SELECT * FROM buku";
            Statement statement = connection.createStatement();

            // Mengeksekusi query dan mendapatkan hasilnya
            ResultSet resultSet = statement.executeQuery(query);

            // Menampilkan hasil query
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String Judul = resultSet.getString("Judul");
                String Penulis = resultSet.getString("Penulis");

                System.out.println(ID + ". " + Judul + " - " + Penulis);
            }

            // Menutup resource
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
