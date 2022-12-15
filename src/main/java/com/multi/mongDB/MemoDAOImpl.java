package com.multi.mongDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
//저장소 관련 싱글톤 생선 어노테이션
@Repository
public class MemoDAOImpl implements MemoDAOInterface {
	
	@Autowired
	MongoTemplate mongo;
	@Override
	public void insert(MemoVO vo) {
		// insert(데이터vo, 컬렉션명)
		//vo에 name변수, getName() --> memo 컬렉션의 키name: 값getName()
		//Bson객체(JSON)로 만들어 넣는다.
		mongo.insert(vo,"memo");

	}

	@Override
	public void delete(String _id) {
		// delete 할 조건을 저장하는 쿼리를 만들어서 삭제할 대상을 지정해 삭제한다.
		//조건에 해당하는 키를 지정하는 객체 Criteria("키값")
//		Criteria criteria= new Criteria("-id");
//		Query query = new Query(criteria.is(_id));
		Query query= new Query(new Criteria("_id").is(_id));
		//sql문:delete from memo where (_id = ?) -->new Criteria("_id").is(_id)
		mongo.remove(query, "memo");
	}

	@Override
	public void update(MemoVO vo) {
		// 업데이트 조건 Query(Criteria)
		Query query= new Query(new Criteria("_id").is(vo.get_id()));
		
		// 변경할 값: Update 객체
		Update update = new Update();
		//수정할 내용 넣어주기
		update.set("content",vo.getContent());
		System.out.println("변경할 값>>"+update);
		mongo.updateMulti(query, update,MemoVO.class,"memo");
		System.out.println("변경 후 >>"+vo);
	}

	@Override
	public MemoVO one(String _id) {
		return mongo.findById(_id, MemoVO.class,"memo");
	}

	@Override
	public List<MemoVO> list() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "date"));
		return mongo.find(query, MemoVO.class,"memo");
	}

}
