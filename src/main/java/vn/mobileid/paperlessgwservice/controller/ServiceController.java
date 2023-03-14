package vn.mobileid.paperlessgwservice.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.mobileid.paperlessgwservice.models.SigningResponse;

/**
 *
 * @author MSI-NT
 */
@RestController
@RequestMapping
public class ServiceController {

    private static final Logger logger = LogManager.getLogger(ServiceController.class);
    private static final String SIGNER_SIGNED = "signer_signed";
    private static final String SIGNING_COMPLETED = "signing_completed";
    private static final String SIGNING_ARCHIVED = "signing_archived";
    private static final String SIGNING_ARCHIVED_FAILED = "signing_archive_failed";

    @RequestMapping(value = "/postback-handler", method = RequestMethod.POST)
    public ResponseEntity<String> postbackHandler(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, ParseException, IOException {

//        logger.info("Logger: " + httpServletRequest.toString());

        // Get the request body
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        String requestBodyString = requestBody.toString();
        System.out.println(requestBodyString);

//      -> toJson() – convert java object to JSON format
//      -> fromJson() – convert JSON into java object
        Gson gson = new Gson();

        SigningResponse signingResponse = gson.fromJson(requestBodyString, SigningResponse.class);
        String action = signingResponse.getAction();
        Map result = new HashMap();
        String jsonResult = "";
        switch (action) {
            case SIGNER_SIGNED:
                result.put("message", "Document signed by one of the signers");
                jsonResult = gson.toJson(result);
                return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
            case SIGNING_COMPLETED:
                result.put("message", "Document signed by all parties");
                jsonResult = gson.toJson(result);
                return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
            case SIGNING_ARCHIVED:
                result.put("message", "Signing archived successfully");
                jsonResult = gson.toJson(result);
                return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
            case SIGNING_ARCHIVED_FAILED:
                result.put("message", "Signing archiving failed");
                jsonResult = gson.toJson(result);
                return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(requestBodyString, HttpStatus.OK);
    }

    @RestController
    @RequestMapping("/webhook")
    public class WebhookController {

        @PostMapping
        public ResponseEntity<?> handleWebhook(@RequestBody String payload) {
            logger.info("Logger: " + payload);
            System.out.println(payload);
            // Process the incoming payload here
            return ResponseEntity.ok().build();
        }
    }
}
