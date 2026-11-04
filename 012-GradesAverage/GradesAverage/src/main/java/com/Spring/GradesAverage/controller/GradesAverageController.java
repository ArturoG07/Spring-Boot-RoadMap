package com.Spring.GradesAverage.controller;

import com.Spring.GradesAverage.model.GradesDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller with the post mapping function that returns the average grade
 */
@RestController
public class GradesAverageController {

    @PostMapping("/average")
    public double calculateAverage(@RequestBody GradesDTO grades) {
        double total = grades.getGrade1() + grades.getGrade2() + grades.getGrade3();
        return Math.round((total/3) * 100.0) / 100.0;
    }

}
