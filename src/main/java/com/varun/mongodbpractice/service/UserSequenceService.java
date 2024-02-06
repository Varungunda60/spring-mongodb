package com.varun.mongodbpractice.service;

import com.varun.mongodbpractice.entity.UserSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class UserSequenceService {
    @Autowired
    MongoOperations mongoOperations;

    public long getNextValue() {
        Query query = new Query(Criteria.where("id").is("database_seq"));
        Update update = new Update().inc("seq", 1);
        UserSequence counter = mongoOperations
                .findAndModify(query,
                        update,
                        FindAndModifyOptions.options().returnNew(true).upsert(true),
                        UserSequence.class);
        return counter.getSeq();
    }
}
