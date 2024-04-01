import javax.microedition.io.file.FileConnection;

final class Class419 extends Thread {
   private final FileConnection Field1170;
   private final Class362 Field1171;
   private final Class436 Field1172;

   Class419(Class436 var1, FileConnection var2, Class362 var3) {
      this.Field1172 = var1;
      this.Field1170 = var2;
      this.Field1171 = var3;
   }

   public final void run() {
      try {
         Class377.Method303(Class436.Method28(this.Field1172), this.Field1170, this.Field1171, 0);
         this.Field1170.close();
      } catch (Exception var1) {
      }
   }
}
