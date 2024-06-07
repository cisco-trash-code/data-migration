package com.cisco.writer;

import com.cisco.repository.DestRepository;
import com.cisco.repository.SourceRepository;
import com.cisco.test.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

//@RequiredArgsConstructor
public class TownWriter implements ItemWriter<List<Town>> {

    private DestRepository destRepository;

    public TownWriter() {
    }

    public TownWriter(DestRepository destRepository) {
        this.destRepository = destRepository;
    }

    @Override
    public void write(Chunk<? extends List<Town>> chunk) throws Exception {
        for (List<Town> towns : chunk) {
            destRepository.save(towns);
        }
    }
}
