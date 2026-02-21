package fa.dfa;

import java.util.LinkedHashMap;
import java.util.Map;
import fa.State;

/**
  * Represents a single state in a Deterministic Finite Automaton (DFA).
  * Each state has a name (label) and a set of outgoing transitions.
 * 
 * Each DFAState:
 *  Has a name (inherited from State)
 * Keeps track of the transitions from current state to another 
 * @author  Maria Gomez Baeza, Amy Lee, group 12, section 002
 */

public class DFAState extends State {


    private Map<Character, DFAState> transitions;

    /**
     * constructor for DFAState.
     * @param name
    */
    public DFAState(String name) {
        super(name); //calls stat name via super
        transitions = new LinkedHashMap<>(); //maintains transition order
    }

  
    /**
     * adds or updates transition
     * 
     * if a a transition exists, it should overwrite it
     * @param symbol the input character
     * @param toState the destination to which state
     */
    public void addTransition(char symbol, DFAState toState) {
        transitions.put(symbol, toState); //stores transition
    }
    
    /**
     * returns the state reached from this state after reading the 
     * symbol. returns null if  no transions exits
     * @param symbol
     * @return the next dfastate 
     */
    public DFAState getTransition(char symbol) {
        return transitions.get(symbol); //gets transion on map
    }

    /**
     * represents tha map of the transison table that maps to the next 
     * dfa state.
     * @return the complete transition map for the current state
     */
    public Map<Character, DFAState> getTransitions() {
        return transitions; //returns intial transiton
    }
}
