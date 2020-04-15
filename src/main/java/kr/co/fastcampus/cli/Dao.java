package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;


@Slf4j
public class Dao {
    public void run(){
        String url = "jdbc:h2:mem:test;MODE=MySQL;";
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(url,"sa","");
            Statement statement = connection.createStatement();) {


            connection.setAutoCommit(false);

            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");

            try {
                statement.executeUpdate("insert into member(username, password) values ('kwangmin', '1234')");
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }


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
