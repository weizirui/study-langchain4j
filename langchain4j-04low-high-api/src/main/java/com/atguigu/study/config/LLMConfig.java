package com.atguigu.study.config;

import com.atguigu.study.service.ChatAssistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyybs@126.com
 * @Date 2025-05-27 22:04
 * @Description: 知识出处 https://docs.langchain4j.dev/get-started
 */
@Configuration
public class LLMConfig {
    @Bean(name = "qwen")
    public ChatModel chatModelQwen() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASH_SCOPE_API_KEY"))
                .modelName("qwen-plus")
                .logRequests(true)
                .logResponses(true)
                .maxRetries(3)
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * @Description: 知识出处，https://api-docs.deepseek.com/zh-cn/
     * @Auther: zzyybs@126.com
     */
    @Bean(name = "deepseek")
    public ChatModel chatModelDeepSeek() {
        return
                OpenAiChatModel.builder()
                        .apiKey(System.getenv("DEEP_SEEK_API_KEY"))
                        .modelName("deepseek-chat")
                        //.modelName("deepseek-reasoner")
                        .baseUrl("https://api.deepseek.com/v1")
                        .build();
    }


    // High-Api https://docs.langchain4j.dev/tutorials/ai-services#simplest-ai-service
    @Bean
    public ChatAssistant chatAssistant(@Qualifier("qwen") ChatModel chatModelQwen) {
        return AiServices.create(ChatAssistant.class, chatModelQwen);
    }
}
