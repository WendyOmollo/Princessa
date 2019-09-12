package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrincessTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    public Princess setUpNewPrincess(){
        return new Princess("Rapunzel",1,12,"Hair","Tower");
    }
    @Test
    public void addPrincess_true() throws Exception{
        Princess princess = setUpNewPrincess();
        assertEquals(true,princess instanceof Princess);
    }
    @Test
    public void addPrincess_getId() throws Exception{
        Princess princess = setUpNewPrincess();
        assertEquals(1,princess.getId());
    }
    @Test
    public void addPrincess_findPrincessById() throws Exception{
        Princess princess = setUpNewPrincess();
        assertEquals(Princess.findById(princess.getId()),princess);
    }
    @Test
    public void addPrincess_updatePrincess() throws Exception{
        Princess princess = setUpNewPrincess();
        String formerName = princess.getName();
        int formerAge = princess.getAge();
        int formerId = princess.getId();
        String formerStrength = princess.getStrength();
        String formerWeakness = princess.getWeakness();

        princess.update("Bella",2,"Rose flowers","Love");

        assertEquals(formerId,princess.getId());
        assertNotEquals(formerAge,princess.getAge());
        assertNotEquals(formerName,princess.getName());
        assertNotEquals(formerStrength,princess.getStrength());
        assertNotEquals(formerWeakness,princess.getWeakness());

    }
}