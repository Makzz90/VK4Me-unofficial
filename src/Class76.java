

final class Class76 extends Class28 {
   private final Class29 Field222;

   Class76(Class29 var1, String var2) {
      super(var2);
      this.Field222 = var1;
   }

   public final void CommandExecuted() {
      Settings.Instance.LocaleCode = Class29.Method446(this.Field222).Code;
      Class198.Instance.Method487();
      Class198.Instance.NavigateBack(LocalizationPage.Method346(Class29.Method447(this.Field222)));
   }
}
