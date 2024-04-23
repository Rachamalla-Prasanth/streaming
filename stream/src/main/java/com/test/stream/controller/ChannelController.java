package com.test.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.test.stream.service.AWSMediaLiveServiceLatest;


@CrossOrigin("*")
@RestController("v1/channel")
public class ChannelController {
	
	@Autowired
	AWSMediaLiveServiceLatest awsMediaLiveService;
	
	@GetMapping(value = "/createInput", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createInput(
			@RequestHeader(required = true, value = "Authorization") String authorization) {
		awsMediaLiveService.createInput();

	}

}
