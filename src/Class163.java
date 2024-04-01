import javax.microedition.io.file.FileConnection;

final class Class163 extends Thread {
   private final FileConnection Field558;
   private final Class362 Field559;
   private final Class14 Field560;

   Class163(Class14 var1, FileConnection var2, Class362 var3) {
      this.Field560 = var1;
      this.Field558 = var2;
      this.Field559 = var3;
   }

   public final void run() {
      try {
         Class377.Method303(Class14.Method409(this.Field560).url, this.Field558, this.Field559, 0);
         this.Field558.close();
      } catch (Exception var1) {
      }
   }
}
