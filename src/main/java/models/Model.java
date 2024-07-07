package models;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.*;

/**
 * Lake pollution data holder/repo
 *
 * <p>Model of the MVC pattern, holds, manipulates and returns Lake Pollution data as needed</p>
 * @author Maya, Tamim
 * */
public class Model {
    /**
     * The Credential object used to gain authorization to the spreadsheet
     *
     * <p>Only a single instance of the credential should be made</p>
     * */
    Credential credential;
    /**
     * The transport needed to send HTTP requests
     *
     * <p>Only a single instance of the transport should be made</p>
     * */
    NetHttpTransport HTTP_TRANSPORT;

    /**
     * Storage for all the lake data
     *
     * <p>Only a single instance of the data should be made</p>
     * */
    LakeCollection data;

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Constructor for the {@link Model} class
     *
     * @param credential The credential used to gain access to the data sheet
     * @param httpTransport The transport used to build HTTP requests
     * */
    public Model(Credential credential,NetHttpTransport httpTransport){
        this.credential = credential;
        this.HTTP_TRANSPORT = httpTransport;
        this.data = new LakeCollection();
    }
    /**
     * Reads data from a specified spreadsheet, with a specified range,
     * then saves that data to {@link Model#data}
     * @param range The range of values to read
     * @param spreadsheetId The ID of the spreadsheet to read from
     * @return A {@link LakeCollection} object filled with the read data
     * @see Sheets
     * */
    public LakeCollection readDataFromSpreedSheet(final String spreadsheetId, final String range) throws java.io.IOException {

        //Create a sheet builder to contact server and interact with it
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
        //Create and send query for data, returns metadata + data
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        //Input the data into the LakeCollection object
        for (List<Object> row : response.getValues())
            this.data.add(row);
        return data;
    }
    /**
     * @return The data saved by {@link Model#readDataFromSpreedSheet(String, String)}
     * */
    public LakeCollection getData(){
        return this.data;
    }


}