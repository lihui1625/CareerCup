package career08.oop;

import java.util.HashMap;
import java.util.List;

public class Exam_8_7 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class UserManager2 {
  HashMap<Integer, User3> allUser;
}

class User3 {
  int id;
  String status;
  HashMap<User, PrivateChat> privateChars;
  List<GroupChat> groupChats;
  HashMap<User, AddRequest> receivedAddRequest;
  HashMap<User, AddRequest> sentAddRequest;
  List<User> contacts;

}

abstract class Conversation {
  List<User> users;
  List<Message> msg;
}

class PrivateChat extends Conversation {

}

class GroupChat extends Conversation {

}

class Message {

}

class AddRequest {
  User fromUser;
  User toUser;
  String status;
}
