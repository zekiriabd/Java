package com.softweb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao extends JpaRepository<UserDao,Integer> {

    @Query(value = "SELECT ID,LAST_NAME,FIRST_NAME FROM user where LAST_NAME= :pName",nativeQuery = true)
    List<UserDao> GetUsersByName(@Param("pName") String name);

}
