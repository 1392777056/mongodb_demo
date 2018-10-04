import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/10/4 20:48
 */
public class MongoTest {

    public static void main(String[] args) {

        //创建连接
        MongoClient client = new MongoClient("192.168.52.170");
        //连接数据库
        MongoDatabase database = client.getDatabase("spitdb");
        //获取集合（表）
        MongoCollection<Document> spit = database.getCollection("spit");

        //还可以加一些过滤的条件，想查什么就查什么
        //BasicDBObject bson = BasicDBObject.parse("{'nickname':/凯/}");

        //查询记录获取文档集合
        //FindIterable<Document> documents = spit.find(bson);
        FindIterable<Document> documents = spit.find();
        //遍历，获取内容
        for (Document document : documents) {
            System.out.println(document);
           /* System.out.println("内容："+ document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));*/
        }

    }

}
