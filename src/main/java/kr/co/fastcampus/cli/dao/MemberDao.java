package kr.co.fastcampus.cli.dao;

import kr.co.fastcampus.cli.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

@Slf4j
public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String username, String password) throws SQLException {
//        Statement statement = DataSourceUtils.getConnection(dataSource).createStatement();
//        statement.executeUpdate("insert into member(username, password) values ('kwangmin1', '1234')");
        jdbcTemplate.update("insert into member(username, password) values (?, ?)",username,password);
    }
    public void print(){

//        try(
//                Statement statement = DataSourceUtils.getConnection(dataSource).createStatement();) {
//            ResultSet resultSet = statement.executeQuery("select id, username, password from member");
//            while (resultSet.next()){
//                //Member member = new Member(resultSet);
//                Member member = new Member("kwangmin","1234");
//                log.info(member.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        List<Member> list = jdbcTemplate.query("select id, username, password from member",
                (resultSet, i) -> new Member(resultSet));
        list.forEach(x->log.info(">> Member:"+x.getUsername()+"/"+x.getPassword()));
    }
}
