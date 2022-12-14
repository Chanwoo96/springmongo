package com.multi.mongDB;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import java.util.Scanner;

import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;
public class mongo06 {

	public static void main(String[] args) {
		//MongoDB 업데이트 기능
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			
			
			//수정하고 싶은 항목 조건 정하기
			Document filter = new Document();
			filter.append("id", "apple2");
			
			//업데이트할 내용
			Bson update=Updates.set("name", "winwinwin");
			
			
			collection.updateOne(filter, update);
			
			Client.close();
			System.out.println("update 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
