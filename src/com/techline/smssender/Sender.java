/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techline.smssender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author MIKE
 */
public class Sender {

    private String username;
    private String password;
    private String message;
    private String port;
    private String server;
    private String source;
     String destination;
     String type;
     String dlr;
// Username that is to be used for submission String username;
// password that is to be used along with username String password;
// Message content that is to be transmitted String message;

    public Sender() {
    }

    /**
     * What type of the message that is to be sent * <ul>
     * <li>0:means plain text</li> * <li>1:means flash</li>
     * <li>2:means Unicode (Message content should be in Hex)</li>
     * <li>6:means Unicode Flash (Message content should be in Hex)</li>
     *
     * </ul>
     */
   
    /**
     * Require DLR or not * <ul>
     * <li>0:means DLR is not Required</li> * <li>1:means DLR is Required</li>
     * </ul>
     * Route Mobile Limited © 2018. All rights reserved 13
     */
    
    /**
     * Destinations to which message is to be sent for submitting more than one
     * * destination at once destinations should be comma separated Like
     * xxxxxxx,xxxxxxx
     */
   
// Sender Id to be used for submitting the message String source;
// To what server you need to connect to for submission String server;
// Port that is to be used like 8080 or 8000 int port;

     
    public Sender(String server, int port, String username, String password, String message, String dlr, String type, String destination,
            String source) {
        this.username = username;
        this.password = password;
        this.message = message;
        this.dlr = dlr;
        this.type = type;
        this.destination = destination;
        this.source = source;
        this.server = server;
        this.port = String.valueOf(port);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDlr() {
        return dlr;
    }

    public void setDlr(String dlr) {
        this.dlr = dlr;
    }

    void submitMessage() {
        try {
// Url that will be called to submit the message
            URL sendUrl = new URL("http://" + this.server + ":" + this.port + "/bulksms/bulksms");
            HttpURLConnection httpConnection = (HttpURLConnection) sendUrl.openConnection();
            httpConnection.setDoInput(true);
            httpConnection.setDoOutput(true);
// This method sets the method type to POST so that // will be send as a POST request httpConnection.setRequestMethod("POST");
// This method is set as true which we intend to send // input to the server httpConnection.setDoInput(true);
// This method implies that we intend to receive data from server. httpConnection.setDoOutput(true);
// Implies do not use cached data httpConnection.setUseCaches(false);
// Data that will be sent over the stream to the server.
            DataOutputStream dataStreamToServer = new DataOutputStream(httpConnection.getOutputStream());
            dataStreamToServer.writeBytes("username="
                    + URLEncoder.encode(this.username, "UTF-8") + "&password=" + URLEncoder.encode(this.password, "UTF-8") + "&type="
                    + URLEncoder.encode(this.type, "UTF-8") + "&dlr="
                    + URLEncoder.encode(this.dlr, "UTF-8") + "&destination="
                    + URLEncoder.encode(this.destination, "UTF-8") + "&source=" + URLEncoder.encode(this.source, "UTF-8") + "&message="
                    + URLEncoder.encode(this.message, "UTF-8"));
            dataStreamToServer.flush();
            dataStreamToServer.close();
// Here take the output value of the server.
            BufferedReader dataStreamFromUrl = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            String dataFromUrl = "", dataBuffer = "";
// Writing information from the stream to the buffer
            while ((dataBuffer = dataStreamFromUrl.readLine()) != null) {
                dataFromUrl += dataBuffer;
            }
            /**
             * Now dataFromUrl variable contains the Response received from the
             * * server so we can parse the response and process it accordingly.
             */
            dataStreamFromUrl.close();
            System.out.println("Response: " + dataFromUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Below method converts the unicode to hex value * @param regText
     *
     * @return Route Mobile Limited © 2018. All rights reserved 15
     */
}
