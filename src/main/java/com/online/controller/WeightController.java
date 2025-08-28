package com.online.controller;

import com.online.model.WeightsCategory;
import com.online.model.WeightsItems;
import com.online.request.WeightCategoryRequest;
import com.online.request.WeightRequest;
import com.online.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping()
    public ResponseEntity<WeightsItems> createWeightItem(@RequestBody WeightRequest req
    ) throws Exception {
        WeightsItems item = weightService.createWeightItem(req.getShopId(),req.getName(),req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<WeightsItems> updateWeighStock(@PathVariable Long id
    ) throws Exception {
        WeightsItems item = weightService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("shop/{id}")
    public ResponseEntity< List<WeightsItems>> getShopWeights(@PathVariable Long id
    ) throws Exception {
        List<WeightsItems> item = weightService.findShopsWeights(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("shop/{id}/category")
    public ResponseEntity< List<WeightsCategory>> getShopWeightCategory(
            @PathVariable Long id
    ) throws Exception {
        List<WeightsCategory> items = weightService.findWeightCategoryByShopId(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }





}
