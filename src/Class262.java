

final class Class262 extends Class28 {
   private final Class180 Field827;

   Class262(Class180 var1, String var2) {
      super(var2);
      this.Field827 = var1;
   }

   public final void CommandExecuted()
   {
	   Settings.Instance.SetBool(Settings.ThemeFromRMS, Class180.Method451(this.Field827));
      Class6.Method342(Settings.Instance.ThemeName = Class180.Method450(this.Field827).Name, Settings.Instance.GetBool(Settings.ThemeFromRMS));
      Class198.Field618.Method487();
      Class198.Field618.Method468(ThemesForm.Method31(Class180.Method452(this.Field827)));
   }
}
