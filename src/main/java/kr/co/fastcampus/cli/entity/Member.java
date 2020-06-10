package kr.co.fastcampus.cli.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {
    private int id;
    @NonNull String username;
    @NonNull String password;


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