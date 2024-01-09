import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

class Administrator extends Pegawai implements Login {
    private static final int CAPTCHA_LENGTH = 6;

    public Administrator(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean authenticate(String inputUsername, String inputPassword, String captchaCode) {
        return username.equals(inputUsername) && password.equals(inputPassword) && validateCaptcha(captchaCode);
    }

    @Override
    public void displayLoginMessage() {
        System.out.println("\nSelamat datang, " + getUsername() + "!");
        displayCurrentDateTime();
    }

    private void displayCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateAndTime = dateFormat.format(new Date());
        System.out.println("Login pada: " + currentDateAndTime);
    }

    private boolean validateCaptcha(String captchaCode) {
        // Logika validasi captcha
        // Contoh sederhana: captchaCode harus sesuai dengan nilai random
        Random random = new Random();
        String generatedCaptcha = generateRandomCaptcha();
        System.out.println("Captcha: " + generatedCaptcha);

        // Meminta pengguna memasukkan captcha
        System.out.print("Masukkan Captcha: ");
        String userCaptcha = new Scanner(System.in).nextLine();

        return userCaptcha.equals(generatedCaptcha);
    }

    private String generateRandomCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            captcha.append(random.nextInt(10));
        }
        return captcha.toString();
    }
}