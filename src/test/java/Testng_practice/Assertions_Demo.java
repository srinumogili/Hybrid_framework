package Testng_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions_Demo {

	// @Test
	void testHardAssertion() {
		String act_result = "srinu";
		String exp_result = "srinu";
		// Assert.assertEquals(act_result, exp_result);
		// Assert.assertNotEquals(act_result, exp_result);
		Assert.assertFalse(false);
	}

	@Test
	void softassertion() {
		String act_result = "srinu";
		String exp_result = "Srinu";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(act_result, exp_result);
		sa.assertAll();
	}
}
