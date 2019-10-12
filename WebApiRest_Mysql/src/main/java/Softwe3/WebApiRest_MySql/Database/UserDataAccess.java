package Softwe3.WebApiRest_MySql.Database;

import Softwe3.WebApiRest_MySql.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public class UserDataAccess {
    @Autowired
    JdbcTemplate sql;

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname")
            );
        }
    }

    public int Insert(User user) {
        return sql.update("insert into user (id, firstname, lastname) values(?, ?, ?)",
                new Object[] {user.getId(), user.getFirstName(), user.getLastName()});
    }

    public List<User> GetAllUsers() {
        return sql.query("select * from user", new UserRowMapper());
    }

    public int delUser(int id) {
        return sql.update("delete from user where id=?", new Object[] {id});
    }

    public int updateUser(User user) {
        return sql.update("update employees set firstname = ?, lastname = ? where id = ?",
                new Object[] { user.getFirstName(), user.getLastName(), user.getId() });
    }

    public List<User> callUsers(){
        return sql.query("CALL `GetAllUsers`();"  ,  new UserRowMapper());
    }

    public String CallUser(int id) {
        SimpleJdbcCall Proc = new SimpleJdbcCall(sql).withProcedureName("GetUserById");
        Map<String, Object> objResult = Proc.execute(new MapSqlParameterSource("USER_ID", id));
        return objResult.entrySet().toArray()[0].toString();
    }
}
