package DbServises;

import DataBase.DataBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {

    public static final String INSERT_INTO_TABLE = "C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\insert_into_table.sql";

    public void insertDataToDb(DataBase dataBase) {
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(INSERT_INTO_TABLE)));
            dataBase.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
