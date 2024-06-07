package com.cisco.repository;

import com.cisco.test.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DestRepository {
    private final JdbcClient jdbcClient;

    public void save(List<Town> towns) {
        var sql = "INSERT INTO towns (id, code, article, name, local) VALUES (?,?,?,?,?)";

        towns.forEach(town -> jdbcClient.sql(sql)
                .param(1, town.getId())
                .param(2, town.getCode())
                .param(3, town.getArticle())
                .param(4, town.getName())
                .param(5, "Y")
                .update());
    }
}
