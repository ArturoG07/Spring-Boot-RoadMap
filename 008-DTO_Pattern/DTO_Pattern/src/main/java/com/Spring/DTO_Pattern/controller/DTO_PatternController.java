package com.Spring.DTO_Pattern.controller;

import com.Spring.DTO_Pattern.model.Guest;
import com.Spring.DTO_Pattern.model.Property;
import com.Spring.DTO_Pattern.model.PropertyDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for DTO pattern application
 */
@RestController
public class DTO_PatternController {
    /**
     * Returns an example DTO with data from the guest and data from the property
     * @param id ID of the property (now used as the data is simulated)
     * @return DTO with some data from the gust and some data from the property
     */
    @GetMapping("/property/{id}")
    public PropertyDTO getProperty(@PathVariable int id) {
        Property pro = new Property(1, "3828 Piermont Drive", 83.2, 499.99);
        Guest g = new Guest(1, "Walter White", "10/02/2026-15/02/2026", 1);

        PropertyDTO property = new PropertyDTO();
        //Assign property data
        property.setProperty_id(pro.getId());
        property.setAddress(pro.getAddress());
        //Assign guest data
        property.setGuest_id(g.getId());
        property.setGuest_name(g.getName());

        return property;
    }
}
