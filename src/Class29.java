

final class Class29 extends Button {
   private final ApplicationLang _lang;
   private final LocalizationPage Field49;

   Class29(LocalizationPage var1, String var2, byte var3, SettingsPage var4, ApplicationLang lang) {
      super(var2, (byte)1);
      this.Field49 = var1;
      this._lang = lang;
   }

   public final void CommandExecuted() {
      //if (this._lang.Version != null && this._lang.Version.equals(Midlet.Instance.Version))
      //{
         Settings.Instance.LocaleCode = this._lang.Code;
         Class198.Instance.NavigateBack(LocalizationPage.Method346(this.Field49));
      /*}
      else
      {
         Class36 var1 = new Class36();
         var1.AddElement((new TextBlock(Localized.GetString("element.languageOutdated"))).Method55(Class6.ColorsInstanse.Field294).Method157(true));
         var1.AddElement(new Class76(this, Localized.GetString("action.ok")));
         var1.AddElement(new Class74(this, Localized.GetString("action.cancel")));
         Class198.Field618.Method481(var1);
         var1.Field814 = 1;
      }*/
   }

   static ApplicationLang Method446(Class29 var0) {
      return var0._lang;
   }

   static LocalizationPage Method447(Class29 var0) {
      return var0.Field49;
   }
}
