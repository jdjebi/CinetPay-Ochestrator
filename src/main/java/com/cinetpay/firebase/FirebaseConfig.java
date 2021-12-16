/**
 * @author Jean-Marc Dje Bi
 * @since 16-12-2021
 * @version 1
 */

package com.cinetpay.firebase;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

/**
 * Classe de configuration de Firebase
 */
@Configuration
public class FirebaseConfig {
	    
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

	@PostConstruct
	public void intialize() throws IOException {
		
		if (FirebaseApp.getApps().isEmpty()) {
		
			GoogleCredentials credentials = GoogleCredentials.fromStream(this.getFileStream());
			
			FirebaseOptions options = FirebaseOptions.builder()
				    .setCredentials(credentials)
				    .build();
					
            FirebaseApp.initializeApp(options);
            
        }
		
	}
	/**
	 * Retourne un stream sur le fichier de configuration
	 * @return
	 * @throws IOException
	 */
    public InputStream getFileStream() throws IOException {
		
    	ClassPathResource firebaseConfig =  new ClassPathResource(firebaseConfigPath);
				
		return firebaseConfig.getInputStream();
		
    }
}
