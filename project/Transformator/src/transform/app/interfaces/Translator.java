package transform.app.interfaces;

import java.io.File;

public interface Translator 
{
	/**
	 * This method is used for translating the input file from <b>"old"</b> version of the code into the <b>"new"</b> version.<br>
	 * Consists of two phases:<br>
	 *  I) Interpret the <b>"old"</b> version into an application-level defined language.<br>
	 * II) Interpret the application language into the <b>"new"</b> version.
	 * 
	 * @param inputFile - the input file
	 * 
	 * @return The file which contains the code written in the <b>"new"</b> version.
	 */
	public File translate(File inputFile);

}