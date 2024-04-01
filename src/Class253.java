import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

final class Class253 implements CommandListener {
   Class253(Class198 var1) {
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (Class198.Field620 != null && Class198._texBox != null) {
         Class198.Field620.Method139(Class198._texBox.getString());
      }

      Class198.Instance.Method472();
   }
}
