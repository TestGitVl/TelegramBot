package Less_TelegramBot.Bot_3;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.security.SecureRandom;

public class TelegramBoT_3 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            if (messageText.startsWith("/roll")){
                sendDice(chatId);
            }else {
                sendMessage(chatId, "Неизвестная команда, попробуй /roll");
            }

        }
    }

    private void sendMessage(String message, String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        try {
            execute(sendMessage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void sendDice(String chatId){
        SendDice sendDice = new SendDice(chatId);
        try {
            execute(sendDice);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "https://t.me/botKyrsTest23_bot";
    }

    @Override
    public String getBotToken() {
        return "7296872572:AAFC37QWgxg-xCfwkQDjyhHVCzKaPcO66Is";
    }
}
