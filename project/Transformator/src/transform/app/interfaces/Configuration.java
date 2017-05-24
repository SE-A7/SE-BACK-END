package transform.app.interfaces;

import java.util.Map;

public interface Configuration 
{
	/**
	 *  Used to build the configuration
	 */
	public void build();
	
	/**
	 *  Used to obtain the mappings between the encoding and the interpreter
	 *  
	 * 	@return A map which will contain the mappings
	 */
	public Map<String,Interpreter> getMap();
}