package com.wany.purplespider.dao;

import com.wany.purplespider.bean.ParadiseTeleplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class ParadiseTeleplayDao {

    @Autowired
    private MongoTemplate mongoTemplate;

//    public ParadiseTeleplayDao() {
//        mongoTemplate = new MongoTemplate();
//    }

    public void saveParadiseTeleplay(ParadiseTeleplay paradiseTeleplay) {
        mongoTemplate.save(paradiseTeleplay);
    }

}
