package com.mitrais.registerformdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mitrais.registerformdemo.model.User;
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByMobileNumber(String mobileNumber);
//    User findById(int uid);
}
