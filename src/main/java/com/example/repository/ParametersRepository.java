package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.model.ParametersSnapshot;


@Repository
public interface ParametersRepository extends MongoRepository<ParametersSnapshot, String>{

	ParametersSnapshot findByMeanStrikePrice(String string);


	ParametersSnapshot findTop1ByFlagOrderBySnapDateDesc(String string);

	ParametersSnapshot findByFlag(String string);


	ParametersSnapshot findTop1ByFlagAndSnapDateOrderBySnapDateDesc(String string, String snapDate);
	
	

	
}
