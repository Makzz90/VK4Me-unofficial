final class Class111 extends Class28 {
   private final Class247 Field462;

   Class111(Class247 var1, String var2) {
      super(var2);
      this.Field462 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      if (this.Field462.Field814 == 0) {
         Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
      } else if (this.Field462.Field814 == 1 && this.Field462.Field779) {
         Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
      } else {
         Class247.Method240(this.Field462);
      }
   }
}
