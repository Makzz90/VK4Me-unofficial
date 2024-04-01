

final class LocalizationPage extends Page {
   private final SettingsPage Field1144;

   private LocalizationPage(SettingsPage var1, byte var2) {
      super(Localized.GetString("title.localizationSettings"));
      this.Field1144 = var1;
      TextBlock var5 = new TextBlock(Localized.GetString("element.intergratedLocales"));
      //boolean var6 = true;
      //TextBlock var5 = var10001;
      var5.IsBold = true;
      this.AddElement(var5.Method157(true));
      ApplicationLang[] langs = Localized.GetLangs();

      for(int i = 0; i < langs.length; i++) {
         ApplicationLang lang = langs[i];
         Class29 var10 = new Class29(this, lang.Name, (byte)1, var1, lang);
         String loc = Settings.Instance.LocaleCode;
         this.AddElement(var10/*.SetSubtitle(Localized.Method398("general.for", lang.Version, null))*/.Method115(loc != null && loc.equals(lang.Code)).TurnBottomLine(i != langs.length - 1));
      }

      Class198.Instance.NavigateForward(this);
   }

   LocalizationPage(SettingsPage var1) {
      this(var1, (byte)0);
   }

   static SettingsPage Method346(LocalizationPage var0) {
      return var0.Field1144;
   }
}
