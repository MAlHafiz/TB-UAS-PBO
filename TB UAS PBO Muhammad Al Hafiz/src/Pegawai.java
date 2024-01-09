public class Pegawai {
    protected String username;
    protected String password;

    public Pegawai(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}