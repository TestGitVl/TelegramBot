package Less_TelegramBot.Bot_6.VoiceBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

public class TelegramBoT_7 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            if (messageText.startsWith("/start")) {
                sendTextMessage("Я могу отправить музыку голосовым сообщением:\n" +
                        "/L - LowRoar\n" +
                        "/C - Cuphead\n",chatId);
            }

            else if (messageText.startsWith("/C")) {
                InputFile file = new InputFile(new File("C:\\Users\\Admin\\Desktop\\Samara2024_01\\src\\main\\java\\Less_TelegramBot\\Bot_6\\VoiceBot\\Voice\\Cuphead - The King's Court.mp3"));
                sendVoiceMessage(chatId, file, "Голосовая Low Roar");
            }
            else if (messageText.startsWith("/L")) {
                InputFile file = new InputFile(new File("C:\\Users\\Admin\\Desktop\\Samara2024_01\\src\\main\\java\\Less_TelegramBot\\Bot_6\\VoiceBot\\Voice\\Low Roar - Poznan.mp3"));
                sendVoiceMessage(chatId, file, "Голосовая Cuphead");
            }

            else {
                sendTextMessage("Неизвестная команда, отправьте /start", chatId);
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

    private void sendVoiceMessage(String chatId, InputFile file, String text){
        SendVoice sendVoice = new SendVoice(chatId, file);
        sendVoice.setCaption(text);

        try {
            execute(sendVoice);
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
