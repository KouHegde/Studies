package org.example.Study.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class SolutionForSignBoard {
    public static void main(String[] args) {

        int defaultSpeed = 55;
        int cityLimit = 45;
        int schoolLimit = 25;

        List<String> signposts = Arrays.asList(
                "DefaultSpeed", "City", "School",
                "EndSchool", "EndCity", "Construction",
                "City", "EndCity", "EndConstruction",
                "RestArea", "EndRestArea"
        );

        Stack<Integer> stack = new Stack<>();
        int currentSpeed = defaultSpeed;

        for (String sign : signposts) {

            switch (sign) {

                case "DefaultSpeed":
                    currentSpeed = defaultSpeed;
                    stack.clear();
                    break;

                case "City":
                    stack.push(currentSpeed);
                    currentSpeed = cityLimit;
                    break;

                case "School":
                    stack.push(currentSpeed);
                    currentSpeed = schoolLimit;
                    break;

                case "Construction":
                    stack.push(currentSpeed);
                    currentSpeed /= 2;
                    break;

                case "RestArea":
                    stack.push(currentSpeed);
                    break;

                case "EndSchool":
                case "EndCity":
                case "EndConstruction":
                case "EndRestArea":
                    if (!stack.isEmpty()) {
                        currentSpeed = stack.pop();
                    }
                    break;
            }

            System.out.println(sign + " -> " + currentSpeed);
        }
    }
}
    }
}