package com.davidhenriquez.rehabilicop.listas.organo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;

@Service
public class OrganoServiceImpl implements OrganoService {

	@Autowired
	private OrganoRepository organoRepository;
	
	public List<Organo> findAll(){
		return organoRepository.findAll();
	}
	
	public Organo findById(UUID idOrgano){
		return organoRepository.findOne(idOrgano);
	}
	
	public Organo create(Organo organo) throws ValidationException {
		return organoRepository.save(organo);		
	}
	
	public Organo update(Organo organo) throws ValidationException {
		return organoRepository.save(organo);		
	}

	@Transactional
	public void delete(UUID idOrgano) throws ValidationException {
		organoRepository.delete(idOrgano);		
	}    
}
