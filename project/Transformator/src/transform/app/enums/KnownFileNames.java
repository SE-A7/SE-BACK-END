package transform.app.enums;

public enum KnownFileNames 
{
	XWIKI_V09_CONFIG_FILE("xwiki_09_mappings.xml"),
	XWIKI_V21_CONFIG_FILE("xwiki_21_mappings.xml");
	
	private String fileName;
	
	private KnownFileNames(String fileName) 
	{
		this.fileName = fileName;
	}

	public void setPath(String fileName) 
	{
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
}
