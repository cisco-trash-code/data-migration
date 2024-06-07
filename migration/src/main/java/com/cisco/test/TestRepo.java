package com.cisco.test;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TestRepo {

    private final JdbcClient jdbcClient;

    public Optional<Town> getData(long id) {
        var sql = "SELECT * FROM towns WHERE id=?";

        return jdbcClient.sql(sql)
                .param(id)
                .query(Town.class)
                .optional();
    }

}
