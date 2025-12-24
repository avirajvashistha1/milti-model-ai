package io.aviraj.multimodel.service;

import io.aviraj.multimodel.config.ModelProperties;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ModelClientService {

    private final ModelProperties properties;
    private final ChatClient chatClient;

    public ModelClientService(ChatClient.Builder chatClientBuilder, ModelProperties properties) {
        this.chatClient = chatClientBuilder.build();
        this.properties = properties;
    }

    public String callOpenAi(String prompt) {
        String effective = prompt != null ? prompt : "";
        return chatClient.prompt(effective).call().content();
    }

    public String callOllama(String model, String prompt) {
        String effective = (model != null ? "Model: " + model + "\n" : "") + (prompt != null ? prompt : "");
        return chatClient.prompt(effective).call().content();
    }
}
