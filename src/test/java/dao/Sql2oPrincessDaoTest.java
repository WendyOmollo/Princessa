//package dao;
//
//import models.Princess;
//import org.sql2o.*;
//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class Sql2oPrincessDaoTest {
//    private Sql2oPrincessDao princessDao; //ignore me for now. We'll create this soon.
//    private static Connection conn; //must be sql2o class conn
//
//
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/princessdomain_test";
//        Sql2o sql2o = new Sql2o(connectionString, "moringa", "hyperloop");
//        princessDao = new Sql2oPrincessDao(sql2o); //ignore me for now
//        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        princessDao.clearAllPrincesses();
//    }
//
//    @AfterClass
//    public static void shutDown() throws Exception {
//        conn.close();
//    }
//
//    @Test
//    public void addingCourseSetsId() throws Exception {
//        Princess princess = new Princess ("Rapunzel",12,"Voice","Witch",1);
//        int originalPrincessId = princess.getId();
//        princessDao.add(princess);
//        assertNotEquals(originalPrincessId, princess.getId()); //how does this work?
//    }
//
//    @Test
//    public void existingPrincessesCanBeFoundById() throws Exception {
//        Princess princess = new Princess ("Rapunzel",12,"Voice","Witch",1);
//        princessDao.add(princess); //add to dao (takes care of saving)
//        Princess foundPrincess = princessDao.findById(princess.getId()); //retrieve
//        assertEquals(princess, foundPrincess);
//    }
//
//    @Test
//    public void addedPrincessesAreReturnedFromGetAll() throws Exception {
//        Princess princess = new Princess ("Rapunzel",12,"Voice","Witch",1);
//        princessDao.add(princess);
//        assertEquals(1, princessDao.getAll().size());
//    }
//
//    @Test
//    public void noPrincessesReturnsEmptyList() throws Exception {
//        assertEquals(0, princessDao.getAll().size());
//    }
//
//    @Test
//    public void updateChangesPrincessContent() throws Exception {
//        String initialName = "Snow White";
//        Princess princess = new Princess (initialName,12,"Voice","Witch",1);
//        princessDao.add(princess);
//        princessDao.update(princess.getId(),"Rapunzel",12,"Voice","Witch",1);
//        Princess updatedPrincess = princessDao.findById(princess.getId());
//        assertNotEquals(initialName, updatedPrincess.getName());
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectPrincess() throws Exception {
//        Princess princess = new Princess ("Rapunzel",12,"Voice","Witch",1);
//        princessDao.add(princess);
//        princessDao.deleteById(princess.getId());
//        assertEquals(0, princessDao.getAll().size());
//    }
//
//    @Test
//    public void clearAllClearsAll() throws Exception {
//        Princess princess = new Princess ("Rapunzel",12,"Voice","Witch",1);
//        Princess otherPrincess = new Princess("Rapunzel",12,"Voice","Witch",1);
//        princessDao.add(princess);
//        princessDao.add(otherPrincess);
//        int daoSize = princessDao.getAll().size();
//        princessDao.clearAllPrincesses();
//        assertTrue(daoSize > 0 && daoSize > princessDao.getAll().size()); //this is a little overcomplicated, but illustrates well how we might use `assertTrue` in a different way.
//    }
//
//}