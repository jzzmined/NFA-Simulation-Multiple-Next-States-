package LabActivity;

import java.util.*;

public class LabActivity2_NFA {

    private Map<String, Map<Character, Set<String>>> transitions;
    private String startState;
    private Set<String> acceptanceStates;

    public LabActivity2_NFA() {
        transitions = new HashMap<>();
        acceptanceStates = new HashSet<>();
        buildNFA();
    }

    private void buildNFA() {
        startState = "q0";
        acceptanceStates.add("q2");

        // q0 Transition
        Map<Character, Set<String>> q0Trans = new HashMap<>();
        q0Trans.put('a', new HashSet<>(Arrays.asList("q0", "q1"))); // non-deterministic: stay or move
        q0Trans.put('b', new HashSet<>(Arrays.asList("q0")));
        transitions.put("q0", q0Trans);

        // q1 Transition
        Map<Character, Set<String>> q1Trans = new HashMap<>();
        q1Trans.put('a', new HashSet<>(Arrays.asList("q0", "q1")));
        q1Trans.put('b', new HashSet<>(Arrays.asList("q0", "q2")));
        transitions.put("q1", q1Trans);

        // q2 Transition
        Map<Character, Set<String>> q2Trans = new HashMap<>();
        q2Trans.put('a', new HashSet<>(Arrays.asList("q2")));
        q2Trans.put('b', new HashSet<>(Arrays.asList("q2")));
        transitions.put("q2", q2Trans);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LabActivity2_NFA nfa = new LabActivity2_NFA();

        while (true) {
            System.out.println("\n---NFA String Acceptance Checker---");
            System.out.print("Enter a string (or type 'exit' to quit): ");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            if (!nfa.isValidInput(input)) {
                System.out.println("Error: Invalid input! Please enter only 'a' and 'b' characters.");
                continue;
            }

            boolean accepted = nfa.simulateQueue(input);
            System.out.println("Output: " + (accepted ? "Accepted" : "Rejected"));
        }

        scan.close();
    }

    public boolean simulateQueue(String input) {
        Set<String> currentStates = new HashSet<>();
        currentStates.add(startState);

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            Set<String> nextStates = new HashSet<>();

            for (String state : currentStates) {
                nextStates.addAll(getNextStates(state, symbol));
            }

            currentStates = nextStates;
        }

        for (String state : currentStates) {
            if (acceptanceStates.contains(state)) {
                return true;
            }
        }

        return false;
    }

    private Set<String> getNextStates(String state, char symbol) {
        if (transitions.containsKey(state)) {
            Map<Character, Set<String>> stateTrans = transitions.get(state);
            if (stateTrans.containsKey(symbol)) {
                return new HashSet<>(stateTrans.get(symbol));
            }
        }
        return new HashSet<>();
    }

    private boolean isValidInput(String input) {
        return input != null && !input.isEmpty() && input.matches("[ab]+");
    }
}
