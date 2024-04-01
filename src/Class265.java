

final class Class265 extends Class28 {
   private final Class180 Field829;

   Class265(Class180 var1, String var2) {
      super(var2);
      this.Field829 = var1;
   }

   public final void CommandExecuted() {
      ApplicationTheme[] var1 = Settings.Instance.ThemeList;
      int var2 = -1;

      for(int i = 0; i < var1.length; i++) {
         if (var1[i] != null && var1[i].Name != null && var1[i].Name.equals(Class180.Method450(this.Field829).Name)) {
            var2 = i;
            break;
         }
      }

      if (var2 != -1) {
         Class180.Method452(this.Field829).Method295(3 + Class6.Method340().length + var2);
         Class198.Field618.Method487();
         if (Settings.Instance.ThemeName.equals(Class180.Method450(this.Field829).Name)) {
            Class6.Method342(Class6.Method340()[0].Name, false);
            Settings.Instance.ThemeName = Class6.Method340()[0].Name;
            Settings.Instance.SetBool(Settings.ThemeFromRMS, false);
            ((Button)Class180.Method452(this.Field829).ElementAt(1)).Method115(true);
         }

         var1 = new ApplicationTheme[Settings.Instance.ThemeList.length - 1];
         System.arraycopy(Settings.Instance.ThemeList, 0, var1, 0, var2);
         System.arraycopy(Settings.Instance.ThemeList, var2 + 1, var1, var2, Settings.Instance.ThemeList.length - var2 - 1);
         Class98.DeleteRecord(Class180.Method450(this.Field829).Name + "_theme");
         Settings.Instance.ThemeList = var1;
         Settings.Instance.LoadThemesAndLangs();
      }
   }
}
