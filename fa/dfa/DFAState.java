package fa.dfa;

import java.util.LinkedHashMap;
import java.util.Map;

import fa.State;

public class DFAState extends State {


    private Map<Character, DFAState> transitions;

    public DFAState(String name) {
        super(name);
        transitions = new LinkedHashMap<>();
    }

    public void addTransition(char symbol, DFAState toState) {
        transitions.put(symbol, toState);
    }

    public DFAState getTransition(char symbol) {
        return transitions.get(symbol);
    }
}
