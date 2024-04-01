final class Class119 extends Class28 {
   private final Class247 Field475;

   Class119(Class247 var1, String var2) {
      super(var2);
      this.Field475 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      if (this.Field475.Field814 == 0) {
         Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
      } else if (this.Field475.Field814 == 1 && this.Field475.Field779) {
         Class247.Method238(this.Field475, Class247.Field784);
      } else {
         Button var1;
         if (Class247.Method237(var1 = (Button)this.Field475.Method367()) && !this.Field475.Field779) {
            Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
         } else if (!Class247.Method237(var1) && this.Field475.Field779) {
            Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
         } else {
            Class247.Method238(this.Field475, Class247.Field784 + var1.LableElement + (Class247.Method237(var1) ? Class247.Field780 : ""));
         }
      }
   }
}
