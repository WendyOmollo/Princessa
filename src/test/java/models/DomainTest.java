package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DomainTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void domainInstantiatesCorrectly() throws Exception {
        Domain domain = setUpNewDomain();
        assertEquals(true, domain instanceof Domain);

    }

    public Domain setUpNewDomain(){
        return new Domain("Blue Ivies","Planting Flowers",12);
    }


}