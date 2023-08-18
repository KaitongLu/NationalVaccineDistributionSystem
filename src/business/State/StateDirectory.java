/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.State;

import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class StateDirectory {

    private ArrayList<State> stateList;

    public StateDirectory() {
        stateList = new ArrayList<>();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    public State createState(String name, int population) {
        State state = new State(name, population);
        state.setPopulation(population);
        state.setName(name);
        stateList.add(state);
        return state;

    }

}
