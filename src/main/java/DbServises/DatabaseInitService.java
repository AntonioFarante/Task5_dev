package DbServises;

import DataBase.DataBase;
import org.h2.engine.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static final String INIT_DB ="C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\init_db.sql";

   public void initDb(DataBase database) {
       try {
           String sql = String.join("\n", Files.readAllLines(Paths.get(INIT_DB)));
           database.executeUpdate(sql);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }
}
