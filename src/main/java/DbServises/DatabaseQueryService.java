package DbServises;

import ClassesForSqlQuery.LongestProject;
import ClassesForSqlQuery.MaxProjectCountClient;
import ClassesForSqlQuery.MaxSalaryWorker;
import ClassesForSqlQuery.ProjectPrices;
import ClassesForSqlQuery.YoungestEldestWorkers;
import DataBase.DataBase;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String MAX_SALARY_WORKER = "C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\find_max_salary_worker.sql";
    private static final String LONGEST_PROJECT = "C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\find_longest_project.sql";
    private static final String MAX_PROJECT_CLIENT = "C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\find_max_projects_client.sql";
    private static final String YOUNGEST_ELDEST_WORKERS = "C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\find_youngest_eldest_workers.sql";
    private static final String PROJECT_PRICE = "C:\\Users\\HP\\IdeaProjects\\JDBC_TEST\\src\\main\\java\\SqlFiles\\print_project_prices.sql";

    public List<MaxSalaryWorker> findMaxSalaryWorker(DataBase dataBase) {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(MAX_SALARY_WORKER)));
            ResultSet resultSet = dataBase.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                result.add(new MaxSalaryWorker(name, salary));
                System.out.println(name + " have/has max salary " + salary + " USD");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectCountClient(DataBase dataBase) {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(MAX_PROJECT_CLIENT)));
            ResultSet resultSet = dataBase.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                result.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject(DataBase dataBase) {
        List<LongestProject> result = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(LONGEST_PROJECT)));
            ResultSet resultSet = dataBase.executeQuery(sql);
            while (resultSet.next()) {
                String project = resultSet.getString("project");
                int duration = resultSet.getInt("month_count");
                result.add(new LongestProject(project, duration));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProjectPrices> findProjectPrice(DataBase dataBase) {
        List<ProjectPrices> result = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(PROJECT_PRICE)));
            ResultSet resultSet = dataBase.executeQuery(sql);
            while (resultSet.next()) {
                BigDecimal project_price = resultSet.getBigDecimal("price");
                String name = resultSet.getString("name");

                result.add(new ProjectPrices(name, project_price));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(DataBase dataBase) {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(YOUNGEST_ELDEST_WORKERS)));
            ResultSet resultSet = dataBase.executeQuery(sql);
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");

                result.add(new YoungestEldestWorkers(type, name, birthday));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
