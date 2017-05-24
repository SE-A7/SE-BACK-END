package transform.app.impl.abstr;

import transform.app.interfaces.Interpreter;

/**
 * 
 * An abstractisation over {@link Interpreter} interface.
 * Defines the encoding and deconding tag, which will be used in text transformation.
 *
 */
public abstract class AbstractInterpreter implements Interpreter 
{
	protected String encodingTag;
	protected String decodingTag;
}