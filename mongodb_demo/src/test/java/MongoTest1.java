import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/10/4 20:48
 */
public class MongoTest1 {

    public static void main(String[] args) {

        //创建连接
        MongoClient client = new MongoClient("192.168.52.170");
        //连接数据库
        MongoDatabase database = client.getDatabase("spitdb");
        //获取集合（表）
        MongoCollection<Document> spit = database.getCollection("spit");

        //也可以用map
        Map<String, Object> map = new HashMap<String, Object>();
        //往里面存东西
        map.put("_id","456");
        map.put("content","php真是个好东西好学");
        map.put("visit","522");

        //获取document对象
        Document document = new Document(map);
       /* document.put("_id","123");
        document.put("content","java真是个好东西好学");
        document.put("visit","155");*/

        //添加内容
        spit.insertOne(document);


    }

}
