package com.aceky.reportit.service.region;

import java.util.List;

import com.aceky.reportit.data.models.Region;
import com.aceky.reportit.data.payloads.request.RegionsRequest;
import com.aceky.reportit.data.payloads.response.MessageResponse;
import com.aceky.reportit.data.repositories.RegionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionsRepository;

    @Override
    public MessageResponse addRegion(RegionsRequest regionRequest) {
        Region regions = new Region();
        regions.setName(regionRequest.getName());
        this.regionsRepository.save(regions);
        return new MessageResponse("Regions ajouté");
    }

    @Override
    public Region findRegionById(Integer id) {
        return regionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Region not found"));
    }

    @Override
    public List<Region> getAll() {
        return regionsRepository.findAll();
    }

}