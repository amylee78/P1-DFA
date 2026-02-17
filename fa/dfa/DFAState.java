package fa.dfa;

import java.util.LinkedHashMap;
import java.util.Map;
import fa.State;

/**
 * 
 */

public class DFAState extends State {

    private boolean isFinal;
    private Map<Character, DFAState> transitions;

    /**
     * constructor for DFAState.
     * initially not final state and does not 
     * have any transition.
     * @param name
    */
    public DFAState(String name) {
        super(name);
        this.isFinal = false;
        transitions = new LinkedHashMap<>();
        }

    /**
     * returns weather the state is final accepting state or not
     * @return true if is final state, otherwise false
     */
    public boolean isFinal() {
        return isFinal;
        }

    /**
     * sets wether it the state is a final or not.
     * if isFinal true, set it as final.
     * @param isFinal
     */
    public void setFinal(boolean isFinal) {
    this.isFinal = isFinal;
        }

    /**
     * adds or updates transition
     * 
     * if a a transition exists, it should overwrite it
     * @param symbol the input character
     * @param toState the destination to which state
     */
    public void addTransition(char symbol, DFAState toState) {
        transitions.put(symbol, toState);
        }
    
    /**
     * returns the state reached from this state after reading the 
     * symbol. returns null if  no transions exits
     * @param symbol
     * @return the next dfastate 
     */
    public DFAState getTransition(char symbol) {
        return transitions.get(symbol);
        }

    /**
     * represents tha map of the transison table that maps to the next 
     * dfa state.
     * @return the complete transition map for the current state
     */
    public Map<Character, DFAState> getTransitions() {
        return transitions;
        }
}
