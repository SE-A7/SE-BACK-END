package transform.app.impl.abstr;

import java.io.File;
import org.apache.log4j.Logger;
import transform.app.interfaces.TranslatorConfiguration;

public abstract class AbstractTranslatorConfiguration implements TranslatorConfiguration 
{
	protected File file;
	protected AbstractTranslator fromTranslator;
	protected AbstractTranslator toTranslator;
	protected String codeToTranslate;
	
	private static Logger log = Logger.getLogger(AbstractTranslatorConfiguration.class);

	@Override
	public void startTranslationProcess() 
	{
		log.info("Starting the translation process...");
		fromTranslator.translateIntoGeneralLanguage(codeToTranslate);
		
		toTranslator.setEncodingFile(fromTranslator.getEncodedFile());
		toTranslator.translateIntoFinalVersion();
	
		log.info("Translation process ended with success.");
	}
	
	
	public File getResult()
	{
		return toTranslator.getResultFile();
	}

}
