import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class12 extends Class247 {
   private final VKVideo Field21;
   private final String Field22;
   private final String Field23;
   private final AttachmentItemUC Field24;

   Class12(AttachmentItemUC var1, boolean var2, Page var3, VKVideo var4, String var5, String var6) {
      super(true, var3);
      this.Field24 = var1;
      this.Field21 = var4;
      this.Field22 = var5;
      this.Field23 = var6;
   }

   public final void Method27(String var1) {
      Class362 var2;
      Class459.Method195(var2 = new Class362(this.Field24));

      try {
         FileConnection var7;
         if (!(var7 = (FileConnection)Connector.open(var1 + this.Field21.toString() + "_" + this.Field22 + ".mp4", 3)).exists()) {
            this.Method22();
            (new Class90(this, var7, var2)).start();
            return;
         }

         Class36 var3 = new Class36();
         String var5 = this.Field21.toString() + ".mp4";
         String var4 = "fm.replaceConfirm";
         var4 = Localized.Method398("fm.replaceConfirm", var5, null);
         TextBlock var10001 = new TextBlock(var4);
         
         TextBlock var8 = var10001;
         var10001.IsBold = true;
         var3.AddElement(var8.Method157(true));
         var3.AddElement(new Class82(this, Localized.GetString("action.ok"), var7, var2));
         var3.AddElement(new Class88(this, Localized.GetString("action.cancel")));
         Class198.Instance.Method481(var3);
      } catch (Exception var6) {
         Class198.Instance.ShowError(var6);
      }

   }

   static String Method408(Class12 var0) {
      return var0.Field23;
   }
}
