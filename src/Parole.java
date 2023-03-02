public class Parole {
    private String Login;
    private String Password;
    private String confirmPassword;
    public Parole(String login, String password, String confirmPassword) {
        Login = login;
        Password = password;
        this.confirmPassword = confirmPassword;

    }
    public String getLogin() {
        return Login;
    }


    public String getPassword() {
        return Password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }


}
