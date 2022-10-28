package designPattern.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Data Access Object-Architectural
 * DAO is an interface provide over the base persistence mechanism.
 * We need the whole set of CRUD (create/read/update/delete) operations
 *
 * Applicability
 * Use the Data Access Object in any of the following situations:
 *
 * When you want to consolidate how the data layer is accessed.
 * When you want to avoid writing multiple data retrieval/persistence layers.
 */
public class DAOMain {
    public static void main(String[] args) throws Exception {

        EmployeeDao employeeInMemoryDao = new InMemoryEmployeeDao();
        //createSchema(dataSource);
        //final var customerDao = new DbEmployeeDao(dataSource);
        final var employee = new Employee(4, "Eyuel", 45.98);
        employeeInMemoryDao.add(employee);
    }


}

@Data @AllArgsConstructor
class Employee {
    private int id;
    private String name;
    private double salary;
}

interface EmployeeDao {

    Stream<Employee> getAll() throws Exception;

    Optional<Employee> getById(int id) throws Exception;

    boolean add(Employee employee) throws Exception;

    boolean update(Employee employee) throws Exception;

    boolean delete(Employee employee) throws Exception;
}

/**
 * An in memory implementation  which stores the Employee in JVM memory and
 *  data is lost when the application exits.
 *  This implementation is useful as temporary database or for testing.
 */
class InMemoryEmployeeDao implements EmployeeDao {

    private final Map<Integer, Employee> employees = new HashMap<>();


    @Override
    public Stream<Employee> getAll() throws Exception {
        return employees.values().stream();
    }

    @Override
    public Optional<Employee> getById(final int id) throws Exception {
        return Optional.ofNullable(employees.get(id));
    }

    @Override
    public boolean add(final Employee employee) throws Exception {
        if (getById(employee.getId()).isPresent())
            return false;
        employees.putIfAbsent(employee.getId(),employee);
            return true;
   }

    @Override
    public boolean update(final Employee employee) throws Exception {
        return employees.replace(employee.getId(), employee) != null;
    }

    @Override
    public boolean delete(Employee employee) throws Exception {
        return employees.remove(employee.getId()) != null;
    }
}

//@Slf4j
// @Data
class DbEmployeeDao implements EmployeeDao {

    private final DataSource dataSource;

    public DbEmployeeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Stream<Employee> getAll() throws Exception {
        return null;
    }
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    @Override
    public Optional<Employee> getById(int id) throws Exception {
        return Optional.empty();
    }

    @Override
    public boolean add(Employee employee) throws Exception {
        return false;
    }

    @Override
    public boolean update(Employee employee) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Employee employee) throws Exception {
        return false;
    }


    // implement the interface using the data source
}
@AllArgsConstructor
final class EmployeeSchemaSql {

    public static final String CREATE_SCHEMA_SQL =
            "CREATE TABLE EMPLOYEES (ID NUMBER, NAME VARCHAR(100), SALARY DOUBLE)";

    public static final String DELETE_SCHEMA_SQL = "DROP TABLE EMPLOYEES";
}
