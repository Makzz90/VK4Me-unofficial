final class Class112 extends Class28 {
   private final Class247 Field463;

   Class112(Class247 var1, String var2) {
      super(var2);
      this.Field463 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      if (this.Field463.Field814 == 0) {
         Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
      } else if (this.Field463.Field814 == 1 && this.Field463.Field779) {
         Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
      } else {
         Class247.Method241(this.Field463);
      }
   }
}
