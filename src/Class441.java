final class Class441 extends Class36 {
   private final Class75 Field1218;

   Class441(Class75 var1, String var2) {
      super(var2);
      this.Field1218 = var1;
   }

   public final void Method83(int var1, int var2, int var3) {
      if (!this.IsLoaded) {
         if (this.Method372(Class75.Method74(this.Field1218))) {
            this.Method294(Class75.Method74(this.Field1218));
         }

         if (Class75.Method75(this.Field1218)) {
            this.Method293(Class75.Method74(this.Field1218), 0);
         }

         this.Method365(this.GetWidth(), this.Count());
      }

      super.Method83(var1, var2, var3);
   }
}
