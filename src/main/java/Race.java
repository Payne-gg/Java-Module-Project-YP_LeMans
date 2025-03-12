import java.util.ArrayList;
import java.util.List;

class Race {
    private List<String> leaders;    // Список лидеров
    private int leaderDistance;      // Максимальная дистанция
    
    public Race() {
        this.leaders = new ArrayList<>();  // Инициализируем список
        this.leaderDistance = 0;          // Начальная дистанция - 0
    }
    
    public void updateLeader(Car car) {
        int distance = car.getSpeed() * 24;  // Расчет дистанции
        
        if (distance > leaderDistance) {
            // Новый лидер с большей дистанцией
            leaders.clear();               // Очищаем старых лидеров
            leaders.add(car.getName());    // Добавляем нового
            leaderDistance = distance;     // Обновляем дистанцию
        } else if (distance == leaderDistance) {
            // Еще один лидер с такой же дистанцией
            leaders.add(car.getName());    // Добавляем в список
        }
    }
    
    public List<String> getLeaders() {
        return leaders;
    }
}