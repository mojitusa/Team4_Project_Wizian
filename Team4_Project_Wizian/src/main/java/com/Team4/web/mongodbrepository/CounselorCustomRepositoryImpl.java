package com.Team4.web.mongodbrepository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.Team4.web.mongodbclass.CounselorMongo;

@Repository
public class CounselorCustomRepositoryImpl implements CounselorCustomRepository {
    
    private final MongoTemplate mongoTemplate;

    public CounselorCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public CounselorMongo findByUsersUserNo(String userNo) {
        Aggregation aggregation = newAggregation(
                match(Criteria.where("users.user_no").is(userNo))
        );
        
        return mongoTemplate.aggregate(aggregation, "counselor", CounselorMongo.class).getUniqueMappedResult();
    }

}

