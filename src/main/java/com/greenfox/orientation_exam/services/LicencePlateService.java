package com.greenfox.orientation_exam.services;

import com.greenfox.orientation_exam.model.LicencePlates;
import com.greenfox.orientation_exam.repository.LicencePlatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LicencePlateService {
    @Autowired
    LicencePlatesRepository licencePlatesRepository;



    public List<LicencePlates> getAllLicencePlates() {
        List<LicencePlates> tempList = new ArrayList<>();
        licencePlatesRepository.findAll().forEach(tempList::add);
        return tempList;
    }
    public List<LicencePlates> search(String userinput) {
        List<LicencePlates> searchedList = new ArrayList<>();
        for (int i = 0; i < getAllLicencePlates().size(); i++) {
            if (getAllLicencePlates().get(i).getPlate().contains(userinput)) {
                searchedList.add(getAllLicencePlates().get(i));
            }
        }
        return searchedList;
    }

    public List<LicencePlates> filterPoliceCars() {
        List<LicencePlates> tampPoliceList = new ArrayList<>();
        for (int i = 0; i < getAllLicencePlates().size(); i++) {
            if (getAllLicencePlates().get(i).getPlate().substring(0,1).equals("RB")) {
                tampPoliceList.add(getAllLicencePlates().get(i));
            }
        }
        return tampPoliceList;
    }

    public List<LicencePlates> filterDiplomatCars() {
        List<LicencePlates> tampDiplomatList = new ArrayList<>();
        for (int i = 0; i < getAllLicencePlates().size(); i++) {
            if (getAllLicencePlates().get(i).getPlate().substring(0,1).equals("DT")) {
                tampDiplomatList.add(getAllLicencePlates().get(i));
            }
        }
        return tampDiplomatList;
    }

    public boolean checkIfAlphaNumeric (String input) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches() && input.length() >= 7) {
            return true;
        }
        return false;
    }

    public List<LicencePlates> filterByBrand(String brand) {
        List<LicencePlates> tampBrandList = new ArrayList<>();
        for (int i = 0; i < getAllLicencePlates().size(); i++) {
            if (getAllLicencePlates().get(i).getCar_brand().equals(brand)) {
                tampBrandList.add(getAllLicencePlates().get(i));
            }
        }
        return tampBrandList;
    }




}
