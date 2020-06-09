//package kr.co.fastcampus.cli;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.sql.DataSource;
//import java.sql.*;
//
//
//@Slf4j
//public class Dao {
//    private DataSource dataSource;
//
//    public Dao(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Transactional
//    public void insert() throws SQLException {
//        Statement statement = dataSource.getConnection().createStatement();
//        statement.executeUpdate("insert into member(username, password) values ('kwangmin1', '1234')");
//
//    }
//    public void print(){
//
//        try(
//            Statement statement = dataSource.getConnection().createStatement();) {
//            ResultSet resultSet = statement.executeQuery("select id, username, password from member");
//            while (resultSet.next()){
//                //Member member = new Member(resultSet);
//                Member member = new Member("kwangmin","1234");
//                log.info(member.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
