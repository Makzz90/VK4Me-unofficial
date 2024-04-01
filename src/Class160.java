import javax.microedition.io.file.FileConnection;

final class Class160 extends Class28 {
   private final FileConnection Field551;
   private final Class362 Field552;
   private final Class14 Field553;

   Class160(Class14 var1, String var2, FileConnection var3, Class362 var4) {
      super(var2);
      this.Field553 = var1;
      this.Field551 = var3;
      this.Field552 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         this.Field553.Method22();
         (new Class220(this)).start();
      } catch (Exception var2) {
         Class198.Instance.ShowError(var2);
      }
   }

   static Class14 Method405(Class160 var0) {
      return var0.Field553;
   }

   static FileConnection Method406(Class160 var0) {
      return var0.Field551;
   }

   static Class362 Method407(Class160 var0) {
      return var0.Field552;
   }
}
