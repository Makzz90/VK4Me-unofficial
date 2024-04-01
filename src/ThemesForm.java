

final class ThemesForm extends Page {
   private final Class442 Field223;

   /*private */ThemesForm(Class442 var1/*, byte var2*/) {
      super(Localized.GetString("title.themeSettings"));
      this.Field223 = var1;
      TextBlock var10001 = new TextBlock(Localized.GetString("element.integratedThemes"));
      //boolean var4 = true;
      TextBlock var5 = var10001;
      var10001.Field1198 = true;
      this.AddElement(var5.Method157(true));
      ApplicationTheme[] var6 = Class6.Method340();

      int i;
      for(i = 0; i < var6.length; i++) {
         this.AddElement(this.Method30(var6[i], false).Method158(i != var6.length - 1));
      }

      this.AddElement(new Class24());
      var10001 = new TextBlock(Localized.GetString("element.installedThemes"));
      //var4 = true;
      var5 = var10001;
      var10001.Field1198 = true;
      this.AddElement(var5.Method157(true));
      var6 = Settings.Instance.ThemeList;

      for(i = 0; i < var6.length; i++) {
         this.AddElement(this.Method30(var6[i], true).Method158(true));
      }

      this.AddElement((new Class181(this, Localized.GetString("action.installFromFile"), var1)).Method109(true).Method99("new/file-plus.rle"));
      this.Field825 = new Class36(Localized.GetString("general.actions"));
      this.Field825.AddElement((new Class182(this, Localized.GetString("action.delete"), var1)).Method99("new/delete.rle"));
      Class198.Field618.Method469(this);
   }

   public final String Method29() {
      return this.Field814 != this.Count() - 1 && this.Field814 >= 3 + Class6.Method340().length ? super.Method29() : null;
   }

   public final void Method7() {
      if (this.Field814 != this.Count() - 1 && this.Field814 >= 3 + Class6.Method340().length) {
         super.Method7();
      }
   }

   public final Button Method30(ApplicationTheme var1, boolean var2) {
      Class180 var10000 = new Class180(this, var1.Name, (byte)1, var1, var2);
      String var4 = var1.Version;
      String var3 = "general.for";
      return var10000.Method110(Localized.Method398("general.for", var4, null)).Method115(Settings.Instance.ThemeName != null && Settings.Instance.ThemeName.equals(var1.Name)).Method99(var2 ? "new/file.rle" : "new/palette.rle");
   }

   static Class442 Method31(ThemesForm var0) {
      return var0.Field223;
   }
/*
   ThemesForm(Class442 var1) {
      this(var1, (byte)0);
   }*/
}
