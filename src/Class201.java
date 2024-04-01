import javax.microedition.io.file.FileConnection;

final class Class201 extends Thread {
   private final FileConnection Field692;
   private final Class362 Field693;
   private final Class21 Field694;

   Class201(Class21 var1, FileConnection var2, Class362 var3) {
      this.Field694 = var1;
      this.Field692 = var2;
      this.Field693 = var3;
   }

   public final void run() {
      try {
         Class377.Method303(Class21.Method449(this.Field694).url, this.Field692, this.Field693, 0);
         this.Field692.close();
      } catch (Exception var1) {
      }
   }
}
