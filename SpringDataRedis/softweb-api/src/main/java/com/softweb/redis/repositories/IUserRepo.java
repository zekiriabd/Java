package com.softweb.redis.repositories;

import com.softweb.redis.entities.UserR;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<UserR, String> {}