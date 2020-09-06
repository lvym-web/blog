package com.lvym.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lvym.dao.TypeRepository;
import com.lvym.pojo.Type;
import com.lvym.service.TypeService;

@Service
public class TypeServiceimppl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;
	@Override
	@Transactional
	public Type saveType(Type type) {
		return typeRepository.save(type);
	}
	@Transactional
	@Override
	public Type getType(Long id) {
		return typeRepository.findOne(id);
	}
	@Transactional
	@Override
	public Page<Type> listType(Pageable pageable) {
		return typeRepository.findAll(pageable);
	}
	@Transactional
	@Override
	public Type updateType(Long id, Type type){
	Type t=typeRepository.findOne(id);
		/*
		 * if(t==null) { throw new NotFoundException("不存在该类型"); }
		 */
	BeanUtils.copyProperties(type, t);
	
		return typeRepository.save(t);
	}
	@Transactional
	@Override
	public void deleteType(Long id) {
		typeRepository.deleteById(id);

	}
	@Override
	public Type getTypeByName(String name) {
		// TODO Auto-generated method stub
		return typeRepository.findByName(name);
	}

}
