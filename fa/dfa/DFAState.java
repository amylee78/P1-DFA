package fa.dfa;

import java.util.LinkedHashMap;
import java.util.Map;

import fa.State;

public class DFAState extends State {

    private boolean isFinal;
    private Map<Character, DFAState> transitions;

    /**
     * constructor for DFAState.
     * @param name
     */
    public DFAState(String name) {
        super(name);
        this.isFinal = false;
        transitions = new LinkedHashMap<>();
    }

    /**
     * returns weather the state is final accepting state or not
     * @return
     */
    public boolean isFinal() {
        return this.isFinal;
    }

    /**
     * wip
     * @param isFinal
     */
    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    /**
     * wip
     * @param symbol
     * @param toState
     */
    public void addTransition(char symbol, DFAState toState) {
        transitions.put(symbol, toState);
    }

    /**
     * wip
     * @param symbol
     * @return
     */
    public DFAState getTransition(char symbol) {
        return transitions.get(symbol);
    }

    /**
     * wip
     * @return
     */
    public Map<Character, DFAState> getTransitions() {
        return transitions;
    }
}