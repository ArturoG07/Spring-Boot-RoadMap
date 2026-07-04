package com.Spring.hospital.controller;

import com.Spring.hospital.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller for the Hospital application
 */
@RestController
public class HospitalController {

    /**
     * Get endpoint that returns a list of patients
     * @return All patients
     */
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> getAllPatients() {
        return getPatients();
    }

    /**
     * Get endpoint that returns under 18 patients
     * @return list with all under 18 patients
     */
    @GetMapping("/patients/under18")
    @ResponseBody
    public List<Patient> getUnder18Patients() {
        List<Patient> patients = getAllPatients();
        List<Patient> cleanPatients = new ArrayList<>();
        for (Patient patient : patients) {
            if ((Period.between((patient.getBirthdate()), LocalDate.now())).getYears() < 18) {
                cleanPatients.add(patient);
            }
        }
        return cleanPatients;
    }

    /**
     * Get endpoint that returns a specific patient
     * @param id ID of the patient
     * @return The found patient, or a default patient if not found
     */
    @GetMapping("/patient")
    @ResponseBody
    public Patient getPatient(@RequestParam int id) {
        List<Patient> patients = getAllPatients();
        Patient p;
        p = new Patient (0, "No patient found", null);
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                p = patient;
            }
        }
        return p;
    }

    /**
     * Post endpoint that prints a new patient
     * @param pt Patient we want to register
     */
    @PostMapping("patient")
    public void newPatient(@RequestBody Patient pt) {
        System.out.println("New Patient, Id: " + pt.getId() + " name: " + pt.getName() + " birthdate: " + pt.getBirthdate());
    }

    /**
     * Generates a list of patients stored in an ArrayList
     * @return list of patients
     */
    private List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "Arturo", LocalDate.of(2007, 12, 7)));
        patients.add(new Patient(2, "Andrew", LocalDate.of(2000, 9, 17)));
        patients.add(new Patient(3, "Torvalds", LocalDate.of(1966, 2, 2)));
        patients.add(new Patient(4, "Tom", LocalDate.of(2018, 7, 3)));

        return patients;
    }
}
