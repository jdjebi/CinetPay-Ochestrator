/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.service;

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Classe recuperant le port du serveur
 */
@Service
public class ServerPortService {
    private int port;

    public int getPort() {
        return port;
    }

    @EventListener
    public void onApplicationEvent(final ServletWebServerInitializedEvent event) {
        port = event.getWebServer().getPort();
    }
}