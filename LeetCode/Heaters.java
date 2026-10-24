package org.example.Study.LeetCode;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0; // pointer for heaters
        int radius = 0;

        for (int house : houses) {

            while (i < heaters.length - 1 &&
                    Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }


            radius = Math.max(radius, Math.abs(heaters[i] - house));
        }

        return radius;

    }
}
