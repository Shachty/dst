package dst.ass1.nosql.impl;

import com.mongodb.*;
import com.mongodb.util.JSON;
import dst.ass1.jpa.dao.DAOFactory;
import dst.ass1.jpa.model.ILecture;
import dst.ass1.jpa.util.Constants;
import dst.ass1.nosql.IMongoDbDataLoader;
import dst.ass1.nosql.MongoTestData;
import org.bson.types.BSONTimestamp;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class MongoDbDataLoader implements IMongoDbDataLoader {

    private EntityManager em;

    public MongoDbDataLoader(EntityManager em) {
        this.em = em;
    }

    @Override
    public void loadData() throws Exception {

        Mongo mongo = new Mongo();
        DB db = mongo.getDB(Constants.MONGO_DB_NAME);
        DBCollection coll = db.getCollection(Constants.COLL_LECTUREDATA);

        MongoTestData mongoTestData = new MongoTestData();

        em.getTransaction().begin();

        Query query = em.createNamedQuery(Constants.Q_ALLFINISHEDLECTURES);
        List<ILecture> lectures = (List<ILecture>) query.getResultList();


        coll.ensureIndex("lecture_id");

        for(ILecture l : lectures){


            BasicDBObject dbObject =
                    new BasicDBObject("lecture_id",l.getId())
                    .append(Constants.PROP_LECTUREFINISHED, l.getLectureStreaming().getEnd().getTime())
                    .append(mongoTestData.getDataDescription(l.getId()), JSON.parse(mongoTestData.getData(l.getId())));

        coll.insert(dbObject);

        }


    }
}
