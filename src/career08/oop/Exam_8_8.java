package career08.oop;

public class Exam_8_8 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

enum Color {
  white, black;
}

enum Direction {
  left, right, up, down;
}

class Game {
  static Game instance;
  Player[] players;
  Board board;
  int ROWS = 10;
  int COLUMNS = 10;
}

class Board {
  int backCt = 0;
  int whiteCt = 0;
  Piece2[][] borad;
}

class Piece2 {
  private Color color;

  public void flip() {
  }
}

class Player {
  Color color;

  int getScore() {
    throw new RuntimeException("to do");
  }

  boolean playPiece(int row, int column) {
    throw new RuntimeException("to do");
  }
}
