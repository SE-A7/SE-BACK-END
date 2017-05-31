package transform.app.enums;

public enum KnownPaths 
{
	CONFIGURATION_RELATIVE_PATH("resources/config");
	
	
	private String path;
	
	private KnownPaths(String path) 
	{
		this.path = path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}
	
	public String path() 
	{
		return path;
	}
	
	
}
