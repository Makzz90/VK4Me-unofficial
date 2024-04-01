import javax.microedition.io.file.FileConnection;

final class Class203 extends Class28 {
   private final FileConnection Field696;
   private final Class362 Field697;
   private final Class21 Field698;

   Class203(Class21 var1, String var2, FileConnection var3, Class362 var4) {
      super(var2);
      this.Field698 = var1;
      this.Field696 = var3;
      this.Field697 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         this.Field698.Method22();
         (new Class120(this)).start();
      } catch (Exception var2) {
         Class198.Instance.ShowError(var2);
      }
   }

   static Class21 Method79(Class203 var0) {
      return var0.Field698;
   }

   static FileConnection Method80(Class203 var0) {
      return var0.Field696;
   }

   static Class362 Method81(Class203 var0) {
      return var0.Field697;
   }
}
