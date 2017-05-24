package transform.app.enums;

public enum XWikiVersion 
{
	XWIKI_VERSION_0_9("0.9"),
	XWIKI_VERSION_2_1("2.1");
	
	
	private String version;
	
	private XWikiVersion(String version)
	{
		this.version = version;
	}
	
	/**
	 *  <b>SETTER</b> method
	 */
	public void setTag(String version)
	{
		this.version = version;
	}
	
	/**
	 *  <b>GETTER</b> method
	 */
	public String getVersion()
	{
		return version;
	}
}
