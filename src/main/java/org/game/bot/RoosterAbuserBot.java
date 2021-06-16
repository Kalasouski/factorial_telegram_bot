package org.game.bot;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.math.BigInteger;

@Getter
@Setter
public class RoosterAbuserBot extends TelegramWebhookBot {

    private String webHookPath;
    private String botUserName;
    private String botToken;

    public RoosterAbuserBot(DefaultBotOptions botOptions){
        super(botOptions);
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if(update.getMessage()==null || !update.getMessage().hasText())
            return null;
        try{
            String inputText = update.getMessage().getText();
            String reply = parseCommand(inputText);
            execute(new SendMessage(update.getMessage().getFrom().getId().toString(),reply));
        } catch (TelegramApiException e) {

            e.printStackTrace();
        }
        return null;
    }

    String parseCommand(String inputText){
        int number;
        try{
            number = Integer.parseInt(inputText);
        }
        catch(Exception e){
            return "Uh, no";
        }
            return factorial(number).toString();

    }

    public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        } return factorial;
    }


    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }
}
