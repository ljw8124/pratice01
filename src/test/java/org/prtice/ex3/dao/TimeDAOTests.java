package org.prtice.ex3.dao;

import org.junit.jupiter.api.Test;
import org.pratice.ex3.dao.TimeDAO;

public class TimeDAOTests {

    private TimeDAO timeDAO = new TimeDAO();

    @Test
    public void testGetTime() {
        System.out.println(timeDAO.getTime());
    }

}
