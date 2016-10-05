package osgi.enroute.examples.eval.api;
/**
 * A service that evaluates an expression and returns the result
 */

public interface Eval {
	/**
	 * Evaluate an expression and return the result.
	 */
	double eval(String expression) throws Exception;
}

