package utilPackages;

import java.util.List;

public class TestMethodErrorBuffer {
	private static ThreadLocal<List<Throwable>> testErrorBuffer = new ThreadLocal<List<Throwable>>();

	static List<Throwable> get() {
		return testErrorBuffer.get();
	}

	static void set(List<Throwable> errorBuffer) {
		testErrorBuffer.set(errorBuffer);
	}

	static void remove() {
		testErrorBuffer.remove();
	}
}
