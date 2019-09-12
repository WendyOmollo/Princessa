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

    public Domain setUpNewDomain(){
        return new Domain("Blue Ivies",1,"Taking care of flowers");
    }

    @Test
    public void addDomain_true() throws Exception{
        Domain domain = setUpNewDomain();
        assertEquals(true,domain instanceof Domain);
    }
    @Test
    public void addTwoDomains_true() throws Exception{
        Domain domain = setUpNewDomain();
        Domain otherDomain =setUpNewDomain();
        assertEquals(2,Domain.getAll().size());
    }
    @Test
    public void addDomain_getById_1() throws Exception{
        Domain domain = setUpNewDomain();
        assertEquals(1,domain.getId());
    }
}