package transform.app.util;

public class StringUtils 
{
	/**
	 * Computes the number of repetitions of a substring into a string.
	 * 
	 * @param countedString - the substring which needs to be counted
	 * @param content - the container string
	 * 
	 * @return the number of distinct appearances of the substring into the string 
	 */
	public static int getNumberOfCounts(String countedString, String content)
	{
		int count = 0;
	    int index = 0;

		while ((index = content.indexOf(countedString, index)) != -1)
		{
		   index++;
		   count++;
		}
		
		return count;
	}
	
	
	/**
	 * This method builds a string from a substring which is repeated, separated by the given delimiter
	 * 
	 * @param repeatingString - the string which will be repeated
	 * @param noOfRepetitions - the number of repetitions of the string
	 * @param delimiter	- the delimiter used to separate the substring repetitions.
	 * 
	 * @return A {@link String} containing the repeated substring, separated by delimiter. 
	 */
	public static String getRepeatedString(String repeatingString, int noOfRepetitions, String delimiter)
	{
		StringBuilder sb = new StringBuilder();
		
		if(noOfRepetitions == 0)
			return sb.toString();
		
		
		sb.append(repeatingString);
		for(int counter = 1; counter < noOfRepetitions; counter++)
		{
			sb.append(delimiter).append(repeatingString);
		}
		return sb.toString();
	}
}
