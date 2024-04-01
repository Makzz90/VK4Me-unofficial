import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class93 extends Thread {
   private final String Field278;
   private final Class362 Field279;
   private final Class107 Field280;

   Class93(Class107 var1, String var2, Class362 var3) {
      this.Field280 = var1;
      this.Field278 = var2;
      this.Field279 = var3;
   }

   public final void run() {
      try {
         FileConnection var1 = (FileConnection)Connector.open(this.Field278, 1);
         VKAttachment var2;
         if ((var2 = Class336.Method136((long)((Class240)Class521.Method347(Class107.Method229(this.Field280))._page).Field758.id, var1.getName(), var1.fileSize(), var1.openInputStream(), this.Field279)) == null) {
            Class521.Method347(Class107.Method229(this.Field280)).Method20();
         } else {
            Class521.Method347(Class107.Method229(this.Field280)).Field84 = var2;
         }

         var1.close();
      } catch (Exception var3) {
         Class198.Instance.ShowError(var3);
      }
   }
}
