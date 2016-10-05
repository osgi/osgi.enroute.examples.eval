package osgi.enroute.examples.eval.command;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import osgi.enroute.debug.api.Debug;
import osgi.enroute.examples.eval.api.Eval;

@Component(property= { 
	Debug.COMMAND_SCOPE+"=eval", 
	Debug.COMMAND_FUNCTION+"=eval" },
	service=EvalCommand.class)
public class EvalCommand {

	@Reference
	Eval greeter;
	
	public double eval(String ... name) throws Exception {
		return greeter.eval(Stream.of(name).collect(Collectors.joining(" ")));
	}
}

