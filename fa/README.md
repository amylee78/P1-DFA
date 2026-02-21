## Deterministic Finite Automata

### Introduction
 This java projects models a Deterministic Finite Automata (DFA). DFA is a type of Finte Automata  that reconize patterns in strings to form the basis for understaning regular language. DFA's is represented through the 5-tuple (Q, Σ, δ, q0, F).The 5-tuples are as follows
 - Q is a finite set of states (q0,q1,q3, etc)
 - Σ is a finite set of alphabet ( a,b,c, 1,2, etc)
 - δ is the transition function: Q × Σ → Q
 - q0 is the start state
 - F is the set of final/accepting states

### Overview
The purpose of this project is to understand the behavior and stucture of DFA's by representing each of the 5 tuples and its conditions. In additon is used to famiralizing with implenting interfaces, abstract classes, packages, and using javas API library. In additon to using junit to test out the code. This projects files include

- DFAInterface.java -  Extends FAInterface. Defines required behavior for a DFA.
- FA.interface - Defines the behavior of a Finite Automona
- DFA.java - implements the full DFA
- State.java - Abstract class for states
- DFAState.java - implments a single state in the DFA. Extends state.java
- DFATest.java - test files to test if dfa is implemented correctly
    - hamcrest-core-1.3.jar and junit-4.13.2.jar - Dependencys to help run the junit test.
- Readme.md - a read me file on info about this project


### Compiling and use

TO compile and run this project, please run the following commands 

        1. Compile all java files in the current directory. Makes sure it is in the root directory first: 
            javac fa/**/*.java
        2. Then to test out the code  in your terminal on your top directly use this command to compile the DFA.test
            -  javac -cp .:/usr/share/java/junit.jar ./test/dfa/DFATest.java
        3. use this to run the test
            -  java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar org.jucd -
            nit.runner.JUnitCore test.dfa.DFATest 
        4. If running int oisses such as having junit5. Please use these commands once you are in the root file to compile it
            -javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar test/dfa/DFATest.java 
        5. then to run it use this command 
            -  java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore test.dfa.DFATest

### Sources used

    The provided class files and notes
  
    java set https://docs.oracle.com/javase/8/docs/api/java/util/Set.html

    java Map https://docs.oracle.com/javase/8/docs/api/java/util/Map.html




