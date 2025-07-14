package com.atguigu.stduy.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author:  weizirui
 * @ Date  :  20:24 2025/7/14
 */

@Configuration
public class LLMConfig {
    @Bean(name = "qwen")
    public ChatModel chatModelQwen() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASH_SCOPE_API_KEY"))
                .modelName("qwen-plus")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();

    }

    @Bean(name = "deepseek")
    public ChatModel chatModelDeepSeek()
    {
        return
                OpenAiChatModel.builder()
                        .apiKey(System.getenv("DEEP_SEEK_API_KEY"))
                        .modelName("deepseek-chat")
                        //.modelName("deepseek-reasoner")
                        .baseUrl("https://api.deepseek.com/v1")
                        .build();
    }
}


