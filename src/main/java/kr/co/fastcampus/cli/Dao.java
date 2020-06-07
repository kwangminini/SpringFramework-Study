package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;


@Slf4j
public class Dao {
    private Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    public void insert() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into member(username, password) values ('kwangmin1', '1234')");

    }
    public void print(){

        try(
            Statement statement = connection.createStatement();) {

            ResultSet resultSet = statement.executeQuery("select id, username, password from member");
            while (resultSet.next()){
                //Member member = new Member(resultSet);
                Member member = new Member("kwangmin","1234");
                log.info(member.toString());
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
