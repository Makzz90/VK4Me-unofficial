final class Class158 extends Class28 {
   private final Class240 Field548;
   private final Class64 Field549;

   Class158(Class64 var1, String var2, Class240 var3) {
      super(var2);
      this.Field549 = var1;
      this.Field548 = var3;
   }

   public final void CommandExecuted() {
      synchronized(this.Field548._obj) {
         this.Field548.next_from = null;
         this.Field548.Field760 = this.Field549.Field163;
         this.Field548.IsAllLoaded = false;
         this.Field548.Clear();
         this.Field548.Method21();
      }

      Class198.Instance.Method487();
   }
}
