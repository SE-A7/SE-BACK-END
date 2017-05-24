package transform.app.interfaces;

/**
 * This class is used for translating the input file from <b>"old"</b> version of the code into the <b>"new"</b> version.<br>
 * Consists of two phases:<br>
 *  I) Interpret the <b>"old"</b> version into an application-level defined language.<br>
 * II) Interpret the application language into the <b>"new"</b> version.
 * <br><br>
 * As a result, it is returned a file which contains the code written in the <b>"new"</b> version.
 */
public interface Translator 
{
	/**
	 * This method acquires the first step of the translation process.
	 * @param inputFile - the input file which is desired to be translated
	 */
	public void translateIntoGeneralLanguage(String content);
	
	/**
	 * This method acquires the second step of the translation process.
	 * 
	 * @return The final translated file
	 */
	public void translateIntoFinalVersion();

}