package com.codeborne.hrborne;


import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost:1234/postgres", "user", "pass"));

    public List<Name> getAllNames() {
        return jdbcTemplate.query("SELECT id,first_name,last_name FROM users", new DataClassRowMapper<>(Name.class));
    }
}
