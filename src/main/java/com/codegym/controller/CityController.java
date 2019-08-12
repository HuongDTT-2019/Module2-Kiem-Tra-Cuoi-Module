package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @ModelAttribute(name = "country")
    public Page<Country> countries(Pageable pageable){
       return countryService.findAll(pageable);
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView createCity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        modelAndView.addObject("message","Created new city");
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView listCity(@PageableDefault(5) Pageable pageable) {
        Page<City> cities = cityService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;
    }
    @GetMapping("/view-city/{id}")
    public ModelAndView viewCity(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/detail");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView editCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Updated city");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/error404");
        return modelAndView;
    }

    @PostMapping("/delete-city")
    public String deleteForm(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:/";
    }

}
