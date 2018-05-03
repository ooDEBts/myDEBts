package com.DE.Bots.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.DE.Bots.core.Model.BidDetails;

public interface BidDetailsRepo extends CrudRepository<BidDetails, ObjectId> {
	List<BidDetails> findByCName(String cName);

	public BidDetails findByBiddedBy(String name);
}
