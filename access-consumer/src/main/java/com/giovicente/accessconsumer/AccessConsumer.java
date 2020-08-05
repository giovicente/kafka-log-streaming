package com.giovicente.accessconsumer;

import com.giovicente.accessproducer.Access;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class AccessConsumer {

    @KafkaListener(topics = "spec3-giovanni-vicente-1", groupId = "giovanni-1")
    public void receive(@Payload Access access) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        // Just a print to certificate that the message was received
        System.out.println("Message received!");
        generateAccessLogsFile(access);
    }

    public void generateAccessLogsFile(Access access) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        String isAccessAlowed = String.valueOf(access.isAccessAllowed());

        AccessCsv accessCsv = new AccessCsv(access.getCustomerId(), access.getDoorId(), isAccessAlowed, access.getAccessDate());

        Writer writer = Files.newBufferedWriter(Paths.get("access-log.csv"));
        StatefulBeanToCsv<AccessCsv> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(accessCsv);

        writer.flush();
        writer.close();
    }

}
