package com.cuisineratingsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cuisineratingsystem.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>
{
	@Query("select u from User u where u.userName = :userName")
	User findByUserName(@Param("userName")String userName);
}
