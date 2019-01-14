import GUI.GUI;
import GUI.login;

public class Main {
    public static void main(String[] args) {
        String Username = "boss";
        String Passwd = "123456";
        login log = new login(Username, Passwd);
        log.logInUi();

    }
}

