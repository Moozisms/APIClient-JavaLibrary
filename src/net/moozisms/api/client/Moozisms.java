/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.moozisms.api.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author anonymousghost
 */
public class Moozisms implements MoozismsApiClient{
    private String ApiKey;
    private String ApiSecret;
    private String To;
    private String From;
    private String Text;
    private String DataType;
    
    private final String Moozisms_URL = "http://api.moozisms.com";
    
    
    /**
     * 
     * @param api_key Your api_key generate from Moozisms plateform, example : vLaR6iXDoLrvSPzy
     * @param api_secret Your api_secret generate from Moozisms plateform, example : fbb2c6a0-5533-11e7-806e-cfdc8z11ccao
     * @param to Phonenumber of the recipient with code without 00 or +, example : 22890147895(00228 or +228 and 90147895, phonenumber from TOGO),13483158714(001 or +1 and 3483158714, phonenumber from USA)
     * @param from Sender ID less than 11 characters, example : Administration
     * @param text Your messages without the special characters
     * @param datatype json or xml
     */
    @Override
    public void send(String api_key,String api_secret,String to,String from,String text,String datatype){
        try {

            this.ApiKey = api_key;
            
            this.ApiSecret = api_secret;
            
            this.To = to;
            
            this.From = from;
            
            this.Text = text;
            
            this.DataType = datatype;
            
            
            String urlParameters = "api_key="+this.ApiKey+
                    "&api_secret="+this.ApiSecret+
                    "&to="+this.To+
                    "&from="+this.From+
                    "&text="+this.Text+
                    "&datatype="+this.DataType;
            
            System.out.println("Parametre : "+urlParameters+"\n");

            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            
            int postDataLength = postData.length;
            
            URL restServiceURL = new URL(this.Moozisms_URL);

            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            
            httpConnection.setDoOutput(true);
            
            httpConnection.setInstanceFollowRedirects(false);
            
            httpConnection.setRequestMethod("POST");
            
            httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            httpConnection.setRequestProperty("charset", "utf-8");
            
            httpConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            
            httpConnection.setUseCaches(false);
            
            try (DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream())) {
                wr.write(postData);
            }

            int responseCode = httpConnection.getResponseCode();
            
            String responseMessage = httpConnection.getResponseMessage();

            System.out.println("Response code : " + responseCode+"\n");
            
            System.out.println(" Response message :" + responseMessage+"\n");
            
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));

            String buffLine;
            String output = "";
            System.out.println("Output from Server:  \n");

            while ((buffLine = responseBuffer.readLine()) != null) {
                //System.out.println(buffLine);
                output += buffLine;
            }
            
            System.out.println("Response from server : \n"+output+"\n");
            
            httpConnection.disconnect();

        } catch (MalformedURLException ex) {

            ex.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * 
     * @param api_key Your api_key generate from Moozisms plateform, example : vLaR6iXDoLrvSPzy
     * @param api_secret Your api_secret generate from Moozisms plateform, example : fbb2c6a0-5533-11e7-806e-cfdc8z11ccao
     * @param to Phonenumber of the recipient with code without 00 or +, example : 22890147895(00228 or +228 and 90147895, phonenumber from TOGO),13483158714(001 or +1 and 3483158714, phonenumber from USA)
     * @param from Sender ID less than 11 characters, example : Administration
     * @param text Your messages without the special characters
     * @param datatype json or xml
     * @return true if message is sent and false if message is not sent
     */
    @Override
    public boolean sendWithAcknowledgmentOfReceipt(String api_key, String api_secret, String to, String from, String text, String datatype) {
        
        boolean result = false;
        
        try {
            

            this.ApiKey = api_key;
            
            this.ApiSecret = api_secret;
            
            this.To = to;
            
            this.From = from;
            
            this.Text = text;
            
            this.DataType = datatype;
            
            
            String urlParameters = "api_key="+this.ApiKey+
                    "&api_secret="+this.ApiSecret+
                    "&to="+this.To+
                    "&from="+this.From+
                    "&text="+this.Text+
                    "&datatype="+this.DataType;
            
            System.out.println("Parametre : "+urlParameters+"\n");

            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            
            int postDataLength = postData.length;
            
            URL restServiceURL = new URL(this.Moozisms_URL);

            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            
            httpConnection.setDoOutput(true);
            
            httpConnection.setInstanceFollowRedirects(false);
            
            httpConnection.setRequestMethod("POST");
            
            httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            httpConnection.setRequestProperty("charset", "utf-8");
            
            httpConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            
            httpConnection.setUseCaches(false);
            
            try (DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream())) {
                wr.write(postData);
            }

            int responseCode = httpConnection.getResponseCode();
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                result = true;
            }
            
            String responseMessage = httpConnection.getResponseMessage();

            System.out.println("Response code : " + responseCode+"\n");
            
            System.out.println(" Response message :" + responseMessage+"\n");
            
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));

            String buffLine;
            String output = "";
            System.out.println("Output from Server:  \n");

            while ((buffLine = responseBuffer.readLine()) != null) {
                //System.out.println(buffLine);
                output += buffLine;
            }
            
            System.out.println("Response from server : \n"+output+"\n");
            
            httpConnection.disconnect();
            
            return result;

        } catch (MalformedURLException ex) {

            ex.printStackTrace();
            
            return false;

        } catch (IOException e) {

            e.printStackTrace();
            
            return false;

        }
    }
    
    
    
}
