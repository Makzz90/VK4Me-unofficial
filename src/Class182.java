

final class Class182 extends Class28 {
   private final ThemesForm Field595;

   Class182(ThemesForm var1, String var2, Class442 var3) {
      super(var2);
      this.Field595 = var1;
   }

   public final void CommandExecuted() {
      ApplicationTheme[] themes = Settings.Instance.ThemeList;
      int var2 = this.Field595.Field814 - 3 - Class6.Method340().length;
      String var3 = themes[var2].Name;
      this.Field595.Method295(3 + Class6.Method340().length + var2);
      Class198.Field618.Method487();
      if (Settings.Instance.GetString(Settings.ThemeName).equals(var3)) {
         Class6.Method342(Class6.Method340()[0].Name, false);
         Settings.Instance.SetString(Settings.ThemeName, Class6.Method340()[0].Name);
         Settings.Instance.SetBool(Settings.ThemeFromRMS,false);
         ((Button)this.Field595.ElementAt(1)).Method115(true);
      }

      themes = new ApplicationTheme[Settings.Instance.ThemeList.length - 1];
      System.arraycopy(Settings.Instance.ThemeList, 0, themes, 0, var2);
      System.arraycopy(Settings.Instance.ThemeList, var2 + 1, themes, var2, Settings.Instance.ThemeList.length - var2 - 1);
      Class98.DeleteRecord(var3 + "_theme");
      Settings.Instance.ThemeList = themes;
      Settings.Instance.LoadThemesAndLangs();
   }
}
