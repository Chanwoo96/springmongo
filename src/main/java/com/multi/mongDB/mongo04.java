package com.multi.mongDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;
public class mongo04 {

	public static void main(String[] args) {
		// insert 여러개 하기
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			// 입력할 다큐먼트 만들기
			ArrayList<Document> list = new ArrayList<Document>();
			for (int i = 4; i < 6; i++) {
				
			Document document = new Document();
			//다큐먼트에 들어갈 값 입력하기
			document.append("id", "apple"+i);
			document.append("pw", "1234");
			document.append("name", "apple"+i);
			document.append("tel", "01"+i);
			list.add(document);
			}
			//몽고 db에 하나의 document를 insert하기
			collection.insertMany(list);
			Client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
