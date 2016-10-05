package osgi.enroute.examples.eval.test;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import junit.framework.TestCase;
import osgi.enroute.examples.eval.api.Eval;

public class EvalTest  extends TestCase {
	BundleContext context = FrameworkUtil.getBundle(EvalTest.class).getBundleContext();
	
	public void testEval() throws Exception {
		ServiceReference<Eval> ref = context.getServiceReference(Eval.class);
		assertNotNull("No such service", ref);
		Eval eval = context.getService(ref);
		assertNotNull("Service object init error", eval);
		assertEquals( 7.0D, eval.eval("1+6"));
	}
}
