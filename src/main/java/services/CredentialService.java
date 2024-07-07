package services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

/**
 * Service to get the {@link Credential} needed to access the Sheets
 *
 * @author Maya, Tamim
 * */
public class CredentialService {
    /**  The scopes to authorize the credentials for */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String KEY_FILE_LOCATION = "/credentials/safelake-21dfd4c5460a.p12";
    private static final String SERVICE_ACCOUNT_EMAIL = "safelakeclient@safelake.iam.gserviceaccount.com";

    /**
     * Creates an authorized Credential object using a p12 file
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    public Credential getCredentials(final HttpTransport HTTP_TRANSPORT) throws URISyntaxException, IOException, GeneralSecurityException {
        // Construct a GoogleCredential object with the service account email
        // and p12 file downloaded from the developer console.
        InputStream inputStream = this.getClass().getResourceAsStream(KEY_FILE_LOCATION);
        return new Builder()
                .setTransport(HTTP_TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                .setServiceAccountPrivateKeyFromP12File(inputStream)
                .setServiceAccountScopes(SCOPES)
                .build();
    }
}
