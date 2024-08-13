package Less_TelegramBot.Bot_6.AudioBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

public class TelegramBoT_6 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            if (messageText.startsWith("/start")) {
                sendTextMessage("Я музыкальный бот, вот что у меня есть:" +
                        "/LowRoar - Ponzar\n" +
                        "/Cuphead - The King's Count\n", chatId);
            } else if (messageText.startsWith("/LowRoar")) {
                InputFile audio = new InputFile(new File("C:\\Users\\Admin\\Desktop\\Samara2024_01\\src\\main\\java\\Less_TelegramBot\\Bot_6\\Audio\\Low Roar - Poznan.mp3"));
                sendAudioMessage(chatId, audio, "LowRoar - Ponzar");

            } else if (messageText.startsWith("/Cuphead")) {
                InputFile audio = new InputFile(new File("C:\\Users\\Admin\\Desktop\\Samara2024_01\\src\\main\\java\\Less_TelegramBot\\Bot_6\\Audio\\Cuphead - The King's Court.mp3"));
                sendAudioMessage(chatId, audio, "Cuphead - The King's Count");

            } else {
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

    private void sendAudioMessage(String chatId, InputFile audio, String text ) {
        SendAudio sendAudio = new SendAudio(chatId, audio);
        sendAudio.setCaption(text);

        try {
            execute(sendAudio);
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
