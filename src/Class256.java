import java.util.TimerTask;

final class Class256 extends TimerTask {
   private final Class198 Field803;

   Class256(Class198 var1) {
      this.Field803 = var1;
   }

   public final void run() {
      try {
         this.Field803.Field667 = (this.Field803.Field667 + 1) % 4;
         if (this.Field803._inLoadingState) {
            this.Field803.Repaint();
         }

         if (Class248.Field788 > 0) {
            if (--Class248.Field788 == 0) {
               Class248.arrayIndex = -1;
               Class248.charIndex = -1;
            }

            this.Field803.Repaint();
         }

      } catch (Throwable var2) {
         Logger.PrintErrorWithMessage(var2);
      }
   }
}
