package com.multi.mongDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class mongo02 {

	public static void main(String[] args) {
		// insert하기
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			// 입력할 다큐먼트 만들기
			Document document = new Document();
			//다큐먼트에 들어갈 값 입력하기
			document.append("id", "apple");
			document.append("pw", "1234");
			document.append("name", "apple");
			document.append("tel", "011");
			//몽고 db에 하나의 document를 insert하기
			collection.insertOne(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
