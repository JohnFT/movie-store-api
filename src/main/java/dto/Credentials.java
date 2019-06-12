package dto;

public class Credentials {
    public String pass;
    public String user;

    public Credentials() {
    }

    public Credentials(String pass, String user) {
        this.pass = pass;
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "pass='" + pass + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
