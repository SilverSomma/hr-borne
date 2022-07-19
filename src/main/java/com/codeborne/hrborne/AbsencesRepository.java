package com.codeborne.hrborne;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class AbsencesRepository {

    public static void saveAbsence(Absences absences) {

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(new DriverManagerDataSource
                ("jdbc:postgresql://localhost:1234/postgres", "user", "pass"));

        jdbcTemplate.update("INSERT INTO absences(id, user_id, absence_type_id, absence_start, absence_end, description) " +
                "VALUES (:id, :userId, :absenceTypeId, :absenceStart, " +
                ":absenceEnd, :description); COMMIT;", Map.of(
                "id", UUID.randomUUID(),
                "userId", absences.getUserId(),
                "absenceTypeId", absences.getAbsenceTypeId(),
                "absenceStart", absences.getAbsenceStart(),
                "absenceEnd", absences.getAbsenceEnd(),
                "description", absences.getDescription()
        ));
    }
}
