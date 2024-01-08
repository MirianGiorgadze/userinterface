package userinyerface.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTestDataUtils {

    public static List<Integer> getIndexListForCheckbox(int quantity, int bound, int firstIndex, int badIndex) {
        Random random = new Random();
        List<Integer> chosenNumbersList = new ArrayList<>();
        chosenNumbersList.add(firstIndex);
        for (int i = 0; i < quantity; i++) {
            int number;
            number = random.nextInt(bound) + 1;
            if (!chosenNumbersList.contains(number) && number != badIndex) {
                chosenNumbersList.add(number);
            } else {
                i -= 1;
            }
        }
        return chosenNumbersList;
    }
}
