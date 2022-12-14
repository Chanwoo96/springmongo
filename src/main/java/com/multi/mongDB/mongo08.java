package com.multi.mongDB;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;
public class mongo08 {

	public static void main(String[] args) {
		//MongoDB 업데이트 기능
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			
			
			//수정하고 싶은 항목 조건 정하기
			Document filter = new Document();
			filter.append("id", "apple4");
			//업데이트할 여러개의 내용 전달하기
			//여러개를 담을 list
			List<Bson> list = new ArrayList<Bson>();
			//업데이트 세부내용
			Bson update=Updates.set("name", "happy");
			Bson update2=Updates.set("tel", "5555");
			//세부내용 담기
			list.add(update);
			list.add(update2);
			//세부내용 Bson으로 합치기
			Bson sets=Updates.combine(list);
			collection.updateOne(filter, sets);
			Client.close();
			System.out.println("update 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
