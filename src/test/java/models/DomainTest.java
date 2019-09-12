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
    public Princess setUpNewPrincess(){
        return new Princess("Rapunzel",1,12,"Hair","Tower");
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
        assertEquals(true,Domain.getAll().contains(domain));
        assertEquals(true,Domain.getAll().contains(otherDomain));
    }
    @Test
    public void addDomain_getById_1() throws Exception{
        Domain domain = setUpNewDomain();
        assertEquals(1,domain.getId());
    }
    @Test
    public void addDomain_getId_findById() throws Exception{
        Domain domain = setUpNewDomain();
        assertEquals(Domain.findById(domain.getId()),domain);
    }
    @Test
    public void getDomain_updateDomain_getNewDetails() throws Exception{
        Domain domain = setUpNewDomain();
        String formerName = domain.getName();
        int formerId = domain.getId();
        String formerCourse = domain.getCourse();

        domain.update("Red Devils",1,"Killing bad memories");
        assertEquals(formerId,domain.getId());
        assertNotEquals(formerName,domain.getName());
        assertNotEquals(formerCourse,domain.getCourse());
    }
    @Test
    public void getDomain_checkForPrincesses() throws Exception{
        Domain domain = setUpNewDomain();
        Princess princess = setUpNewPrincess();
        domain.add(princess);
        assertTrue(Domain.getPrincesses().contains(princess));
    }

}