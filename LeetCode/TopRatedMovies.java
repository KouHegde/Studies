package org.example.Study.LeetCode;

import java.util.*;

public class TopRatedMovies {

    private class Movie{
        public String name;
        public int rating;
        public List<Movie> relatives;
    }



    public List<Movie> topRelatedMovies(Movie first, int k) {
        Set<String> visitedMovieNames = new HashSet<>();
        Queue<Movie> q = new LinkedList<>();

        PriorityQueue<Movie> topRelatives =
                new PriorityQueue<>(Comparator.comparingInt(movie -> movie.rating));

        q.offer(first);
        visitedMovieNames.add(first.name);

        while (!q.isEmpty()) {
            Movie curr = q.poll();

            for (Movie relative : curr.relatives) {

                if (visitedMovieNames.add(relative.name)) {

                    if (topRelatives.size() < k) {
                        topRelatives.offer(relative);
                    } else if (relative.rating > topRelatives.peek().rating) {
                        topRelatives.poll();
                        topRelatives.offer(relative);
                    }

                    q.offer(relative);
                }
            }
        }

        List<Movie> result = new ArrayList<>();

        while (!topRelatives.isEmpty()) {
            result.add(topRelatives.poll());
        }

        Collections.reverse(result);

        return result;
    }
}
