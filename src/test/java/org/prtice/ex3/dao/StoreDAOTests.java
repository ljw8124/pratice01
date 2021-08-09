package org.prtice.ex3.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pratice.ex3.dao.StoreDAO;
import org.pratice.ex3.dto.StoreDTO;


public class StoreDAOTests {

    private StoreDAO storeDAO;

    @BeforeEach
    public void ready() {
        storeDAO = new StoreDAO();
        System.out.println(storeDAO);
    }

    @Test
    public void testInsert() {

        StoreDTO storeDTO = StoreDTO.builder()
                .name("무야호스토어")
                .area("알레스카")
                .desc("무야호, 야호무")
                .build();

        storeDAO.insert(storeDTO);

    }
}
