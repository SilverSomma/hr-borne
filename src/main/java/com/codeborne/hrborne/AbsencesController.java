package com.codeborne.hrborne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AbsencesController {

    @Resource
    UserRepository userRepository;
    @Resource
    AbsenceRepository absenceRepository;

    @GetMapping("/names")
    public List<Name> getAllNames() {
        return userRepository.getAllNames();
    }

    @GetMapping("/absences")
    public List<AbsenceLine> getAllAbsences() {
        return absenceRepository.getAllAbsences();
    }
}
