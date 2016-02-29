package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ModelDataDao;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.report.send.DATA3A;
import com.platform.report.send.DATA3B;
import com.platform.report.send.DATA5A;
import com.platform.report.send.DATA5B;
import com.platform.report.send.DATA7;
import com.platform.report.send.DATA8;
import com.platform.service.ModelDataService;

@Service
public class ModelDataServiceImpl implements ModelDataService{
	@Autowired
	private ModelDataDao modelDataDao;

	@Override
	public int insertData3A(DATA3A data) {
		return modelDataDao.insertData3A(data);
	}

	@Override
	public int insertData1(DATA1 data) {
		return modelDataDao.insertData1(data);
	}

	@Override
	public int insertData1B(DATA1 data) {
		return modelDataDao.insertData1B(data);
	}

	@Override
	public int insertData2(DATA2 data) {
		return modelDataDao.insertData2(data);
	}

	@Override
	public int insertData3B(DATA3B data) {
		return modelDataDao.insertData3B(data);
	}

	@Override
	public int insertData5A(DATA5A data) {
		return modelDataDao.insertData5A(data);
	}

	@Override
	public int insertData5B(DATA5B data) {
		return modelDataDao.insertData5B(data);
	}

	@Override
	public int insertData7(DATA7 data) {
		return modelDataDao.insertData7(data);
	}

	@Override
	public int insertData8(DATA8 data) {
		return modelDataDao.insertData8(data);
	}
	
	
	public int insertFactory(String dataType,Object data){
		if(dataType.equals("1")){
			return this.insertData1((DATA1)data);
		}
		
		if(dataType.equals("2")){
			return this.insertData2((DATA2)data);
		}
		
		if(dataType.equals("3A")){
			return this.insertData3A((DATA3A)data);
		}
		
		if(dataType.equals("3B")){
			return this.insertData3B((DATA3B)data);
		}
		
		if(dataType.equals("5A")){
			return this.insertData5A((DATA5A)data);
		}
		
		if(dataType.equals("5B")){
			return this.insertData5B((DATA5B)data);
		}
		
		if(dataType.equals("7")){
			return this.insertData7((DATA7)data);
		}
		
		if(dataType.equals("8")){
			return this.insertData8((DATA8)data);
		}
		
		//mybatis sql 执行成功返回1 不成功返回0 无对应方法返回2
		return 2;
	}

	@Override
	public int findMaxId() {
		return modelDataDao.findMaxId();
	}
	
}
