import javax.microedition.io.file.FileConnection;

final class Class168 extends Thread {
   private final FileConnection Field568;
   private final Class362 Field569;
   private final Class19 Field570;

   Class168(Class19 var1, FileConnection var2, Class362 var3) {
      this.Field570 = var1;
      this.Field568 = var2;
      this.Field569 = var3;
   }

   public final void run() {
      try {
         Class377.Method303(Class19.Method453(this.Field570).url, this.Field568, this.Field569, 0);
         this.Field568.close();
      } catch (Exception var1) {
      }
   }
}
