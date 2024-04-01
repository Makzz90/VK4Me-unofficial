import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class19 extends Class247 {
   private final VKDocument Field37;
   private final AttachmentItemUC Field38;

   Class19(AttachmentItemUC var1, boolean var2, Page var3, VKDocument var4) {
      super(true, var3);
      this.Field38 = var1;
      this.Field37 = var4;
   }

   public final void Method27(String var1) {
      Class362 var2;
      Class459.Method195(var2 = new Class362(this.Field38));

      try {
         FileConnection var7;
         if (!(var7 = (FileConnection)Connector.open(var1 + this.Field37.title, 3)).exists()) {
            this.Method22();
            (new Class168(this, var7, var2)).start();
            return;
         }

         Class36 var3 = new Class36();
         String var5 = this.Field37.title;
         String var4 = "fm.replaceConfirm";
         var4 = Localized.Method398("fm.replaceConfirm", var5, null);
         TextBlock var10001 = new TextBlock(var4);
         
         TextBlock var8 = var10001;
         var10001.IsBold = true;
         var3.AddElement(var8.Method157(true));
         var3.AddElement(new Class166(this, Localized.GetString("action.ok"), var7, var2));
         var3.AddElement(new Class169(this, Localized.GetString("action.cancel")));
         Class198.Instance.Method481(var3);
      } catch (Exception var6) {
         Class198.Instance.ShowError(var6);
      }

   }

   static VKDocument Method453(Class19 var0) {
      return var0.Field37;
   }
}
