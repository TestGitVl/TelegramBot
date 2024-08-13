package Less_TelegramBot.Bot_5;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot_5 extends TelegramLongPollingBot {

    Service service = new Service();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String textMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            if (textMessage.startsWith("/start")){
                sendTextMessage(chatId, "Для получения информации, отправь /data [тема]");

            }else if (textMessage.startsWith("/data")){
                String[] parts = textMessage.split(" ", 2);
                if (parts.length == 2){
                    String data = parts[1];
                    String text = service.getQuoteService(data);
                    sendTextMessage(chatId, text);
                }
            }else {
                sendTextMessage(chatId, "Неизвестная команда, напиши /start");
            }
        }
    }

    private void sendTextMessage(String chatId, String textMessage) {
        SendMessage sendMessage = new SendMessage(chatId, textMessage);
        try {
           execute(sendMessage);
        }catch (Exception e){
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
