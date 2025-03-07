package mobile.parser;

import java.util.*;

public class QueryParser {
    public List<String> toPolishNotation(String query) {
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("|", 1);
        precedence.put("&", 2);
        precedence.put("=", 3);
        precedence.put("<", 3);
        precedence.put(">", 3);

        Stack<String> operators = new Stack<>();
        List<String> output = new ArrayList<>();

        String[] tokens = query.split(" ");

        for (String token : tokens) {
            if (token.matches("[a-zA-Z]+") || token.matches("'[^\"]*'") || token.matches("\\d+")) { // Identifiers, string literals, or numbers
                output.add(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop(); // Pop the "(" from the stack
            } else { // The token is an operator
                while (!operators.isEmpty() && precedence.getOrDefault(operators.peek(), 0) >= precedence.get(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output.reversed();
    }
}
