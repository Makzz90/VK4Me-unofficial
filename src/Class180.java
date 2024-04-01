import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class180 extends Button {
   private final ApplicationTheme Field591;
   private final boolean Field592;
   private final ThemesForm Field593;

   Class180(ThemesForm var1, String var2, byte var3, ApplicationTheme var4, boolean var5) {
      super(var2, (byte)1);
      this.Field593 = var1;
      this.Field591 = var4;
      this.Field592 = var5;
   }

   public final void CommandExecuted() {
      if (this.Field591.Version != null && this.Field591.Version.equals(Midlet.Instance.Version))
      {
    	  Settings.Instance.SetBool(Settings.ThemeFromRMS, this.Field592);
         Class6.Method342(Settings.Instance.ThemeName = this.Field591.Name, this.Field592);
         Class198.Field618.Method468(ThemesForm.Method31(this.Field593));
      } else {
         Class36 var1;
         (var1 = new Class36()).AddElement((new TextBlock(Localized.GetString("element.themeOutdated"))).Method55(Class6.Field14.Field294).Method157(true));
         var1.AddElement(new Class262(this, Localized.GetString("action.ok")));
         var1.AddElement(new Class264(this, Localized.GetString("action.cancel")));
         Class198.Field618.Method481(var1);
         var1.Field814 = 1;
      }
   }

   public final void Method20() {
      if (this.Field592) {
         Class36 var1;
         (var1 = new Class36()).AddElement((new Class265(this, Localized.GetString("action.delete"))).Method99("new/delete.rle"));
         Class198.Field618.Method481(var1);
      }
   }

   static ApplicationTheme Method450(Class180 var0) {
      return var0.Field591;
   }

   static boolean Method451(Class180 var0) {
      return var0.Field592;
   }

   static ThemesForm Method452(Class180 var0) {
      return var0.Field593;
   }
}
