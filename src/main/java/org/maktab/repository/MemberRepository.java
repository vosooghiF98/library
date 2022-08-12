package org.maktab.repository;

import org.maktab.config.DBConfig;
import org.maktab.entity.Grade;
import org.maktab.entity.Member;
import org.maktab.util.list.MemberList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {
    public void save(Member member) throws SQLException {
        String query = """
                insert into member (firstname, lastname, nationalcode, signupdate, expiredate, grade)
                values (?,?,?,?,?,?);
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, member.getFirstName());
        preparedStatement.setString(2, member.getLastName());
        preparedStatement.setString(3,member.getNationalCode());
        preparedStatement.setDate(4,member.getSignUpDate());
        preparedStatement.setDate(5,member.getExpireDate());
        preparedStatement.setString(6, String.valueOf(member.getGrade()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public int remove(Member member) throws SQLException {
        String query = """
                delete from member where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,member.getId());
        int number = preparedStatement.executeUpdate();
        preparedStatement.close();
        return number;
    }

    public MemberList loadAll() throws SQLException {
        String query = """
                select * from member;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        MemberList memberList = new MemberList();
        while (resultSet.next()){
            Member member = new Member(resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getString("nationalcode"), Grade.valueOf(resultSet.getString("grade")));
            memberList.add(member);
        }
        resultSet.close();
        preparedStatement.close();
        return memberList;
    }

    public void edit(Member member) throws SQLException {
        String query = """
                update member set firstname = ? , lastname = ? , nationalcode = ? , expiredate = ? , grade = ? where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, member.getFirstName());
        preparedStatement.setString(2, member.getLastName());
        preparedStatement.setString(3, member.getNationalCode());
        preparedStatement.setDate(4,member.getExpireDate());
        preparedStatement.setString(5,String.valueOf(member.getGrade()));
        preparedStatement.setInt(6,member.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Member load(int id) throws SQLException {
        String query = """
                select * from member where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return new Member(resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getString("nationalcode"), Grade.valueOf(resultSet.getString("grade")));
        }else return null;
    }

    public Member load(Member member) throws SQLException {
        String query = """
                select * from member where nationalcode = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, member.getNationalCode());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return new Member(resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getString("nationalcode"), Grade.valueOf(resultSet.getString("grade")));
        }else return null;
    }
}
