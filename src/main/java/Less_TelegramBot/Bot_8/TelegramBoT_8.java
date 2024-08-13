package Less_TelegramBot.Bot_8;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

public class TelegramBoT_8 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            if (messageText.startsWith("/contact")) {
             sendContactMessage(chatId, "Vlad", "Vladislav", "9-999-999-99-99");
            }
            else {
                sendTextMessage("Неизвестная команда, отправьте /contact", chatId);
            }
        }
    }

    private void sendTextMessage(String message, String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendContactMessage(String chatId, String firstNane, String lastName, String number){
        SendContact sendContact = new SendContact();
        sendContact.setChatId(chatId);
        sendContact.setFirstName(firstNane);
        sendContact.setLastName(lastName);
        sendContact.setPhoneNumber(number);

        try {
            execute(sendContact);
        } catch (Exception e) {
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
