package Less_TelegramBot.Bot_4;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi =
                    new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBoT_4());
            System.out.println("Бот запущен корректно!");

        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
