package com.codeborne.hrborne;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class AbsencesRepository {

//    public static void main(String[] args) {
//        AbsenceLine absenceLine = new AbsenceLine(UUID.fromString("3488884c-120b-4542-8179-4d0c7194f24c"), "5e536974-54be-45fa-845f-33f38be7023a", Date.valueOf("2022-06-01"), Date.valueOf("2022-06-10"),"this is first line");
//        saveAbsence(absenceLine);
//
//    }

    public void saveAbsence(AbsenceLine absenceLine) {

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(new DriverManagerDataSource
                ("jdbc:postgresql://localhost:1234/postgres", "user", "pass"));

        jdbcTemplate.update("INSERT INTO absences VALUES (:id, :userId, :absenceTypeId, :absenceStart, " +
                ":absenceEnd, :description)", Map.of(
                "id", UUID.randomUUID(),
                "userId", absenceLine.getUserId(),
                "absenceTypeId", UUID.fromString(absenceLine.getType()),
                "absenceStart", absenceLine.getStart(),
                "absenceEnd", absenceLine.getEnd(),
                "description", absenceLine.getDescription()
        ));

    }

}
