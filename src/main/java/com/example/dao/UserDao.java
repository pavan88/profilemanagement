package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserDao extends BasicDaoImpl<User> {

	@Autowired
	MongoTemplate mongoTemplate;

	public User findByUsername(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		return (User) mongoTemplate.findOne(query, User.class);

	}

}
