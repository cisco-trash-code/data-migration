package com.cisco.repository;

import com.cisco.test.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SourceRepository {

    private final JdbcClient jdbcClient;

    public List<Town> get() {
        var sql = "SELECT * FROM towns";

        return jdbcClient.sql(sql)
                .query(Town.class)
                .list();
    }
}
