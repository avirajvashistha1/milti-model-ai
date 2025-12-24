# milti-model-ai

Demo Spring Boot project showing basic wiring for OpenAI and Ollama models.

Run locally

1. Build:

```powershell
mvn -DskipTests package
```

2. Run:

```powershell
java -jar target\milti-model-ai-0.0.1-SNAPSHOT.jar
```

3. Health check:

```powershell
Invoke-RestMethod http://localhost:8080/ping
```

Configuration

Set `ai.openai-api-key` in `src/main/resources/application.properties` or provide it via environment variable `AI_OPENAI_API_KEY` for OpenAI calls.

Ollama should be running locally on port 11434 by default; change `ai.ollama-url` if needed.

Notes

- This project includes sample RestTemplate-based calls in `ModelClientService`. You can replace them with Spring AI starters once you're ready to use the official Spring AI integration.

