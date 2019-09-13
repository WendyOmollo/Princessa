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
        return new Princess("Rapunzel",1,"Voice","Hair",1);
    }
    @Test
    public void addPrincess_true() throws Exception{
        Princess princess = setUpNewPrincess();
        assertEquals(true,princess instanceof Princess);
    }


}