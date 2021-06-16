package org.game.bot.controller;

import org.game.bot.RoosterAbuserBot;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {
    private final RoosterAbuserBot roosterAbuserBot;

    public WebHookController(RoosterAbuserBot roosterAbuserBot) {
        this.roosterAbuserBot = roosterAbuserBot;
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return roosterAbuserBot.onWebhookUpdateReceived(update);
    }
}