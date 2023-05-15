import DataBase.DataBase;
import PreparedServices.PreparedService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {


    public static void main(String[] args) throws SQLException {
        DataBase db = DataBase.getInstance();

        PreparedService service = new PreparedService(db);
        boolean newWorker = service.createNewWorker("Ivan", LocalDate.now(), "Junior", 1300);
        System.out.println(newWorker);
    }
}
