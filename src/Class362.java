public final class Class362 implements Class80 {
   private String Field1047;
   private Class80 Field1048;
   private long Field1049;

   public Class362(Class80 var1) {
      if (var1 != null) {
         this.Field1047 = var1.Method73();
         this.Method290(var1);
      }
   }

   public final void Method290(Class80 var1) {
      this.Field1048 = var1;
      if (var1 != null) {
         if (this.Field1049 != 0L) {
            this.Method1(this.Field1049);
         }

      }
   }

   public final void Method1(long var1) {
      this.Field1049 = var1;
      if (this.Field1048 != null) {
         this.Field1048.Method1(var1);
      }

   }

   public final void Method27(String var1) {
      if (this.Field1048 != null) {
         this.Field1048.Method27(var1);
      }

      Class459.Method197(this);
   }

   public final void Method72() {
      if (this.Field1048 != null) {
         this.Field1048.Method72();
      }

      Class459.Method197(this);
   }

   public final String Method73() {
      return this.Field1047;
   }
}
