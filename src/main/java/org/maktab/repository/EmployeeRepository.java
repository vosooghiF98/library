package org.maktab.repository;

import org.maktab.config.DBConfig;
import org.maktab.entity.AccessModifier;
import org.maktab.entity.Employee;
import org.maktab.entity.Grade;
import org.maktab.util.list.EmployeeList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository {
    public void save(Employee employee) throws SQLException {
        String query = """
                insert into employee (firstname, lastname, nationalcode, salary, accessmodifier)
                values (?,?,?,?,?);
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getNationalCode());
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setString(5, String.valueOf(employee.getAccessModifier()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void remove(Employee employee) throws SQLException {
        String query = """
                delete from employee where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public EmployeeList loadAll() throws SQLException {
        String query = """
                select * from employee;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        EmployeeList employeeList = new EmployeeList();
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("nationalcode"), AccessModifier.valueOf(resultSet.getString("accessmodifier")));
            employeeList.add(employee);
        }
        resultSet.close();
        preparedStatement.close();
        return employeeList;
    }

    public void edit(Employee employee) throws SQLException {
        String query = """
                update employee set firstname = ? , lastname = ? , nationalcode = ? , salary = ?, accessmodifier = ? where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getNationalCode());
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setString(5,String.valueOf(employee.getAccessModifier()));
        preparedStatement.setInt(6, employee.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Employee load(int id) throws SQLException {
        String query = """
                select * from employee where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Employee(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("nationalcode"),AccessModifier.valueOf(resultSet.getString("accessmodifier")));
        } else return null;
    }
}
