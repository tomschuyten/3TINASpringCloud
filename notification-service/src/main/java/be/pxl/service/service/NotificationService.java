package be.pxl.service.service;

import be.pxl.service.domain.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    /**
     * Fe using a Mail API to send the notification would be applicable.
     *
     * @param notification
     */
    public void sendMessage(Notification notification) {

        // JavaMail

        log.info("Receiving notification...");
        log.info("Sending... {}", notification.getMessage());
        log.info("TO {}", notification.getSender());
    }
}
