package com.test.stream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.medialive.MediaLiveClient;
import software.amazon.awssdk.services.medialive.model.CreateInputRequest;
import software.amazon.awssdk.services.medialive.model.CreateInputResponse;
import software.amazon.awssdk.services.medialive.model.InputDestinationRequest;
import software.amazon.awssdk.services.medialive.model.InputType;

@Service
public class AWSMediaLiveServiceLatest {
    @Autowired
    private MediaLiveClient mediaLiveClient;

    private static final String STREAM_NAME = "IPL Stream";

    public void createInput(){
        InputDestinationRequest inputDestinationRequest = InputDestinationRequest.builder().streamName(STREAM_NAME).build();
        // Create input request
        CreateInputRequest createInputRequest = CreateInputRequest.builder()
                .destinations(inputDestinationRequest)
                .inputSecurityGroups("8577703")
                .type(InputType.RTMP_PUSH)
                .name("Java Input")
                .build();

        // Send the request to AWS MediaLive to create the input
        CreateInputResponse createInput = mediaLiveClient.createInput(createInputRequest);
        String id = createInput.input().id();
        
    }
    
    public String createChannel(String inputId) {
        return null;
    }
}
