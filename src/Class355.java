final class Class355 extends Class28 {
   private final Class240 Field1035;

   Class355(Class240 var1, String var2) {
      super(var2);
      this.Field1035 = var1;
   }

   public final void CommandExecuted() {
      synchronized(this.Field1035._obj) {
         this.Field1035.next_from = null;
         this.Field1035.Field756 = !this.Field1035.Field756;
         this.Field1035.IsAllLoaded = false;
         this.Field1035.Clear();
         this.Field1035.Method21();
      }

      Class198.Instance.Method487();
   }
}
