package lab1;

public class Hero {
   MoveStrategy moveStrategy;

   public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
   }

   public void startMoving() {
       moveStrategy.move();
   }
}