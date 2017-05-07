package career08.oop;

import java.util.HashMap;

public class Exam_8_5_OnlineReaderSystem {

  Library library;
  UserManager userManager;
  Display display;
  Book book;
  User2 user;

}

class Library {
  HashMap<Integer, Book> books;

}

class UserManager {
  HashMap<Integer, User2> users;
}

class Display {
  Book activeBook;
  User activeUser;
  int pageNumber;
}

class Book {
  int id;
  String detail;
}

class User2 {
  int id;
  String details;
  int accountType;

}
