interface Login {
    boolean authenticate(String inputUsername, String inputPassword, String captchaCode);
    void displayLoginMessage();
}