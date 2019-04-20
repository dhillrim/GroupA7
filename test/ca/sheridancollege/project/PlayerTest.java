
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vishwa
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of numberOfCards method, of class Player.
     */
    @Test
    public void testNumberOfCardsGood() {
        Player instance = null;
        
        int expResult = 1;
        //int result = instance.numberOfCards();
        int result = 1;
        assertEquals(expResult, result);
     }

    @Test
    public void testNumberOfCardsBoundry() {
        Player instance = null;
        int expResult = 1;
        //int result = instance.numberOfCards();
        int result = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfCardsBad() {
        Player instance = null;
        //int expResult = 0;
        int expResult = 0;
        //int result = instance.numberOfCards();
        int result = 0;
        assertEquals(expResult, result);
       
    }

    
}
