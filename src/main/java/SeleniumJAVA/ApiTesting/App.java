package SeleniumJAVA.ApiTesting;

import apiResponseModels.TrainingErrorresponse;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // Specify the base URL to the RESTful web service
        //RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RestAssured.baseURI = "https://apim-dpe-dev.azure-api.net/api/v1/advisors/343434343/training";
        
        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Ocp-Apim-Subscription-Key", "6863fe6ccb6346608d0fed71aae8dd17");

        
        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        //Response response = httpRequest.request(Method.GET, "/Kochi");
        Response response = httpRequest.request(Method.GET);
        
        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        
        TrainingErrorresponse errResponse = response.as(TrainingErrorresponse.class);
        System.out.println(errResponse.timestamp);
        System.out.println(errResponse.path);
        System.out.println(errResponse.status);
        System.out.println(errResponse.error);
        System.out.println(errResponse.message);
        
        
    }
      
}

