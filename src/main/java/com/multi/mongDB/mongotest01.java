package com.multi.mongDB;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
public class mongotest01 {

	public static void main(String[] args) {
		// 지금까지 기능 확인문제 insertOne,insertMany,deleteOne
		try {
			//mongoDB연결
			MongoClient Client = new MongoClient("localhost",27017);
			//작업할 DB shop2fh 지정하기
			MongoDatabase database = Client.getDatabase("shop2");
			// 작업할 collection을 memo로 지정하기
			MongoCollection<Document> collection = database.getCollection("memo");
			// 입력할 다큐먼트 만들기
			//insertOne
			Document one = new Document();
			one.append("age", "500");
			one.append("name", "song");
			one.append("office", "busan");
			one.append("phone", "011");
			
			collection.insertOne(one);
			System.out.println("insertOne성공");

			//insertMany
			ArrayList<Document> list = new ArrayList<Document>();
			
			//document 여러개 만들어 담기
			for (int i = 1; i <4; i++) {
				
			Document document = new Document();
			//다큐먼트에 들어갈 값 입력하기
			document.append("age", "50"+i);
			document.append("name", "song"+(i+1));
			if(i==2) {
				document.append("office", "seoul");
			}else {
				document.append("office", "busan");
			}
			document.append("phone", "011");
			list.add(document);
			}
			//몽고 db에 하나의 document를 insert하기
			collection.insertMany(list);
			System.out.println("insertMany성공");
			
			//deleteOne
			Document filter = new Document();
			filter.append("age", "500");
			collection.deleteOne(filter);
			System.out.println("deleteOne성공");
			
			//updateOne
			Document filter1 = new Document();
			filter.append("age", "501");
			//업데이트할 내용
			Bson update=Updates.set("name", "songsong");
			
			
			collection.updateOne(filter1, update);
			System.out.println("updateOne성공");
			
			//updateMany
			Document filter2 = new Document();
			filter.append("office", "busan");
			//업데이트할 여러개의 내용 전달하기
			//여러개를 담을 list
			List<Bson> list1 = new ArrayList<Bson>();
			//업데이트 세부내용
			Bson update1=Updates.set("name", "songsong2");
			Bson update2=Updates.set("phone", "9999");
			//세부내용 담기
			list1.add(update1);
			list1.add(update2);
			//세부내용 Bson으로 합치기
			Bson sets=Updates.combine(list1);
			
			collection.updateMany(filter2, sets);
			System.out.println("updateMany성공");
			Client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
