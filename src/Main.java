import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
    private static final List<String> NAMES = List.of(
            "Покупатель 11",
            "Покупатель 1",
            "Покупатель 2",
            "Покупатель 3",
            "Покупатель 4",
            "Покупатель 5",
            "Покупатель 6",
            "Покупатель 7",
            "Покупатель 8",
            "Покупатель 9",
            "Покупатель 10"
    );
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE=5;

    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        System.out.println("ПЕрвая очередь"+queue1);
        System.out.println("Вторая очередь"+queue2);
        System.out.println();

        add("Марина",queue1,queue2);
        System.out.println("ПЕрвая очередь"+queue1);
        System.out.println("Вторая очередь"+queue2);
        System.out.println();
    }
    private static void add(String name,
                            Queue<String> queue1,
                            Queue<String> queue2) {
        if (queue1.size()==MAX_SIZE && queue2.size()==MAX_SIZE) {
            System.out.println("Нужно позвать Галю!");
            return;
        }
        if (queue1.size()<queue2.size()) {
            queue1.offer(name);
        } else if (queue2.size()<queue1.size()) {
            queue2.offer(name);
        }
    }
    private static void randomFilling(Queue<String> queue) {
        int size = RANDOM.nextInt(6);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }
}