package com.aceky.reportit.web;

import java.util.List;

import com.aceky.reportit.data.models.Region;
import com.aceky.reportit.data.payloads.request.RegionsRequest;
import com.aceky.reportit.data.payloads.response.MessageResponse;
import com.aceky.reportit.service.region.RegionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/region")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegionController {
    @Autowired
    private RegionServiceImpl regionsService;

    @GetMapping("/all")
    public ResponseEntity<List<Region>> getAll() {
        List<Region> listeRegions = regionsService.getAll();
        return new ResponseEntity<>(listeRegions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody RegionsRequest regionsRequest) {
        MessageResponse messageResponse = this.regionsService.addRegion(regionsRequest);
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<Region> getById(@RequestBody RegionsRequest regionsRequest) {
        Region regions = this.regionsService.findRegionById(regionsRequest.getId());
        return new ResponseEntity<>(regions, HttpStatus.CREATED);
    }
}
