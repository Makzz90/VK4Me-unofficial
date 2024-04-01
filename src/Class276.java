final class Class276 extends Class28 {
   private final Runnable Field871;
   private final Class198 Field872;

   Class276(Class198 var1, String var2, Runnable var3) {
      super(var2);
      this.Field872 = var1;
      this.Field871 = var3;
   }

   public final void CommandExecuted() {
      this.Field872.Method487();
      if (this.Field871 != null) {
         this.Field871.run();
      }

   }
}
