package com.multi.mongDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Scanner;

import org.bson.Document;
public class mongo05 {

	public static void main(String[] args) {
		//삭제기능
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			
			
			Document filter = new Document();
			filter.append("id", "apple");
			
			
			collection.deleteOne(filter);
		
			Client.close();
			System.out.println("delete 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
