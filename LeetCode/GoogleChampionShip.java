package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoogleChampionShip {

    public static int f(int p1, int p2){
        return 1;
    }
    public static int championship(int n) {

        List<Integer> players = new ArrayList<>();

        for (int player = 1; player <= n; player++) {
            players.add(player);
        }

        while (players.size() > 1) {

            List<Integer> winners = new ArrayList<>();

            for (int i = 0; i < players.size(); i += 2) {

                if (i + 1 >= players.size()) {
                    winners.add(players.get(i));
                    continue;
                }

                int player1 = players.get(i);
                int player2 = players.get(i + 1);

                winners.add(f(player1, player2));
            }

            players = winners;
        }

        return players.get(0);
    }
}
