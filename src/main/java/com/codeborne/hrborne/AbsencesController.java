package com.codeborne.hrborne;

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
    AbsencesRepository absencesRepository;

    @GetMapping("/names")
    public List<Name> getAllNames() {
        return userRepository.getAllNames();
    }

    @PutMapping
    public void saveAbsence (Absences absences ) {
        absencesRepository.saveAbsence(absences);
    }
}
