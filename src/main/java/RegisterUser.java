public class RegisterUser {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public RegisterUser withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUser withPassword(String password) {
        this.password = password;
        return this;
    }
}
