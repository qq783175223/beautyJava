package com.xzj.sjt.dao.impl;

import com.xzj.sjt.dao.IUserDAO;
import com.xzj.sjt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/26.
 */


@Repository
public class UserDAO1 implements IUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        String sql = "insert into user values(?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getUsername(),
                user.getPassword());
    }

    public void deleteUser(int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);

    }

    public void updateUser(User user) {
        String sql = "update user set username=?,password=? where id=?";
        jdbcTemplate.update(sql, user.getUsername(),
                user.getPassword(), user.getId());
    }

    public String searchUserName(int id) {// 简单查询，按照ID查询，返回字符串
        String sql = "select username from user where id=?";
        // 返回类型为String(String.class)
        return jdbcTemplate.queryForObject(sql, String.class, id);

    }

    public List<User> findAll() {// 复杂查询返回List集合
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.query(sql, rowMapper);

    }

    public User searchUser(int id) {
        String sql="select * from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

}
