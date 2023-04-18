import database.DatabaseConnection;
import pl.umcs.oop.lec7.auth.AccountManager;
//import pl.umcs.oop.lec7.auth.Account;


import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connect();

        AccountManager accountManager = new AccountManager(databaseConnection);
        try {
            var account = accountManager.getUser("test");
            System.out.println(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseConnection.disconnect();
    }
}