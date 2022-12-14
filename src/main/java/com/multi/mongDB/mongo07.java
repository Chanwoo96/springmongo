package com.multi.mongDB;

import com.mongodb.MongoClient;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;


import org.bson.Document;
import org.bson.conversions.Bson;
public class mongo07 {

	public static void main(String[] args) {
		//MongoDB 업데이트 기능
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			
			
			//수정하고 싶은 항목 여러개의 조건 정하기
			Document filter = new Document();
			filter.append("id", "apple3");
			filter.append("pw", "1234");
			//업데이트할 내용
			Bson update=Updates.set("name", "finalWin");
			collection.updateOne(filter,update);
			Client.close();
			System.out.println("update 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
