package career16.thread;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class Exam_16_4 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class LockFactory {

  private LockFactory(int numOfLocks) {
    this.numOfLocks = numOfLocks;
    locks = new LockNode[numOfLocks];
    lockOrder = new HashMap<>();
  }

  public static LockFactory getInstance(int numOfLocks) {
    return new LockFactory(numOfLocks);
  }

  private int numOfLocks = 5;
  private LockNode[] locks;
  private HashMap<Integer, LinkedList<LockNode>> lockOrder;

  public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes,
      int[] resourcesInOrder) {
    for (int resource : resourcesInOrder) {
      if (touchedNodes.containsKey(resource)) {
        LockNode ln = this.locks[resource];
        if (ln.hasCycle(touchedNodes)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean declare(int ownerId, int[] resourcesInOrder) {
    HashMap<Integer, Boolean> touchedNodes = new HashMap<>();
    touchedNodes.put(resourcesInOrder[0], false);
    for (int index = 1; index < resourcesInOrder.length; index++) {
      LockNode prev = locks[resourcesInOrder[index - 1]];
      LockNode curr = locks[resourcesInOrder[index]];
      prev.joinTo(curr);
      touchedNodes.put(resourcesInOrder[index], false);
    }
    if (this.hasCycle(touchedNodes, resourcesInOrder)) {
      for (int j = 1; j < resourcesInOrder.length; j++) {
        LockNode prev = locks[resourcesInOrder[j - 1]];
        LockNode curr = locks[resourcesInOrder[j]];
        prev.remove(curr);
      }
      return false;
    }

    LinkedList<LockNode> list = new LinkedList<>();
    for (int j = 1; j < resourcesInOrder.length; j++) {
      LockNode resource = locks[resourcesInOrder[j]];
      list.add(resource);
    }
    this.lockOrder.put(ownerId, list);
    return true;
  }

  public Lock getLock(int ownerId, int resourceId) {
    LinkedList<LockNode> list = this.lockOrder.get(ownerId);
    if (list == null) {
      return null;
    }
    LockNode head = list.getFirst();
    if (head.getLockId() == resourceId) {
      list.removeFirst();
      return head.getLock();
    }
    return null;
  }

}

class LockNode {
  public static enum VisitState {
    FRESH, VISITING, VISITED;
  }

  private List<LockNode> children;
  private int lockId;
  private Lock lock;
  private int maxLocks;

  public LockNode(int id, int max) {
    this.lockId = id;
    this.maxLocks = max;
    children = new LinkedList<>();
  }

  public void joinTo(LockNode node) {
    this.children.add(node);
  }

  public void remove(LockNode node) {
    this.children.remove(node);
  }

  public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
    VisitState[] visited = new VisitState[maxLocks];
    for (int i = 0; i < this.maxLocks; i++) {
      visited[i] = VisitState.FRESH;
    }
    return this.hasCycle(touchedNodes, visited);
  }

  private boolean hasCycle(HashMap<Integer, Boolean> touchedNodes,
      VisitState[] visited) {
    if (touchedNodes.containsKey(lockId)) {
      touchedNodes.put(lockId, true);
    }
    if (visited[lockId] == VisitState.VISITING) {
      return true;
    } else if (visited[lockId] == VisitState.FRESH) {
      visited[lockId] = VisitState.VISITING;
      for (LockNode ln : this.children) {
        if (ln.hasCycle(touchedNodes, visited)) {
          return true;
        }
      }
      visited[lockId] = VisitState.VISITED;
    }
    return false;
  }

  public int getLockId() {
    return lockId;
  }

  public Lock getLock() {
    return lock;
  }

}
