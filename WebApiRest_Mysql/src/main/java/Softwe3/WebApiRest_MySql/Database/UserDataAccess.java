package Softwe3.WebApiRest_MySql.Database;

import Softwe3.WebApiRest_MySql.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDataAccess {
    @Autowired
    JdbcTemplate sql;

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"));
            return user;
        }
    }


    public int Insert(User user) {
        return sql.update("insert into user (id, firstname, lastname) " + "values(?, ?, ?)",
                new Object[] {user.getId(), user.getFirstName(), user.getLastName()});
    }

    public List<User> GetAllUsers() {
        return sql.query("select * from user", new UserRowMapper());
    }

}
