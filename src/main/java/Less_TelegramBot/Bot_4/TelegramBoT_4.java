package Less_TelegramBot.Bot_4;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

public class TelegramBoT_4 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            if (messageText.startsWith("/start")){
                sendMessage("Я Фото-Бот, напиши мне животное " +
                        "и я отправлю его картинку:\n/dog\n/cat\n", chatId);

            } else if (messageText.startsWith("/cat")){
                String text = "Канадский сфинкс — одна из нескольких бесшерстных пород кошек.";
                InputFile inputFile = new InputFile(new File
                        ("C:\\Users\\Paddeus\\Desktop\\Java_Сов\\photo\\cat.jpg"));
                sendPhoto(inputFile, chatId, text);

            }else if (messageText.startsWith("/dog")){

                String text = "Бультерьер — порода собак, относящаяся к группе терьеров.";
                InputFile inputFile = new InputFile(new File
                        ("C:\\Users\\Paddeus\\Desktop\\Java_Сов\\photo\\dog.png"));
                sendPhoto(inputFile, chatId, text);

            }else {
                sendMessage("Я вас не понял, напиши /start", chatId);
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

    private void sendPhoto(InputFile file, String chatId, String caption){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(file);
        sendPhoto.setCaption(caption);

        try {
            execute(sendPhoto);
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
