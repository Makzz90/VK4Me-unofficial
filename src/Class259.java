import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

final class Class259 implements CommandListener {
   private final Class198 Field805;

   Class259(Class198 var1) {
      this.Field805 = var1;
   }

   public final void commandAction(Command var1, Displayable var2) {
      switch(var1.getCommandType()) {
      case 2:
         if (!this.Field805._reverseSofts) {
            this.Field805.keyPressed(1000001);
            this.Field805.keyReleased(1000001);
            return;
         }

         this.Field805.keyPressed(1000002);
         this.Field805.keyReleased(1000002);
         return;
      default:
         if (this.Field805._reverseSofts) {
            this.Field805.keyPressed(1000001);
            this.Field805.keyReleased(1000001);
         } else {
            this.Field805.keyPressed(1000002);
            this.Field805.keyReleased(1000002);
         }
      }
   }
}
