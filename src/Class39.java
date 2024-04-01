import javax.microedition.io.file.FileConnection;

final class Class39 extends Class28 {
   private final FileConnection Field87;
   private final Class362 Field88;
   private final Class17 Field89;

   Class39(Class17 var1, String var2, FileConnection var3, Class362 var4) {
      super(var2);
      this.Field89 = var1;
      this.Field87 = var3;
      this.Field88 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         this.Field89.Method22();
         (new Class231(this)).start();
      } catch (Exception var2) {
         Class198.Instance.ShowError(var2);
      }
   }

   static Class17 Method458(Class39 var0) {
      return var0.Field89;
   }

   static FileConnection Method459(Class39 var0) {
      return var0.Field87;
   }

   static Class362 Method460(Class39 var0) {
      return var0.Field88;
   }
}
