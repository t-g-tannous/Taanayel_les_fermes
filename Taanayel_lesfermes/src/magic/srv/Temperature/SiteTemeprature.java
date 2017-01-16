package magic.srv.Temperature;

import java.awt.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import magic.cls.Temperature.TemperatureAPI;

@Path("/taanayelTempService")
public class SiteTemeprature {
	
	@GET
	@Produces("application/json")
	public String getSiteTemeprature() {
 
		 
		    TemperatureAPI tempApi= new TemperatureAPI();
		 
		    TemperatureAPI.SiteInformation[] listSiteIndformation= new TemperatureAPI.SiteInformation[2];
		    
		    TemperatureAPI.SiteInformation siteINfoBekaa= tempApi.getSiteTemperature("Bekaa");
		    TemperatureAPI.SiteInformation siteINfoBeirut= tempApi.getSiteTemperature("Beirut");
		    listSiteIndformation[0]=siteINfoBekaa;
		    listSiteIndformation[1]=siteINfoBeirut;
		    
		    ObjectMapper mapper = new ObjectMapper();
		    String jsonInStringBekaa="";
		    String jsonInStringBeirut="";
		    //Object to JSON in String
		    try {
		    	jsonInStringBekaa = mapper.writeValueAsString(listSiteIndformation);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	mapper = new ObjectMapper();
		    	jsonInStringBeirut = mapper.writeValueAsString(siteINfoBeirut);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		    String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		//	return "<SitesService><site>" + jsonInStringBekaa + "</site><site>"+jsonInStringBeirut+"</site></SitesService>";
		    return jsonInStringBekaa;
	}
	
	@Path("{c}")
	@GET
	//@Produces("application/xml")
	@Produces("application/json")
	public String getSiteTemeprature(@PathParam("c") String c) 
	{
	     String siteName=c;
	    TemperatureAPI tempApi= new TemperatureAPI();
	    TemperatureAPI.SiteInformation siteINfo= tempApi.getSiteTemperature(siteName);
	    TemperatureAPI.SiteInformation[] listSiteIndformation= new TemperatureAPI.SiteInformation[1];
	    listSiteIndformation[0]=siteINfo;
	   
	    
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonInString="";
	    //Object to JSON in String
	    try {
			 jsonInString = mapper.writeValueAsString(listSiteIndformation);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		//return "<SitesService>" + jsonInString + "</SitesService>";
	  return jsonInString;
	}
}
