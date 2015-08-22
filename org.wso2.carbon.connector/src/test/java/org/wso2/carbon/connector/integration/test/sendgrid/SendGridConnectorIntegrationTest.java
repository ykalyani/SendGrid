package org.wso2.carbon.connector.integration.test.sendgrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.axiom.om.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

public class SendGridConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> esbRequestHeadersMap = new HashMap<String, String>();

    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

//    private long timeOut;

    /**
     * Set up the environment.
     */
    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        init("sendgrid-connector-1.0.0");

        esbRequestHeadersMap.put("Content-Type", "application/json");

//        timeOut = Long.parseLong(connectorProperties.getProperty("timeOut"));
        // Create base64-encoded auth string from using username and password
/*
        final String authString =
                connectorProperties.getProperty("api_user") + ":" + connectorProperties.getProperty("api_key");
        final String base64AuthString = Base64.encode(authString.getBytes());

        apiRequestHeadersMap.put("Authorization", "Basic " + base64AuthString);*/

        apiRequestHeadersMap.putAll(esbRequestHeadersMap);

    }


     /* Positive test case for getList method with mandatory parameters.*/


    @Test(priority = 1, description = "SendGrid {getList} integration test with mandatory parameters.")
    public void testgetListWithMandatoryParameters() throws IOException, JSONException {


        esbRequestHeadersMap.put("Action", "urn:getList");

        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getListMandatory.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl")+"/lists/get.json?"+"api_user="+connectorProperties.getProperty("apiUser")+"&"+"api_key="+connectorProperties.getProperty("apiKey");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
/*
        Assert.assertEquals(esbPlansListArray.getJSONObject(0).getJSONObject("list").getString("id"), apiPlansListArray
                .getJSONObject(0).getJSONObject("list").getString("id"));*/
        Assert.assertEquals(esbRestResponse.getBody().get("list"), apiRestResponse.getBody().get("list"));
       /* Assert.assertEquals(esbRestResponse.getBody().get("id"), apiRestResponse.getBody().get("id"));*/
    }

    @Test(priority = 1, description = "SendGrid {getList} integration test with optional parameters.")
    public void testgetListWithMandatoryParameters() throws IOException, JSONException {


        esbRequestHeadersMap.put("Action", "urn:getList");

        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getListMandatory.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl")+"/lists/get.json?"+"api_user="+connectorProperties.getProperty("apiUser")+"&"+"api_key="+connectorProperties.getProperty("apiKey");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
/*
        Assert.assertEquals(esbPlansListArray.getJSONObject(0).getJSONObject("list").getString("id"), apiPlansListArray
                .getJSONObject(0).getJSONObject("list").getString("id"));*/
        Assert.assertEquals(esbRestResponse.getBody().get("list"), apiRestResponse.getBody().get("list"));
       /* Assert.assertEquals(esbRestResponse.getBody().get("id"), apiRestResponse.getBody().get("id"));*/
    }


}