import javax.microedition.io.file.FileConnection;

final class Class90 extends Thread {
   private final FileConnection Field274;
   private final Class362 Field275;
   private final Class12 Field276;

   Class90(Class12 var1, FileConnection var2, Class362 var3) {
      this.Field276 = var1;
      this.Field274 = var2;
      this.Field275 = var3;
   }

   public final void run() {
      try {
         Class377.Method303(Class12.Method408(this.Field276), this.Field274, this.Field275, 0);
         this.Field274.close();
      } catch (Exception var1) {
      }
   }
}
