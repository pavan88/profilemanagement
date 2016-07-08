package com.example.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.model.BasicEntity;

/**
 * @author PAVAN
 *
 */

@Repository
public abstract class BasicDaoImpl<T extends BasicEntity> {

	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean exists(T t) {
		if (findOne(t) == null)
			return false;
		else
			return true;
	}

	public String add(T t) {
		final String COLLECTION_NAME = mongoTemplate.getCollectionName(t.getClass());
		if (!mongoTemplate.collectionExists(COLLECTION_NAME)) {
			mongoTemplate.createCollection(COLLECTION_NAME);
		}
		t.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(t);
		return t.getId();
	}

	public String delete(T t) {
		final String COLLECTION_NAME = mongoTemplate.getCollectionName(t.getClass());
		if (mongoTemplate.collectionExists(COLLECTION_NAME)) {
			mongoTemplate.remove(t, COLLECTION_NAME);
		}
		
		return t.getId();
	}

	public T findOne(T t) {
		Query query = new Query();
		final String COLLECTION_NAME = mongoTemplate.getCollectionName(t.getClass());
		return (T) mongoTemplate.findOne(query, t.getClass(), COLLECTION_NAME);
	}

	public long count(Class<T> clazz) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").exists(true));
		return mongoTemplate.count(query, clazz);
	}

	public T findById(String id, Class<T> clazz) {
		return mongoTemplate.findById(id, clazz);
	}

	
}
