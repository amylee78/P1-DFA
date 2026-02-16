package fa.dfa;

import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

   
    public DFA() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("to be written'");
    }

    @Override
    public boolean addState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addState'");
    }

    @Override
    public boolean setFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFinal'");
    }

    @Override
    public boolean setStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStart'");
    }

    @Override
    public void addSigma(char symbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSigma'");
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSigma'");
    }

    @Override
    public State getState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFinal'");
    }

    @Override
    public boolean isStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isStart'");
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }
    
}
