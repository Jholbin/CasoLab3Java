package com.example.cibertec.CL3.CasoLab3.repositories;

import com.example.cibertec.CL3.CasoLab3.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    
    Optional<User> findByUsername(String username);

    Optional<User> getByUsername(String username);
    Optional<User> queryByUsername(String username);
    Optional<User> findByUsernameContains(String username);

    @Query("select u from User u where u.username = :username")
    Optional<User> buscarPorNombre(String username);

}
