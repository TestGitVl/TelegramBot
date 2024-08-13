package Less_TelegramBot.Bot_3;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi =
                    new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBoT_3());
            System.out.println("Бот запущен корректно!");

        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
