package com.DE.Bots.core.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class BaseModel2 {
	@Id
    private ObjectId id;

	int ronitghd;

	private int aaaaaaaaaaaaa;
>>>>>>> branch 'master' of https://ronitviper@review.gerrithub.io/a/ooDEBts/myDEBts
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
