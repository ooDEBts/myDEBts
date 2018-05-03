package com.DE.Bots.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.DE.Bots.core.Model.User;

public interface UserRepo extends CrudRepository<User, ObjectId> {
	public List<User> findByName(String name);

	public User findByContact(String contact);
}
