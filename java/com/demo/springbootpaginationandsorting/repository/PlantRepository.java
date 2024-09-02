package com.demo.springbootpaginationandsorting.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.springbootpaginationandsorting.model.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {

	@Query(value="select * from plant",nativeQuery=true)
	Page<Plant> findAll(Pageable plantPage);
}
