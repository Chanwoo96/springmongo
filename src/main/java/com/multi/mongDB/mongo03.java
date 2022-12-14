package com.multi.mongDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Scanner;

import org.bson.Document;
public class mongo03 {

	public static void main(String[] args) {
		// 입력해서 document insert하기
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("id 입력 >> ");
			String id=sc.next();
			System.out.print("pw 입력 >> ");
			String pw=sc.next();
			System.out.print("name 입력 >> ");
			String name=sc.next();
			System.out.print("tel 입력 >> ");
			String tel=sc.next();
			
			Document document = new Document();
			
			document.append("id", id);
			document.append("pw", pw);
			document.append("name", name);
			document.append("tel", tel);
			
			collection.insertOne(document);
			sc.close();
			Client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
