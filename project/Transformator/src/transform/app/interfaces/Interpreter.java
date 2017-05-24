package transform.app.interfaces;

public interface Interpreter 
{  
	/**
	 *  Used to encode from a programming language into application defined language
	 */
	public String encode(String content);
	
	/**
	 * 	Used to decode from application defined language into another programming language
	 */
	public String decode(String content);

}