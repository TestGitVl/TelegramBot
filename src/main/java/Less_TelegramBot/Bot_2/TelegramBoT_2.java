package Less_TelegramBot.Bot_2;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.security.SecureRandom;

public class TelegramBoT_2 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            String response;
            try {
                int length = Integer.parseInt(messageText.trim());

                if (length < 8){
                    response = "Пароль должен быть хотя бы в 8 символ";
                    sendMessage(response, chatId);
                } else {
                    String password = generateRandomPassword(length); //ф-я
                    response = "Ваш случайный пароль: " + password;

                    sendMessage(response, chatId);
                }
            } catch (Exception e){
                e.printStackTrace();
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

    private String generateRandomPassword(int length){
        String character = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890!@#$%^&*()_+-=[]{};':<>?,./";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);


        for (int i = 0; i < length; i++){
            int index = random.nextInt(character.length());
            sb.append(character.charAt(index));
        }
        return sb.toString();
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
