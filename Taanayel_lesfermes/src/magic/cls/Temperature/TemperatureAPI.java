package magic.cls.Temperature;

public  class TemperatureAPI 
{

	public SiteInformation getSiteTemperature(String siteName)
	{
		SiteInformation retVal= new SiteInformation();
		retVal.siteName= siteName;
		if(siteName.equalsIgnoreCase("Bekaa"))
		{
			retVal.MondayTemperature=23.5;
			retVal.TuesdayTemperature=24.5;
			retVal.WedenesdayTemperature=27.5;
			retVal.ThursdayTemperature=21.5;
			retVal.FridayTemperature=20.5;
			retVal.SaturdayTemperature=19.5;
			retVal.SundayTemperature=12.5;
		}
		else if(siteName.equalsIgnoreCase("Beirut"))
		{
			retVal.MondayTemperature=33.5;
			retVal.TuesdayTemperature=34.5;
			retVal.WedenesdayTemperature=37.5;
			retVal.ThursdayTemperature=31.5;
			retVal.FridayTemperature=30.5;
			retVal.SaturdayTemperature=29.5;
			retVal.SundayTemperature=22.5;
		}
		return retVal;
	}
	
	public static class SiteInformation implements java.io.Serializable
	{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	    public String siteName;
	    public Double MondayTemperature;
	    public Double TuesdayTemperature;
	    public Double WedenesdayTemperature;
	    public Double ThursdayTemperature;
	    public Double FridayTemperature;
	    public Double SaturdayTemperature;
	    public Double SundayTemperature;
	    
	}
}



