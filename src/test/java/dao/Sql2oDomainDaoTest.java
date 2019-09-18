//package dao;
//
//import models.Domain;
//import org.sql2o.*;
//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class Sql2oDomainDaoTest {
//    private Sql2oDomainDao domainDao;//ignore me for now. We'll create this soon.
//    private static Connection conn; //must be sql2o class conn
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/princessdomain_test";
//        Sql2o sql2o = new Sql2o(connectionString, "moringa", "hyperloop");
//        domainDao = new Sql2oDomainDao(sql2o); //ignore me for now
//        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
//    }
//
//    @After
//    public void tearDown() throws Exception {
//       domainDao.clearAllDomains();
//
//    }
//
//    @AfterClass
//    public static void shutDown() throws Exception {
//       conn.close();
//    }
//
//    @Test
//    public void addingCourseSetsId() throws Exception {
//        Domain domain = new Domain ("Blue Ivies","Picking Flowers",12);
//        int originalDomainId = domain.getId();
//        domainDao.add(domain);
//        assertNotEquals(originalDomainId, domain.getId()); //how does this work?
//    }
//
//    @Test
//    public void existingDomainsCanBeFoundById() throws Exception {
//        Domain domain = new Domain ("Blue Ivies","Picking Flowers",12);
//        domainDao.add(domain); //add to dao (takes care of saving)
//        Domain foundDomain = domainDao.findById(domain.getId()); //retrieve
//        assertEquals(domain, foundDomain);
//    }
//
//    @Test
//    public void addedDomainsAreReturnedFromGetAll() throws Exception {
//        Domain domain = new Domain ("Blue Ivies","Picking Flowers",12);
//        domainDao.add(domain);
//        assertEquals(1, domainDao.getAll().size());
//    }
//
//    @Test
//    public void noDomainsReturnsEmptyList() throws Exception {
//        assertEquals(0, domainDao.getAll().size());
//    }
//
//    @Test
//    public void updateChangesDomainContent() throws Exception {
//        String initialName = "Red Devils";
//        Domain domain = new Domain (initialName,"Picking Flowers",12);
//        domainDao.add(domain);
//        domainDao.update(domain.getId(),"Blue Ivies",12,"Picking flowers");
//        Domain updatedDomain = domainDao.findById(domain.getId());
//        assertNotEquals(initialName, updatedDomain.getName());
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectDomain() throws Exception {
//        Domain domain = new Domain ("Blue Ivies","Picking Flowers",12);
//        domainDao.add(domain);
//        domainDao.deleteById(domain.getId());
//        assertEquals(0, domainDao.getAll().size());
//    }
//
//    @Test
//    public void clearAllClearsAll() throws Exception {
//        Domain domain = new Domain ("Blue Ivies","Picking Flowers",12);
//        Domain otherDomain = new Domain("Blue Ivies","Picking Flowers",12);
//        domainDao.add(domain);
//        domainDao.add(otherDomain);
//        int daoSize = domainDao.getAll().size();
//        domainDao.clearAllDomains();
//        assertTrue(daoSize > 0 && daoSize > domainDao.getAll().size()); //this is a little overcomplicated, but illustrates well how we might use `assertTrue` in a different way.
//    }
//
//}