package Softwe3.WebApiRest_JPA_MySql.Database;

import Softwe3.WebApiRest_JPA_MySql.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDataAccess extends JpaRepository<User,Integer> {

    @Query(value = "SELECT ID,LAST_NAME,FIRST_NAME FROM user where LAST_NAME= :pName",nativeQuery = true)
    List<User> GetUsersByName(@Param("pName") String name);

}
