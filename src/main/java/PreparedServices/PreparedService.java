package PreparedServices;

import DataBase.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PreparedService {

    private PreparedStatement insertIntoWorker;
    private PreparedStatement insertIntoProject;
    private PreparedStatement insertIntoClient;
    private PreparedStatement insertIntoProjectWorker;

    public PreparedService(DataBase dataBase) throws SQLException {

        Connection conn = dataBase.getConnection();

        insertIntoWorker = conn.prepareStatement(
                "INSERT INTO worker(name, birthday, `level`, salary) VALUES (?, ?, ?, ?)"
        );
        insertIntoProject = conn.prepareStatement(
                "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)"
        );
        insertIntoClient = conn.prepareStatement(
                "INSERT INTO client (name) VALUES (?)"
        );
        insertIntoProjectWorker = conn.prepareStatement(
                "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)"
        );


    }

    public boolean createNewWorker(String name, LocalDate birthday, String level, int salary) {
        try {
            insertIntoWorker.setString(1, name);
            insertIntoWorker.setString(2, birthday.toString());
            insertIntoWorker.setString(3, level);
            insertIntoWorker.setInt(4, salary);
            return insertIntoWorker.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean createNewProject(long client_id, LocalDate start_date, LocalDate finish_date) {
        try {
            insertIntoWorker.setLong(1, client_id);
            insertIntoWorker.setString(2, start_date.toString());
            insertIntoWorker.setString(3, finish_date.toString());
            return insertIntoWorker.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean createNewClient(String name) {
        try {
            insertIntoWorker.setString(1, name);
            return insertIntoWorker.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean createNewProjectWorker(long project_id, long worker_id) {
        try {
            insertIntoWorker.setLong(1, project_id);
            insertIntoWorker.setLong(2, worker_id);
            return insertIntoWorker.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }
}
