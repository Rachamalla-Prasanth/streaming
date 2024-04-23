package com.test.stream.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.medialive.MediaLiveClient;

@Configuration
public class MediaLiveConfig {

	@Value("${aws.accessKey}")
	private String awsAccessKey;

	@Value("${aws.secretKey}")
	private String awsSecretKey;

	@Value("${aws.region}")
	private String awsRegion;


	@Bean
	public MediaLiveClient getMediaLiveClient() {
		DefaultCredentialsProvider defaultCredentialsProvider = DefaultCredentialsProvider.builder().build();
		return MediaLiveClient.builder().credentialsProvider(defaultCredentialsProvider).build();
	}

}
