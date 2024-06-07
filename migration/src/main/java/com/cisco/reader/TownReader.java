package com.cisco.reader;

import com.cisco.repository.SourceRepository;
import com.cisco.test.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@RequiredArgsConstructor
public class TownReader implements ItemReader<List<Town>> {

    private SourceRepository sourceRepository;

    public TownReader() {
    }

    public TownReader(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @Override
    public List<Town> read() throws Exception {
        return sourceRepository.get();
    }
}
