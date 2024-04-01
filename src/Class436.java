import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class436 extends Class247 {
   private final VKPhoto Field1207;
   private final String Field1208;
   private final Class75 Field1209;

   Class436(Class75 var1, boolean var2, Page var3, VKPhoto var4, String var5) {
      super(true, var3);
      this.Field1209 = var1;
      this.Field1207 = var4;
      this.Field1208 = var5;
   }

   public final void Method27(String var1) {
      Class362 var2;
      Class459.Method195(var2 = new Class362(this.Field1209));

      try {
         String var3 = this.Field1207.toString() + (this.Field1207 instanceof VKPhoto ? ".jpeg" : ".png");
         FileConnection var7;
         if (!(var7 = (FileConnection)Connector.open(var1 + var3, 3)).exists()) {
            this.Method22();
            (new Class419(this, var7, var2)).start();
            return;
         }

         Class36 var4 = new Class36();
         String var5 = var3;
         var3 = "fm.replaceConfirm";
         var3 = Localized.Method398("fm.replaceConfirm", var5, null);
         TextBlock var10001 = new TextBlock(var3);
         //boolean var9 = true;
         TextBlock var8 = var10001;
         var10001.IsBold = true;
         var4.AddElement(var8.Method157(true));
         var4.AddElement(new Class421(this, Localized.GetString("action.ok"), var7, var2));
         var4.AddElement(new Class420(this, Localized.GetString("action.cancel")));
         Class198.Instance.Method481(var4);
      } catch (Exception var6) {
         Class198.Instance.ShowError(var6);
      }

   }

   static String Method28(Class436 var0) {
      return var0.Field1208;
   }
}
