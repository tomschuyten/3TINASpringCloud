package be.pxl.service.client;

import be.pxl.service.model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service") // -> naam van de service
public interface NotificationClient {

    @PostMapping("/notification/")
    void sendNotification(@RequestBody NotificationRequest notifictionRequest);
}

