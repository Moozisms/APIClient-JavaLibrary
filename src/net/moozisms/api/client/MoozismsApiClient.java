/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.moozisms.api.client;

/**
 *
 * @author anonymousghost
 */
public interface MoozismsApiClient {
        
    
    /**
     * 
     * @param api_key Your api_key generate from Moozisms plateform, example : vLaR6iXDoLrvSPzy
     * @param api_secret Your api_secret generate from Moozisms plateform, example : fbb2c6a0-5533-11e7-806e-cfdc8z11ccao
     * @param to Phonenumber of the recipient with code without 00 or +, example : 22890147895(00228 or +228 and 90147895, phonenumber from TOGO),13483158714(001 or +1 and 3483158714, phonenumber from USA)
     * @param from Sender ID less than 11 characters, example : Administration
     * @param text Your messages without the special characters
     * @param datatype json or xml
     */
     public void send(String api_key,String api_secret,String to,String from,String text,String datatype);
     
     
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
     public boolean sendWithAcknowledgmentOfReceipt(String api_key,String api_secret,String to,String from,String text,String datatype);
}
