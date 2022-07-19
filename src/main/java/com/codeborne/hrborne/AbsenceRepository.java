package com.codeborne.hrborne;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AbsenceRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost:1234/postgres", "user", "pass"));

    public List<AbsenceLine> getAllAbsences() {
        return jdbcTemplate.query("SELECT a.id, a.user_id, a.absence_start, a.absence_end, a.description AS absenceDescription, at.absence_type, at.description AS absenceTypeDescription FROM absences a\n" +
                "    JOIN absence_types at on at.id = a.absence_type_id", new DataClassRowMapper<>(AbsenceLine.class));
    }
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
