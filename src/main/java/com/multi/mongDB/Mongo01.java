package com.multi.mongDB;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
public class Mongo01 {

	public static void main(String[] args) {
		//원하는 collection에서 find 하기
		/*
		 * Requires the MongoDB Java Driver.
		 * https://mongodb.github.io/mongo-java-driver
		 */
		// 검색할 조건과 키밸류
		Bson filter = eq("name", "Garry");
		// mongoDB연결
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/"));
		// 검색할 db 지정
		MongoDatabase database = mongoClient.getDatabase("shop2");
		// db에서 사용할 collection 지정
		MongoCollection<Document> collection = database.getCollection("memo");
		// collection에서 검색할 값 필터 적용 후 찾기
		FindIterable<Document> result = collection.find(filter);
		// 검색 결과를 하나 나타니기
		System.out.println(result.first().getString("office"));
		System.out.println(result.first().getString("name"));
		System.out.println(result.first().getInteger("age"));
		System.out.println(result.first().getString("phone"));
	}

}
