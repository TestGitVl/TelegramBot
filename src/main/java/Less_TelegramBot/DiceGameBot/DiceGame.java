package Less_TelegramBot.DiceGameBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Dice;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DiceGame extends TelegramLongPollingBot {
    private HashMap<String, Integer> userLastRoll = new HashMap<>();
    private HashMap<String, Integer> botLastRoll = new HashMap<>();
    ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());

            if (messageText.startsWith("/start")) {
                sendTextMessage("Добро пожаловать в игру\nДля старта киньте кубик", chatId);
            } else {
                sendTextMessage("Я вас не понял, напишите /start", chatId);
            }

        } else if (update.hasMessage() && update.getMessage().hasDice()) {
            Dice dice = update.getMessage().getDice();

            String chatId = String.valueOf(update.getMessage().getChatId());

            userLastRoll.put(chatId, dice.getValue());

            service.schedule(() -> sendTextMessage
                    ("Вы бросили " + dice.getValue(), chatId), 4, TimeUnit.SECONDS);

            service.schedule(() -> rollBotDice(chatId), 4, TimeUnit.SECONDS);
        }
    }

    private void rollBotDice(String chatId) {
        SendDice sendDice = new SendDice(chatId);
        try {
            execute(sendDice);
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.schedule(() -> checkWinner(chatId), 4, TimeUnit.SECONDS);
    }

    private void checkWinner(String chatId) {
        int userRoll = userLastRoll.getOrDefault(chatId, 0);
        int botRoll = botLastRoll.getOrDefault(chatId, 0);

        if (userRoll > botRoll) {
            sendTextMessage("Поздравляю! Вы победили", chatId);
        } else if (botRoll > userRoll) {
            sendTextMessage("Бот выиграл!", chatId);
        } else {
            sendTextMessage("Ничья!", chatId);
        }

        userLastRoll.put(chatId, 0);
        botLastRoll.put(chatId, 0);
        sendTextMessage("Для новой игры, отправьте кубик боту", chatId);
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


    @Override
    public String getBotUsername() {
        return "https://t.me/botKyrsTest23_bot";
    }

    @Override
    public String getBotToken() {
        return "7296872572:AAFC37QWgxg-xCfwkQDjyhHVCzKaPcO66Is";
    }
}
