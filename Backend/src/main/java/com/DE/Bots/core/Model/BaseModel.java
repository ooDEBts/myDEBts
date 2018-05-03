package com.DE.Bots.core.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class BaseModel {
	@Id
    private ObjectId id;
   
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
