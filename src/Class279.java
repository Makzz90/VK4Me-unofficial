import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class279 extends Class247 {
   private final Class181 Field879;

   Class279(Class181 var1, boolean var2, Page var3) {
      super(false, var3);
      this.Field879 = var1;
   }

   public final void Method27(String var1) {
      try {
         Class198.Field618.Method479(true);
         if (!var1.endsWith(".theme")) {
            throw new IllegalArgumentException(Localized.GetString("error.invalidThemeFile"));
         }

         FileConnection var6;
         byte[] var2 = Class278.Method378((var6 = (FileConnection)Connector.open(var1, 1)).openInputStream());
         var6.close();
         Colors var7;
         if (Class291.IsNullOrEmpty((var7 = new Colors(var2)).Field283.Name)) {
            throw new IllegalArgumentException(Localized.GetString("error.invalidThemeFile"));
         }

         ApplicationTheme[] var3 = Class6.Method340();

         int var4;
         for(var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4] != null && var3[var4].Name != null && var3[var4].Name.equals(var7.Field283.Name)) {
               throw new IllegalArgumentException(Localized.GetString("error.themeInstalledAlready"));
            }
         }

         var3 = Settings.Instance.ThemeList;

         for(var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4] != null && var3[var4].Name != null && var3[var4].Name.equals(var7.Field283.Name)) {
               throw new IllegalArgumentException(Localized.GetString("error.themeInstalledAlready"));
            }
         }

         Class98.AddRecord(var7.Field283.Name + "_theme", var2);
         (var3 = new ApplicationTheme[Settings.Instance.ThemeList.length + 1])[var3.length - 1] = var7.Field283;
         System.arraycopy(Settings.Instance.ThemeList, 0, var3, 0, Settings.Instance.ThemeList.length);
         Settings.Instance.ThemeList = var3;
         Settings.Instance.LoadThemesAndLangs();
         Class181.Method448(this.Field879).Method293(Class181.Method448(this.Field879).Method30(var7.Field283, true).Method158(true), Class181.Method448(this.Field879).Count() - 1);
         Class198.Field618.Method468(Class181.Method448(this.Field879));
      } catch (Throwable var5) {
         Class198.Field618.Method486(var5);
      }

      Class198.Field618.Method479(false);
   }
}
