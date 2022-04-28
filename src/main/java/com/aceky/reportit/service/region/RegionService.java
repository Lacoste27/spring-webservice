package com.aceky.reportit.service.region;

import java.util.List;

import com.aceky.reportit.data.models.Region;
import com.aceky.reportit.data.payloads.request.RegionsRequest;
import com.aceky.reportit.data.payloads.response.MessageResponse;

import org.springframework.stereotype.Component;

@Component
public interface RegionService {
    MessageResponse addRegion(RegionsRequest regionRequest);

    Region findRegionById(Integer id);

    List<Region> getAll();
}
