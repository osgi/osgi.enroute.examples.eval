
package osgi.enroute.examples.eval.parsii.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import osgi.enroute.examples.eval.api.Eval;
import parsii.eval.Parser;

@Component(name = "osgi.enroute.examples.eval.parsii.provider")
public class EvalImpl implements Eval {

	@Reference
	LogService log;
	
	@Override
	public double eval(String expression) throws Exception {
		return Parser.parse(expression).evaluate();
	}
}

