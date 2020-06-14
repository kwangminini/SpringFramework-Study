package kr.co.fastcampus.web.service;

import kr.co.fastcampus.cli.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@AllArgsConstructor
public class MemberService {
    private MemberDao memberDao;

    @Transactional
    public void insert(String username, String password) {
        //비지니스 로직
        memberDao.insert(username, password);
    }
    public void print() {
        memberDao.print();
    }
}
