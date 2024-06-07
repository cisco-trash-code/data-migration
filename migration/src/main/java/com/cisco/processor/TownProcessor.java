package com.cisco.processor;

import com.cisco.test.Town;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class TownProcessor implements ItemProcessor<List<Town>, List<Town>> {

    @Override
    public List<Town> process(List<Town> towns) throws Exception {
        for (Town town : towns) {
//            town.setLocal("Y");
        }
        return towns;
    }
}
