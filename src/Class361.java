final class Class361 extends Class28 {
   private final Class240 Field1046;

   Class361(Class240 var1, String var2) {
      super(var2);
      this.Field1046 = var1;
   }

   public final void CommandExecuted() {
      synchronized(this.Field1046._obj) {
         this.Field1046.next_from = null;
         this.Field1046.Field761 = !this.Field1046.Field761;
         this.Field1046.IsAllLoaded = false;
         this.Field1046.Clear();
         this.Field1046.Method21();
      }

      Class198.Instance.Method487();
   }
}
