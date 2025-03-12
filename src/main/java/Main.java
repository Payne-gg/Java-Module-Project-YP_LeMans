import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.nextLine();
            while (name.trim().isEmpty()) {
                System.out.println("Название не может быть пустым. Введите название машины №" + i + ":");
                name = scanner.nextLine();
            }

            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость. Должна быть от 0 до 250");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите целое число!");
                }
            }

            Car car = new Car(name, speed);
            race.updateLeader(car);
        }

        // Вывод результата
        List<String> leaders = race.getLeaders();
        if (leaders.size() == 1) {
            System.out.println("Самая быстрая машина: " + leaders.get(0));
        } else {
            System.out.println("Самые быстрые машины:");
            for (String leader : leaders) {
                System.out.println("- " + leader);
            }
        }

        scanner.close();
    }
}