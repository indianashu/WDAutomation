package utilPackages;

import org.testng.Assert;

public class Verify {

	protected Verify() {
		
	}

	static public void verifyTrue(boolean condition, String message) {
		try {
			Assert.assertTrue(condition, message);
		} catch (AssertionError e) {
			addToErrorBuffer(e);
		}
	}

	static public void verifyFalse(boolean condition, String message) {
		try {
			Assert.assertFalse(condition, message);
		} catch (AssertionError e) {
			addToErrorBuffer(e);
		}
	}

	static public void verifyEquals(Object actual, Object expected, String message) {
		try {
			Assert.assertEquals(actual, expected, message);
		} catch (AssertionError e) {
			addToErrorBuffer(e);
		}
	}

	public static void verifyNotEquals(Object actual1, Object actual2, String message) {
		try {
			Assert.assertNotEquals(actual1, actual2, message);
		} catch (AssertionError e) {
			addToErrorBuffer(e);
		}
	}

	private static void addToErrorBuffer(AssertionError e) {

		try {

			VerificationError verificationError = new VerificationError(e.getMessage());

			verificationError.setStackTrace(e.getStackTrace());

			TestMethodErrorBuffer.get().add(verificationError);

		} catch (NullPointerException ex) {

			throw new RuntimeException("Please let TestNG know about " + TestMethodListener.class.getName()
					+ " listener for verify statements to work. For more information go to http://testng.org/doc/documentation-main.html#testng-listeners");
		}

	}
}
