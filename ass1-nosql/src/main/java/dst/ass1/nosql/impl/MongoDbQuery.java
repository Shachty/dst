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

        return (Long) coll.find(new BasicDBObject("lecture_id", id)).next().get(Constants.PROP_LECTUREFINISHED);

    }

    @Override
    public List<Long> findFinishedGt(Long time) {

        List<Long> ids = new ArrayList<>();

        DBCollection coll = db.getCollection(Constants.COLL_LECTUREDATA);

        DBCursor cursor = coll.find(new BasicDBObject(Constants.PROP_LECTUREFINISHED, new BasicDBObject("$gt", time))
                , new BasicDBObject("lecture_id", "1"));

        while(cursor.hasNext()){
            ids.add((Long) cursor.next().get("lecture_id"));
        }
        
        return ids;
    }

    @Override
    public List<DBObject> mapReduceStreaming() {

        DBCollection coll = db.getCollection(Constants.COLL_LECTUREDATA);

        String map = "function map() {" +
                "var criteria = '';" +
                "if('matrix' in this){" +
                "criteria = 'matrix';" +
                "}"+
                "if('logs' in this){" +
                "criteria = 'logs';" +
                "}"+
                "if('alignment_block' in this){" +
                "criteria = 'alignment_block';" +
                "}"+
                "emit(criteria,1);"+
                "}";
        String reduce = "function (key, values) {" +
                "    return values.length; " +
                "}";

        MapReduceCommand cmd = new MapReduceCommand(coll, map, reduce, null, MapReduceCommand.OutputType.INLINE, null);

        MapReduceOutput out = coll.mapReduce(cmd);


        List<DBObject> dbObjects = new ArrayList<>();

        for(DBObject obj : out.results()){
            dbObjects.add(obj);
        }

        return dbObjects;


    }
}
