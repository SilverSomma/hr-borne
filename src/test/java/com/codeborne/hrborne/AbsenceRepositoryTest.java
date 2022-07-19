package com.codeborne.hrborne;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.sql.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AbsenceRepositoryTest {

    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(new DriverManagerDataSource
            ("jdbc:postgresql://localhost:1234/postgres", "user", "pass"));

    JdbcTemplate jdbc = new JdbcTemplate(new DriverManagerDataSource
            ("jdbc:postgresql://localhost:1234/postgres", "user", "pass"));


    @Test
    void saveAbsenceTest() {
        UUID absenceId = UUID.randomUUID();
        Date dateStart = Date.valueOf("2012-02-14");
        Date dateEnd = Date.valueOf("2018-07-19");
        Absences absence = new Absences(absenceId, UUID.fromString("3488884c-120b-4542-8179-4d0c7194f24c"),
                UUID.fromString("1d43f346-1876-4686-8d0c-6dc486066c5e"), dateStart, dateEnd,
                "this is very important line");
        int rowsNumberBefore = jdbc.queryForObject("SELECT COUNT(*) FROM absences", Integer.class);
        AbsenceRepository.saveAbsence(absence);
        int rowsNumberAfter= jdbc.queryForObject("SELECT COUNT(*) FROM absences", Integer.class);
        assertEquals(rowsNumberBefore+1, rowsNumberAfter);
    }

}