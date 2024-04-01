import javax.microedition.io.file.FileConnection;

final class Class32 extends Thread {
   private final FileConnection Field52;
   private final Class362 Field53;
   private final Class17 Field54;

   Class32(Class17 var1, FileConnection var2, Class362 var3) {
      this.Field54 = var1;
      this.Field52 = var2;
      this.Field53 = var3;
   }

   public final void run() {
      try {
         Class377.Method303(Class17.Method411(this.Field54), this.Field52, this.Field53, 0);
         this.Field52.close();
      } catch (Exception var1) {
      }
   }
}
