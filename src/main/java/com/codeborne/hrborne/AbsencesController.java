package com.codeborne.hrborne;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AbsencesController {

    @Resource
    UserRepository userRepository;
    @Resource
    AbsenceRepository absenceRepository;
    @Resource
    AbsencesRepository absencesRepository;

    @GetMapping("/names")
    @CrossOrigin(origins = "http://localhost:8081")
    public List<Name> getAllNames() {
        return userRepository.getAllNames();
    }

    @GetMapping("/absences")
    @CrossOrigin(origins = "http://localhost:8081")
    public List<AbsenceLine> getAllAbsences() {
        return absenceRepository.getAllAbsences();
    }

    @PutMapping
    public void saveAbsence (Absences absences ) {
        AbsencesRepository.saveAbsence(absences);
    }
}
