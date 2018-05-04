package com.DE.Bots.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.DE.Bots.core.Model.Product;

public interface ProductRepo extends CrudRepository<Product, ObjectId> {
	public List<Product> findByName(String pName);
}
