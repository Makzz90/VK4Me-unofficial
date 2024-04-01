import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class0 extends Thread {
   private final String Field0;
   private final Class362 Field1;
   private final Class101 Field2;

   Class0(Class101 var1, String var2, Class362 var3) {
      this.Field2 = var1;
      this.Field0 = var2;
      this.Field1 = var3;
   }

   public final void run() {
      try {
         FileConnection var1 = (FileConnection)Connector.open(this.Field0, 1);
         VKPhoto var2;
         if ((var2 = Class336.Method135((long)((Class240)Class522.Method345(Class101.Method193(this.Field2))._page).Field758.id, var1.getName(), var1.fileSize(), var1.openInputStream(), this.Field1)) == null) {
            Class522.Method345(Class101.Method193(this.Field2)).Method20();
         } else {
            Class522.Method345(Class101.Method193(this.Field2)).Field84 = var2;
         }

         var1.close();
      } catch (Exception var3) {
         Class198.Instance.ShowError(var3);
      }
   }
}
