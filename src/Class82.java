import javax.microedition.io.file.FileConnection;

final class Class82 extends Class28 {
   private final FileConnection Field227;
   private final Class362 Field228;
   private final Class12 Field229;

   Class82(Class12 var1, String var2, FileConnection var3, Class362 var4) {
      super(var2);
      this.Field229 = var1;
      this.Field227 = var3;
      this.Field228 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         this.Field229.Method22();
         (new Class97(this)).start();
      } catch (Exception var2) {
         Class198.Instance.ShowError(var2);
      }
   }

   static Class12 Method84(Class82 var0) {
      return var0.Field229;
   }

   static FileConnection Method85(Class82 var0) {
      return var0.Field227;
   }

   static Class362 Method86(Class82 var0) {
      return var0.Field228;
   }
}
