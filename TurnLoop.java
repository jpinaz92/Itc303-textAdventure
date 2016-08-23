

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TurnLoop {

  protected String name;
  protected String currentState;
  protected Map<String, State> states;
  protected List<ChangeListener> changeListeners;
  protected boolean debug;


  public TurnLoop(String name) {
    this.name = name;
    this.states = new HashMap<String, State>();
    this.currentState = null;
    this.changeListeners = new ArrayList<ChangeListener>();
  }


  public void setDebugMode(boolean debug) {
    this.debug = debug;
  }

  
  public String getState() {
    return currentState;
  }


  public void addState(String state) {
    addState(state, null, null, null);
  }


  public void addState(String state, Runnable entryCode, Runnable exitCode,
      Runnable alwaysRunCode) {
    boolean isInitial = (states.size() == 0);
    if (!states.containsKey(state)) {
      states.put(state, new State(entryCode, exitCode, alwaysRunCode));
    }
    if (isInitial) {
      setState(state);
    }
  }

  public void setStateEntryCode(String state, Runnable entryCode) {
    states.get(state).entryCode = entryCode;
  }

  public void setStateExitCode(String state, Runnable exitCode) {
    states.get(state).exitCode = exitCode;
  }

  public void setStateAlwaysRunCode(String state, Runnable alwaysRunCode) {
    states.get(state).alwaysRunCode = alwaysRunCode;
  }


  public void setAutoTransition(String startState, String endState) {
    states.get(startState).autoTransitionState = endState;
    addTransition(new Transition("(auto)", startState, endState));
  }


  public void setState(String state) {
    setState(state, true);
  }


  public void setState(String state, boolean triggerEvent) {
    boolean runExtraCode = !state.equals(currentState);
    if (runExtraCode && currentState != null) {
      states.get(currentState).runExitCode();
    }
    currentState = state;
    states.get(currentState).runAlwaysCode();
    if (runExtraCode) {
      states.get(currentState).runEntryCode();
    }
    if (triggerEvent) {
      fireChangeEvent();
    }
  }


  public void addTransition(Transition trans) {
    State st = states.get(trans.startState);
    if (st == null) {
      throw new NoSuchElementException("Missing state: "
          + trans.startState);
    }
    st.addTransition(trans);
  }


  public void addChangeListener(ChangeListener cl) {
    if (!changeListeners.contains(cl)) {
      changeListeners.add(cl);
    }
  }


  public void addEvent(String evtName) {
    State state = states.get(currentState);
    if (state.transitions.containsKey(evtName)) {
      Transition trans = state.transitions.get(evtName);
      trans.preCondition();
      setState(trans.endState, false);
      trans.postCondition();
      fireChangeEvent();
      if (states.get(trans.endState).autoTransitionState != null) {
        addEvent("(auto)");
      }
    }
  }


  protected void fireChangeEvent() {
    ChangeEvent changeEvent = new ChangeEvent(this);
    for (ChangeListener cl : changeListeners) {
      cl.stateChanged(changeEvent);
    }
  }


  private static class State {
    Map<String, Transition> transitions;
    String autoTransitionState;
    Runnable entryCode;
    Runnable exitCode;
    Runnable alwaysRunCode;

    State(Runnable entryCode, Runnable exitCode, Runnable alwaysRunCode) {
      autoTransitionState = null;
      transitions = new HashMap<String, Transition>();
      this.entryCode = entryCode;
      this.exitCode = exitCode;
      this.alwaysRunCode = alwaysRunCode;
    }

    public void addTransition(Transition trans) {
      transitions.put(trans.evtName, trans);
    }

    public void runEntryCode() {
      if (entryCode != null) {
        entryCode.run();
      }
    }

    public void runExitCode() {
      if (exitCode != null) {
        exitCode.run();
      }
    }

    public void runAlwaysCode() {
      if (alwaysRunCode != null) {
        alwaysRunCode.run();
      }
    }
  }


  public static class Transition {
    String evtName;
    String startState;
    String endState;


    public Transition(String evtName, String startState, String endState) {
      this.evtName = evtName;
      this.startState = startState;
      this.endState = endState;
    }


    public void preCondition() {
    }


    public void postCondition() {
    }
  }
}
