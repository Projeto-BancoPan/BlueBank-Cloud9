package com.bancopan.cloud9.bluebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.sns.model.PublishRequest;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class AwsSnsSmsController {
	@Autowired
	private AmazonSNSClient snsClient;

	String TOPIC_ARN = "arn:aws:sns:us-east-2:965934840569:Joao_erro";

	@GetMapping("/api/Verificar_email")
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
		snsClient.subscribe(request);
		return "Sua inscrição no Blue Bank está pendente. Verifique seu e-mail para continuar:" + email;
	}

	@GetMapping("/api/enviarNotificacao")
	public String publishMessageToTopic() {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(), "Notification: Network connectivity issue");
		snsClient.publish(publishRequest);
		return "Notificação enviada com sucesso!";
	}
	
	private String buildEmailBody(){
		return "Seu cadastro já está com o BlueBank!,\n" +
				"\n" +
				"\n" +
				"Você já faz parte do Blue Bank. Estamos muito felizes que você esteja fazendo parte disso com a gente!";
	}
}
