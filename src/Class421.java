import javax.microedition.io.file.FileConnection;

final class Class421 extends Class28 {
   private final FileConnection Field1173;
   private final Class362 Field1174;
   private final Class436 Field1175;

   Class421(Class436 var1, String var2, FileConnection var3, Class362 var4) {
      super(var2);
      this.Field1175 = var1;
      this.Field1173 = var3;
      this.Field1174 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         this.Field1175.Method22();
         (new Class47(this)).start();
      } catch (Exception var2) {
         Class198.Instance.ShowError(var2);
      }
   }

   static Class436 Method16(Class421 var0) {
      return var0.Field1175;
   }

   static FileConnection Method17(Class421 var0) {
      return var0.Field1173;
   }

   static Class362 Method18(Class421 var0) {
      return var0.Field1174;
   }
}
