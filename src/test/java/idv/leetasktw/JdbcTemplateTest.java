package idv.leetasktw;

import idv.leetasktw.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into member(username, password, balance) values (?, ?, ?)";
        int count = jdbcTemplate.update(sql, "andy", "123456", 1000);
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        String sql = "delete from member where id = ?";
        int count = jdbcTemplate.update(sql, 4);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        String sql = "update member set username = ? where id = ?";
        int count = jdbcTemplate.update(sql, "tom", 3);
        System.out.println(count);
    }

    @Test
    public void testSelect() {
        String sql = "select * from member";
        List<Member> members = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));
        System.out.println(members);
    }

    @Test
    public void testSelectCount() {
        String sql = "select count(1) from member";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
