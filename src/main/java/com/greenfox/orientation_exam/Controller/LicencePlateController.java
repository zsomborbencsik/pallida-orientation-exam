package com.greenfox.orientation_exam.Controller;

import com.greenfox.orientation_exam.model.LicencePlates;
import com.greenfox.orientation_exam.repository.LicencePlatesRepository;
import com.greenfox.orientation_exam.services.LicencePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LicencePlateController {

    String userinput;

    @Autowired
    LicencePlatesRepository licencePlatesRepository;

    @Autowired
    LicencePlateService licencePlateService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("databse",licencePlateService.getAllLicencePlates());
        model.addAttribute("searchedPlate", licencePlateService.search(userinput));
        return "index";
    }

    @GetMapping("/search/{userinputpath}")
    public String search(@RequestParam(value = "userinput") String userinput,Model model, @PathVariable(value = "userinputpath") String userinputpath) {
        model.addAttribute("userinput", userinput);
        if (licencePlateService.checkIfAlphaNumeric(userinput)) {
        this.userinput = userinput;
        }
        else {
            this.userinput = "error";
        }
        return "redirect:/";
    }

    @GetMapping("/filterPoliceCars")
    public String filterPoliceCars(Model model) {
        model.addAttribute("policeCars",licencePlateService.filterPoliceCars());
        return "redicert:/";
    }

    @GetMapping("/filterDiplomatCars")
    public String filterDiplomatCars(Model model) {
        model.addAttribute("diplomatCars",licencePlateService.filterDiplomatCars());
        return "redicert:/";
    }

    @GetMapping("/search/{brand}")
    public String getBrand(@PathVariable String brand,Model model) {
        model.addAttribute("brand",licencePlateService.filterByBrand(brand));
        return "brands";
    }
}
