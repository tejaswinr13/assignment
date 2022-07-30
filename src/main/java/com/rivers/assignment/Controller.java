package com.rivers.assignment;

import com.ibm.gbs.schema.Balance;
import com.ibm.gbs.schema.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/service")
public class Controller {
    @Autowired
    private KafkaTemplate<String, Customer> customerKafkaTemplateTemplate;
    private KafkaTemplate<String, Balance> stringBalanceKafkaTemplatekafkaTemplate;
    private KafkaTemplate<String, String> stringKafkaTemplate;

    public Controller(KafkaTemplate<String, Customer> customerKafkaTemplateTemplate,
                      KafkaTemplate<String, Balance> stringBalanceKafkaTemplatekafkaTemplate,
                      KafkaTemplate<String, String> stringKafkaTemplate) {
        this.customerKafkaTemplateTemplate = customerKafkaTemplateTemplate;
        this.stringBalanceKafkaTemplatekafkaTemplate = stringBalanceKafkaTemplatekafkaTemplate;
        this.stringKafkaTemplate = stringKafkaTemplate;
    }

    @PostMapping(value = "/customer")
    public String sendCustomer(String message){

        return "OK";
    }

    @PostMapping(value = "/balance")
    public String sendBalance(String message){
        return "OK";
    }

    @GetMapping(value = "/test")
    public String test(String message){
        stringKafkaTemplate.send("test-topic", UUID.randomUUID().toString());

        return "OK";
    }
}
