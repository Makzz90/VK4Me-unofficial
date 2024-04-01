final class Class354 extends Class28 {
   private final Class240 Field1034;

   Class354(Class240 var1, String var2) {
      super(var2);
      this.Field1034 = var1;
   }

   public final void CommandExecuted() {
      synchronized(this.Field1034._obj) {
         this.Field1034.next_from = null;
         this.Field1034.Field760 = null;
         this.Field1034.IsAllLoaded = false;
         this.Field1034.Clear();
         this.Field1034.Method21();
      }

      Class198.Instance.Method487();
   }
}
