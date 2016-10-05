package osgi.enroute.examples.eval.provider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import osgi.enroute.examples.eval.api.Eval;

@Component(name = "osgi.enroute.examples.eval.provider")
public class EvalImpl implements Eval {
	Pattern EXPR = Pattern.compile( "\\s*(?<left>\\d+)\\s*(?<op>\\+|-)\\s*(?<right>\\d+)\\s*");
	
	@Reference
	LogService log;
	
	
	@Override
	public double eval(String expression) throws Exception {
		Matcher m = EXPR.matcher(expression);
		if ( !m.matches()) {
			log.log(LogService.LOG_WARNING, "Invalid expression " + expression);
			throw new IllegalArgumentException("Invalid expression " + expression);
		}
		
		double left = Double.valueOf( m.group("left"));
		double right = Double.valueOf( m.group("right"));
		switch( m.group("op")) {
		case "+": return left + right;
		case "-": return left - right;
		}
		return Double.NaN;
	}
}
