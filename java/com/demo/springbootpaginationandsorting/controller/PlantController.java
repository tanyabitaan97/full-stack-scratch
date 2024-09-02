package com.demo.springbootpaginationandsorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootpaginationandsorting.mapper.PageToPageDTOMapper;
import com.demo.springbootpaginationandsorting.model.PageDTO;
import com.demo.springbootpaginationandsorting.model.PageSettings;
import com.demo.springbootpaginationandsorting.model.Plant;
import com.demo.springbootpaginationandsorting.model.PlantCollection;
import com.demo.springbootpaginationandsorting.repository.PlantMongoRepository;
import com.demo.springbootpaginationandsorting.repository.PlantRepository;
import com.demo.springbootpaginationandsorting.service.PlantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping("/plant")
public class PlantController {

	@Autowired
    private PlantService plantService;

	@Autowired
    private PageToPageDTOMapper<Plant> pageToPageDTOMapper;
	
	@Autowired
    private PageToPageDTOMapper<PlantController> pageToPageDTOController;
	
	@Autowired
	PlantRepository plantRepository;
	
	@Autowired
	PlantMongoRepository plantMongoRepository;



    @GetMapping("/page")
    public PageDTO<Plant> getPlantPage(PageSettings pageSettings) {
        return pageToPageDTOMapper.pageToPageDTO(plantService.getPlantPage(pageSettings));
    }
    
   @GetMapping("/getPlants")
   public PageDTO<PlantCollection> getPlantsFromMongo(PageSettings pageSettings) {
	   return pageToPageDTOController.pageToPageDTOForMongo(plantService.
			   getPlantPagination(pageSettings));  
	}
   
   
   @GetMapping("/savePlants")
   public void savePlantsFromMongo() {
	   
	   for(int i=0;i<1000;i++) {
	   PlantCollection plant = new PlantCollection();
	   plant.setFamily("Botonical"+i);
	   plant.setScientificName("PlantSci"+i);
	   plant.setName("plant"+i);
	   
	   plantMongoRepository.save(plant);
	   
	   
	   }
   
   }

    
}
