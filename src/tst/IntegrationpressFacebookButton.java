package tst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class IntegrationpressFacebookButton {

	float stopStep = 12.2f;
		
	
	@RepeatedTest(value = 1)
	void test() throws InterruptedException {
		
		
		//launch initEach in Trivia Sanity test
		TriviaSanityTest.initEach();
		
		//create sanity test object to launch Sanity test
		TriviaSanityTest santest = new TriviaSanityTest();
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		//set stop step from where we want to back
		TriviaSanityTest.setStopStep(stopStep);
		
		//launch sanity test
		santest.SanityTest();
		
		//setting for functionality driver
		Functionality.driver = Sanity.driver;
		
		
		assertTrue(Functionality.pressFacebookButton());
	}

}
