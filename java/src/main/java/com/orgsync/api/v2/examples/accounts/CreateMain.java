package com.orgsync.api.v2.examples.accounts;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orgsync.api.v2.models.AccountAttributes;
import com.orgsync.api.v2.models.AccountCreateRequest;
import com.orgsync.api.v2.models.AccountDetail;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * An example of API v2 account creation.
 */
public class CreateMain {

    private static final String API_URL = "https://api.orgsync.com/api/v2/accounts";

    // TODO: fill in your schools api key
    private static final String API_KEY = "XXXXXXXXXX";

    // TODO: fill in your schools username suffix
    //       if your usernames contain an '@' sign, then just the '@' and whatever follows
    //       otherwise, it is `@your-schools-permalink
    private static final String USERNAME_SUFFIX = "@your-university";

    // General fields used in the request
    private static final String USERNAME = "test" + USERNAME_SUFFIX;
    private static final String EMAIL = "test@test.com";
    private static final String FIRST_NAME = "Justin";
    private static final String LAST_NAME = "Testing";

    // Our java field names are camelCase, but the API is underscore_case.  This converts between the two.
    private static final Gson gson =
            new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public static void main(String[] args) {
        AccountCreateRequest request = createAccountCreateRequest();

        AccountDetail account = null;
        try {
            account = sendPostRequest(request);
        } catch (Exception e) {
            System.err.println("Exception creating account!");
            e.printStackTrace();
        }

        System.out.println("Received response: " + account);
    }

    /**
     * Send a post request to the create an account.
     *
     * @param request the account to create
     * @return the details of the account that was created
     *
     * @throws IOException If there is a problem communicating with the server
     * @throws java.lang.RuntimeException A general exception if the server returns a non-200 response
     */
    private static AccountDetail sendPostRequest(AccountCreateRequest request) throws IOException {
        String json = gson.toJson(request);

        System.out.println("Sending request with JSON: " + json);

        // Make a POST request to the API and append our key
        // We send application/json in the body and accept it as the response
        String url = API_URL + "?key=" + API_KEY;
        HttpResponse response = Request.Post(url)
                .bodyString(json, ContentType.APPLICATION_JSON)
                .addHeader("Accept", ContentType.APPLICATION_JSON.getMimeType())
                .execute()
                .returnResponse();

        // Here we need to read all the content that was returned from the server
        StringBuilder content = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Check the status code.  If its not a 200 then something went wrong.  Lets throw an exception
        int status = response.getStatusLine().getStatusCode();
        if (status != 200) {
            throw new RuntimeException("Error creating account!  Status: " + status + ", Body: " + content.toString());
        }

        // Parse the JSON for the returned account
        return gson.fromJson(content.toString(), AccountDetail.class);
    }

    /**
     * Create an account creation request using the constants specified above.
     *
     * @return the create request
     */
    private static AccountCreateRequest createAccountCreateRequest() {
        return new AccountCreateRequest(USERNAME, false, null, createAccountAttributes(), null, null, null);
    }

    /**
     * Create the account attributes map with the constants defined above.
     *
     * @return the account attributes
     */
    private static AccountAttributes createAccountAttributes() {
        return new AccountAttributes(EMAIL, FIRST_NAME, LAST_NAME, null, null, null, null, null, null);
    }

}
