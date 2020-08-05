package com.giovicente.accessproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class AccessController {

    @Autowired
    private AccessProducer accessProducer;

    @GetMapping("/{customerId}/{doorId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void verifyAccess(@PathVariable(name = "customerId") long customerId, @PathVariable(name = "doorId") long doorId) {
        Access access = new Access();
        access.setCustomerId(customerId);
        access.setDoorId(doorId);

        accessProducer.sendToKafka(access);
    }

}
