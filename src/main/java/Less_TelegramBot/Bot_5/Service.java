package Less_TelegramBot.Bot_5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Service {
    private Map<String, List<String>> queteService;

    public Service() {
        queteService = new HashMap<>();

        queteService.put("Типы данных",
                List.of(
                        "int (Integer) - целочисленный тип данных",
                        "double (Double) - дробный тип данных",
                        "boolean (Boolean) - логический тип данных",
                        "String - класс, строчный тип данных"
                ));

        queteService.put("Парадигмы ООП",
                List.of(
                        "Инкапсуляция — это процесс сокрытия внутренних деталей реализации объекта и предоставления внешнему миру только необходимых методов для взаимодействия с объектом.",
                        "Наследование - можно расширить функционал уже имеющихся классов за счет добавления нового функционала или изменения старого.",
                        "Полиморфизм – это способность программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе этого объекта."
                ));

    }

    public String getQuoteService(String srt){
        List<String> quotes = queteService.get(srt);
        if (quotes != null && !quotes.isEmpty()) {
            Random random = new Random();
            return quotes.get(random.nextInt(quotes.size()));
        }else {
            return "Такой информации нет";
        }
    }

}
