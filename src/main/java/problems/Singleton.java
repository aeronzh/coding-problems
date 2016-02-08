package problems;

/**
 * Bill Pugh's solution
 * 
 * @author lucas
 *
 */
public class Singleton {
	private Singleton() {
	}

	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	/**
	 * The first time getInstance() is called, the JVM will hold the holder
	 * class. If another thread calls getInstance() concurrently, the JVM won't
	 * load the holder class a second time: it will wait for the first thread to
	 * have completed the class loading, and at the end of the loading and
	 * initialization of the holder class, both threads will see the holder
	 * class properly initialized and thus containing the unique singleton
	 * instance.
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
