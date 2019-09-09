package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.model.ParametersSnapshot;


@Repository
public interface ParametersRepository extends MongoRepository<ParametersSnapshot, String>{

	ParametersSnapshot findByMeanStrikePrice(String string);


	ParametersSnapshot findTop1ByFlagOrderBySnapDateDesc(String string);

	List<ParametersSnapshot> findByFlagAndSnapDate(String flag, String snapdate);
	List<ParametersSnapshot> findByFlag(String flag);
	List<ParametersSnapshot> findByFlagAndSnapDateAndIndex(String flag, String snapdate, String index);
	ParametersSnapshot findTop1ByFlagAndSnapDateOrderBySnapDateDesc(String string, String snapDate);

	ParametersSnapshot findTop1ByFlagAndSnapDateAndIndexOrderBySnapDateDesc(String flag, String snapDate, String index);

	ParametersSnapshot findByFlagAndSnapDateOrderBySnapDateDesc(String flag, String snapDate);
	
	

	
}
