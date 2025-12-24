package io.aviraj.multimodel;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai")
public class ModelProperties {

    private String openaiApiKey;
    private String openaiUrl = "https://api.openai.com/v1";

    private String ollamaUrl = "http://localhost:11434";

    public String getOpenaiApiKey() {
        return openaiApiKey;
    }

    public void setOpenaiApiKey(String openaiApiKey) {
        this.openaiApiKey = openaiApiKey;
    }

    public String getOpenaiUrl() {
        return openaiUrl;
    }

    public void setOpenaiUrl(String openaiUrl) {
        this.openaiUrl = openaiUrl;
    }

    public String getOllamaUrl() {
        return ollamaUrl;
    }

    public void setOllamaUrl(String ollamaUrl) {
        this.ollamaUrl = ollamaUrl;
    }
}

