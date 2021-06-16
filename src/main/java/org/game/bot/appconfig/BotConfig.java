package org.game.bot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.game.bot.RoosterAbuserBot;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Getter @Setter @Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    @Bean
    public RoosterAbuserBot roosterAbuserBot(){
        DefaultBotOptions options = new DefaultBotOptions();

        RoosterAbuserBot roosterAbuserBot = new RoosterAbuserBot(options);
        roosterAbuserBot.setWebHookPath(webHookPath);
        roosterAbuserBot.setBotUserName(botUserName);
        roosterAbuserBot.setBotToken(botToken);

        return roosterAbuserBot;
    }
}