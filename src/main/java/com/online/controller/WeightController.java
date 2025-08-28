package com.online.controller;

import com.online.model.WeightsCategory;
import com.online.repository.WeightItemRepository;
import com.online.request.WeightCategoryRequest;
import com.online.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/weights")
public class WeightController {

    @Autowired
   private WeightService weightService;

    @PostMapping("/category")
    public ResponseEntity<WeightsCategory> createWeightCategory(@RequestBody WeightCategoryRequest req
                                                                ) throws Exception {
        WeightsCategory item = weightService.createWeightCategory(req.getName(),req.getShopId());
         return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

}
