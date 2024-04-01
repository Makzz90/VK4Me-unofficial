import javax.microedition.io.file.FileConnection;

final class Class166 extends Class28 {
   private final FileConnection Field564;
   private final Class362 Field565;
   private final Class19 Field566;

   Class166(Class19 var1, String var2, FileConnection var3, Class362 var4) {
      super(var2);
      this.Field566 = var1;
      this.Field564 = var3;
      this.Field565 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         this.Field566.Method22();
         (new Class295(this)).start();
      } catch (Exception var2) {
         Class198.Instance.ShowError(var2);
      }
   }

   static Class19 Method388(Class166 var0) {
      return var0.Field566;
   }

   static FileConnection Method389(Class166 var0) {
      return var0.Field564;
   }

   static Class362 Method390(Class166 var0) {
      return var0.Field565;
   }
}
