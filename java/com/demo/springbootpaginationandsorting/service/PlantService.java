package com.demo.springbootpaginationandsorting.service;

import com.demo.springbootpaginationandsorting.model.PageSettings;
import com.demo.springbootpaginationandsorting.model.Plant;
import com.demo.springbootpaginationandsorting.model.PlantCollection;
import com.demo.springbootpaginationandsorting.repository.PlantMongoRepository;
import com.demo.springbootpaginationandsorting.repository.PlantRepository;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlantService {

	@Autowired
    private PlantRepository plantRepository;
	
	@Autowired
	private PlantMongoRepository plantMongoRepo;

    public PlantService(
            PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Page<Plant> getPlantPage(@NonNull PageSettings pageSetting) {
        new PageSettings();
        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(),
        		pageSetting.getElementPerPage(), plantSort);

        return plantRepository.findAll(plantPage);
    }
    
    public Page<PlantCollection> getPlantPagination(@NonNull PageSettings pageSetting) {
        new PageSettings();
        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(),
        		pageSetting.getElementPerPage(), plantSort);

        return plantMongoRepo.findAll(plantPage);
    }
    

    
    
}
