package com.greenfox.orientation_exam.Controller;

import com.greenfox.orientation_exam.services.LicencePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenceRestController {
    @Autowired
    LicencePlateService licencePlateService;

    @GetMapping("/api/search/{brand}")
    public Object getBrand(@PathVariable String brand) {
        return licencePlateService.filterByBrand(brand);
    }


}
