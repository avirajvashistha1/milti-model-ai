package io.aviraj.multimodel;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ModelClientService {

    private final ModelProperties properties;
    private final RestTemplate rest = new RestTemplate();

    public ModelClientService(ModelProperties properties) {
        this.properties = properties;
    }

    public String callOpenAi(String prompt) {
        String url = properties.getOpenaiUrl() + "/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (properties.getOpenaiApiKey() != null) {
            headers.setBearerAuth(properties.getOpenaiApiKey());
        }

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", new Object[] { Map.of("role", "user", "content", prompt) });

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> resp = rest.exchange(url, HttpMethod.POST, request, Map.class);
        if (resp.getStatusCode().is2xxSuccessful() && resp.getBody() != null) {
            Object choices = resp.getBody().get("choices");
            return choices != null ? choices.toString() : resp.getBody().toString();
        }
        return "";
    }

    public String callOllama(String model, String prompt) {
        String url = properties.getOllamaUrl() + "/api/generate";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        body.put("prompt", prompt);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> resp = rest.exchange(url, HttpMethod.POST, request, Map.class);
        if (resp.getStatusCode().is2xxSuccessful() && resp.getBody() != null) {
            Object text = resp.getBody().get("text");
            return text != null ? text.toString() : resp.getBody().toString();
        }
        return "";
    }
}

