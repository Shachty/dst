package dst.ass1.nosql.impl;

import com.mongodb.*;
import dst.ass1.jpa.util.Constants;
import dst.ass1.nosql.IMongoDbQuery;

import java.util.ArrayList;
import java.util.List;

public class MongoDbQuery implements IMongoDbQuery {

    private DB db;

    public MongoDbQuery(DB db) {
        this.db = db;
    }

    @Override
    public Long findFinishedByLectureId(Long id) {

        DBCollection coll = db.getCollection(Constants.COLL_LECTUREDATA);

        return (Long) coll.find(new BasicDBObject("lecture_id", id)).next().get("lecture_finished");

    }

    @Override
    public List<Long> findFinishedGt(Long time) {

        List<Long> ids = new ArrayList<>();

        DBCollection coll = db.getCollection(Constants.COLL_LECTUREDATA);

        DBCursor cursor = coll.find(new BasicDBObject("lecture_timestamp",new BasicDBObject("$lt", time)).append("lecture_id","1"));

        while(cursor.hasNext()){
            ids.add((Long) cursor.next().get("lecture_id"));
        }
        
        return ids;
    }

    @Override
    public List<DBObject> mapReduceStreaming() {
        return null;
    }
}
