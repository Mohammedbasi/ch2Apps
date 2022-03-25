package lecture11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FConnection {

    private static FConnection fConnection;

    private FConnection() {
    }

    public static FConnection getFConnection() {
        if (fConnection == null) {
            fConnection = new FConnection();
        }
        return fConnection;
    }

    public boolean verifyUser(String loginName, String password) {
        boolean isValid = false;
        try {
            Scanner scanner = new Scanner(new File("./src/lecture11/pass.txt"));
            while (scanner.hasNextLine()) {
                String name = scanner.next();
                String pass = scanner.next();
                if (loginName.equals(name) && pass.equals(password)) {
                    isValid = true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
}
