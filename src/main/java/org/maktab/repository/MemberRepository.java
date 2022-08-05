package org.maktab.repository;

import org.maktab.config.DBConfig;
import org.maktab.entity.Member;
import org.maktab.interfaces.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberRepository implements Repository {

    @Override
    public void save(Object o) throws SQLException {
        Member member = (Member) o;
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
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public Object[] load() {
        return new Object[0];
    }

    @Override
    public void edit(Object o) {

    }

    @Override
    public Object load(int id) {
        return null;
    }
}
