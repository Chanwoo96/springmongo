package com.multi.mongDB;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//서비스 역할 관련 어노테이션
@Service
public class MemoServiceImpl implements MemoServiceInterface {
	@Autowired
	MemoDAOImpl dao;
	@Override
	public void insert(MemoVO vo) {
		// TODO Auto-generated method stub
		vo.setDate(new Date());
		dao.insert(vo);
	}

	@Override
	public void delete(String _id) {
		// TODO Auto-generated method stub
		dao.delete(_id);
	}

	@Override
	public void update(MemoVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public MemoVO one(String _id) {
		// TODO Auto-generated method stub
		
		return dao.one(_id);
	}

	@Override
	public List<MemoVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
