package com.cisco.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestApi {

    private final TestRepo repo;

    @GetMapping("/{id}")
    public Optional<Town> getData(@PathVariable String id) {
//        return repo.getData(Long.parseLong(id));
        return null;
    }
}
