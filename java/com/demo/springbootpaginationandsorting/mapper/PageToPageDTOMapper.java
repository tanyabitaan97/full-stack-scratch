package com.demo.springbootpaginationandsorting.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.demo.springbootpaginationandsorting.model.PageDTO;
import com.demo.springbootpaginationandsorting.model.PlantCollection;

@Component
public class PageToPageDTOMapper<T> {

    public PageDTO<T> pageToPageDTO(Page<T> page) {
        PageDTO<T> pageDTO = new PageDTO(page);
        pageDTO.setContent(page.getContent());
        pageDTO.setTotalElements(page.getTotalElements());

        return pageDTO;
    }
    
    public PageDTO<PlantCollection> pageToPageDTOForMongo(Page<PlantCollection> page) {
        PageDTO<PlantCollection> pageDTO = new PageDTO(page);
        pageDTO.setContent(page.getContent());
        pageDTO.setTotalElements(page.getTotalElements());

        return pageDTO;
    }

    
    
}
