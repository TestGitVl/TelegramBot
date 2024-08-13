package Less_TelegramBot.Bot_8;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi =
                    new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBoT_8());
            System.out.println("Бот запущен корректно!");

        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
