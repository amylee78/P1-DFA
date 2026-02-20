package fa.dfa;

import fa.State;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

/**
 * Implementation of a Deterministic Finite Automaton (DFA).
 * A DFA is defined by the 5-tuple (Q, Σ, δ, q0, F) where:
 * - Q is a finite set of states
 * - Σ is a finite alphabet
 * - δ is the transition function: Q × Σ → Q
 * - q0 is the start state
 * - F is the set of final/accepting states
 *
 * This implementation uses LinkedHashSet to preserve insertion order
 * for states and alphabet symbols, as required by the specification.
 *
 * @author Maria Gomez Baeza, Amy  Lee
 */
public class DFA implements DFAInterface {

   
    private Set<DFAState> Q;
    private Set<Character> sigma;
    private Set<DFAState> F;
    private Map<String, DFAState> stateMap;
    private DFAState q0;


  
    public DFA() {
        Q = new LinkedHashSet<>();
        sigma = new LinkedHashSet<>();
        F = new LinkedHashSet<>();
        stateMap = new HashMap<>();
        q0 = null;
    }

    /**
     * Adds a state to the DFA.
     *
     * @param name the name of the state to add
     * @return true if the state was added successfully,
     *         false if a state with this name already exists
     */
    @Override
    public boolean addState(String name) {
        // Check if state already exists
        if (stateMap.containsKey(name)) {
            return false;
        }

        // Create new state and add to collections
        DFAState newState = new DFAState(name);
        Q.add(newState);
        stateMap.put(name, newState);
        return true;
    }

    /**
     * Sets the start state of the DFA.
     *
     * @param name the name of the state to set as start state
     * @return true if successful, false if the state doesn't exist
     */
    @Override
    public boolean setStart(String name) {
        DFAState state = stateMap.get(name);
        if (state == null) {
            return false;
        }
        q0 = state;
        return true;
    }

    /**
     * Marks a state as a final (accepting) state.
     *
     * @param name the name of the state to mark as final
     * @return true if successful, false if the state doesn't exist
     */
    @Override
    public boolean setFinal(String name) {
        DFAState state = stateMap.get(name);
        if (state == null) {
            return false;
        }
        
        F.add(state);
        return true;
    }

    /**
     * Adds a symbol to the DFA's alphabet.
     *
     * @param symbol the symbol to add to the alphabet
     */
    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    /**
     * Adds a transition to the DFA's delta data structure.
     * The transition goes from fromState to toState on input symbol onSymb.
     *
     * @param fromState the label of the state where the transition starts
     * @param toState the label of the state where the transition ends
     * @param onSymb the symbol from the DFA's alphabet
     * @return true if successful, false if one of the states doesn't exist
     *         or the symbol is not in the alphabet
     */
    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        // Get the state objects
        DFAState from = stateMap.get(fromState);
        DFAState to = stateMap.get(toState);

        // Validate: both states must exist and symbol must be in alphabet
        if (from == null || to == null || !sigma.contains(onSymb)) {
            return false;
        }

        // Add the transition
        from.addTransition(onSymb, to);
        return true;
    }

    /**
     * Determines if a string is accepted by this DFA.
     * A string is accepted if, starting from the start state and
     * following transitions for each symbol, we end in a final state.
     *
     * Special case: the string "e" represents the empty string (epsilon).
     *
     * @param s the string to test
     * @return true if the string is accepted, false otherwise
     */
    @Override
    public boolean accepts(String s) {

        //if there is no start state return false
        if (q0 == null) 
        {
            return false;
        }
        // Start at the start state
        DFAState currentState = q0;

        // Handle empty string (represented as "e")
        if (s.equals("e")) {
            return currentState != null && F.contains(currentState);
        }

        // Process each character in the string
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);

            // Get the next state based on current state and symbol
            DFAState nextState = currentState.getTransition(symbol);

            // If no transition exists, reject the string
            if (nextState == null) {
                return false;
            }

            // Move to the next state
            currentState = nextState;
        }

        // Accept if we end in a final state
        return F.contains(currentState);
    }

    /**
     * Returns the alphabet of the DFA.
     *
     * @return a Set containing all symbols in the alphabet
     */
    @Override
    public Set<Character> getSigma() {
        return new LinkedHashSet<>(sigma);
    }

    /**
     * Returns state with the given name, or null if none exists.
     *
     * @param name the name of the state
     * @return the State object with that name, or null if no such state exists
     */
    @Override
    public State getState(String name) {
        return stateMap.get(name);
    }

    /**
     * Checks if a state is a final (accepting) state.
     *
     * @param name the name of the state to check
     * @return true if the state exists and is final, false otherwise
     */
    @Override
    public boolean isFinal(String name) {
        DFAState state = stateMap.get(name);
        if (state == null) {
            return false;
        }
        // Check if the state is in the F (final states) set
        return F.contains(state);
    }

    /**
     * Checks if a state is the start state.
     *
     * @param name the name of the state to check
     * @return true if the state exists and is the start state, false otherwise
     */
    @Override
    public boolean isStart(String name) {
        DFAState state = stateMap.get(name);
        if (state == null || q0 == null) {
            return false;
        }
        return state.equals(q0);
    }

    /**
     * Creates a deep copy of this DFA with transition labels
     * swapped between symbols symb1 and symb2.
     *
     * For example, if this DFA has a transition from state A to state B
     * on symbol 'a', and a transition from B to A on symbol 'b',
     * the swapped DFA will have a transition from A to B on 'b' and
     * from B to A on 'a'.
     *
     * @param symb1 the first symbol to swap
     * @param symb2 the second symbol to swap
     * @return a new DFA that is a copy of this DFA with swapped symbols
     */
    @Override
    public DFA swap(char symb1, char symb2) {

        if (!sigma.contains(symb1) || !sigma.contains(symb2)) {
        // Returns null if either symbol is not in the alphabet
        return null;
        }
        // Create a new DFA
        DFA swappedDFA = new DFA();

        // Copy the alphabet
        for (Character c : sigma) {
            swappedDFA.addSigma(c);
        }

        // Copy all states (with same names)
        for (DFAState state : Q) {
            swappedDFA.addState(state.getName());
        }

        // Set the start state
        if (q0 != null) {
            swappedDFA.setStart(q0.getName());
        }

        // Set all final states
        for (DFAState finalState : F) {
            swappedDFA.setFinal(finalState.getName());
        }

        // Copy transitions with swapped symbols
        for (DFAState state : Q) {
            Map<Character, DFAState> transitions = state.getTransitions();

            for (Character symbol : transitions.keySet()) {
                DFAState toState = transitions.get(symbol);

                // Determine which symbol to use in the swapped DFA
                char newSymbol = symbol;
                if (symbol == symb1) {
                    newSymbol = symb2;
                } else if (symbol == symb2) {
                    newSymbol = symb1;
                }

                // Add the transition with the (possibly swapped) symbol
                swappedDFA.addTransition(state.getName(), toState.getName(), newSymbol);
            }
        }

        return swappedDFA;
    }

    /**
     * Constructs the textual representation of the DFA.
     *
     * Format:
     * Q = { state1 state2 ... }
     * Sigma = { sym1 sym2 ... }
     * delta =
     *      sym1 sym2 ...
     * st1  dest dest ...
     * st2  dest dest ...
     * q0 = startState
     * F = { finalState1 finalState2 ... }
     *
     * The order of states and alphabet symbols is the order in which
     * they were added to the DFA (preserved by LinkedHashSet).
     *
     * @return String representation of the DFA
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Q = { states }
        sb.append("Q = { ");
        boolean first = true;
        for (DFAState state : Q) {
            if (!first) {
                sb.append(" ");
            }
            sb.append(state.getName());
            first = false;
        }
        sb.append(" }\n");

        // Sigma = { symbols }
        sb.append("Sigma = { ");
        first = true;
        for (Character c : sigma) {
            if (!first) {
                sb.append(" ");
            }
            sb.append(c);
            first = false;
        }
        sb.append(" }\n");

        // delta = transition table
        sb.append("delta =\n\t");

        // Header row: all symbols
        for (Character c : sigma) {
            sb.append(c).append("\t");
        }
        sb.append("\n");

        // Each state's row of transitions
        for (DFAState state : Q) {
            sb.append(state.getName()).append("\t");

            // For each symbol, show the destination state
            for (Character c : sigma) {
                DFAState toState = state.getTransition(c);
                if (toState != null) {
                    sb.append(toState.getName());
                }
                sb.append("\t");
            }
            sb.append("\n");
        }

        // q0 = start state
        sb.append("q0 = ");
        if (q0 != null) {
            sb.append(q0.getName());
        }
        sb.append("\n");

        // F = { final states }
        sb.append("F = { ");
        first = true;
        for (DFAState finalState : F) {
            if (!first) {
                sb.append(" ");
            }
            sb.append(finalState.getName());
            first = false;
        }
        sb.append(" }\n");

        return sb.toString();
    }
}
