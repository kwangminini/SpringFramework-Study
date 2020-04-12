package kr.co.fastcampus.cli;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    private int id;
    private String username;
    private String password;


    public Member(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
