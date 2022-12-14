package com.multi.mongDB;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.bson.Document;
public class mongo10 {

	public static void main(String[] args) {
		//삭제기능
		try {
			MongoClient Client = new MongoClient("localhost",27017);
			MongoDatabase database = Client.getDatabase("shop2");
			
			MongoCollection<Document> collection = database.getCollection("member");
			
			Document filter = new Document("name",1);
//			Document filter = new Document();
//			filter.append("id", "apple");
			
			FindIterable<Document>result=collection.find().sort(filter);
			//iterate : 반복하다.
			//rs.next()의 값을 반복해서 꺼냈음 커서를 이용
			//반복해서 꺼낼 수 있는 타입의 객체 FindIterable
//			System.out.println(result.first().get("name"));
			for (Document doc : result) {
				System.out.print(doc.get("id")+"\t");
				System.out.print(doc.get("pw")+"\t");
				System.out.print(doc.get("name")+"\t");
				System.out.print(doc.get("tel")+"\n");
			}
			System.out.println("find 성공");
			//객체를 저장할 때 큰 객체를 잡아주는게 유지보수에서 좋다.
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id",result.first().get("id"));
			map.put("pw",result.first().get("pw"));
			map.put("name",result.first().get("name"));
			map.put("tel",result.first().get("tel"));
			System.out.println(map);
			List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
			for (Document document : result) {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("id",document.get("id"));
				map1.put("pw",document.get("pw"));
				map1.put("name",document.get("name"));
				map1.put("tel",document.get("tel"));
				list.add(map1);
			}
			for (Map<String, Object> maps : list) {
				System.out.println(maps);
			}
			System.out.println(list);
			Client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
