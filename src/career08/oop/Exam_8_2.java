package career08.oop;

import java.util.HashMap;
import java.util.List;

public class Exam_8_2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class CallHandler {

  private static CallHandler instance = new CallHandler();
  private final int LEVELS = 3;

  private final int NUM_Respondent = 10;
  private final int NUM_Manager = 4;
  private final int NUM_Director = 2;

  HashMap<Employee.Rank, List<Employee>> allEmployees;
  HashMap<Employee.Rank, List<Call>> callQueues;

  protected CallHandler() {
  }

  public static CallHandler getInstance() {
    return instance;
  }

  public Employee getHandlerForCall(Call call) {
    return null;
  }

  public void dispatchCall(Call call) {
    Employee employee = this.getHandlerForCall(call);
    if (employee != null) {
      employee.receiveCall(call);
      call.setHandler(employee);
    } else {
      call.reply(" no free ");
      this.callQueues.get(call.getRank()).add(call);
    }
  }

  public boolean assignCall(Employee emp) {
    return false;
  }

}

class Call {

  private Employee.Rank rank;
  private Caller caller;
  private Employee handler;

  public Call(Caller caller) {
    rank = Employee.Rank.Respondent;
    this.caller = caller;
  }

  public void setHandler(Employee e) {
    this.handler = e;
  }

  public void reply(String msg) {
  }

  public Employee.Rank getRank() {
    return rank;
  }

  public void setRank(Employee.Rank rank) {
    this.rank = rank;
  }

  public Employee.Rank incrementRank() {
    if (rank == Employee.Rank.Respondent) {
      rank = Employee.Rank.Manager;
    } else if (rank == Employee.Rank.Manager) {
      rank = Employee.Rank.Director;
    }
    return rank;
  }

  public void disconnect() {

  }

}

class Caller {

}

abstract class Employee {
  public static enum Rank {
    Respondent, Director, Manager;
  }

  private Call currentCall = null;
  protected Rank rank;

  public Employee() {
  }

  public void receiveCall(Call call) {
  }

  public void callCompletedt() {
  }

  public void escalatedAndReassign() {
  }

  public boolean assignNewCall() {
    return true;
  }

  public boolean isFree() {
    return this.currentCall == null;
  }

  public Rank getRank() {
    return this.rank;
  }
}

class Respondent extends Employee {
  public Respondent() {
    this.rank = Rank.Respondent;
  }
}

class Director extends Employee {
  public Director() {
    this.rank = Rank.Director;
  }

}

class Manager extends Employee {
  public Manager() {
    this.rank = Rank.Manager;
  }
}
