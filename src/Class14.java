import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class14 extends Class247 {
   private final VKAudio Field25;
   private final AttachmentItemUC Field26;

   Class14(AttachmentItemUC var1, boolean var2, Page var3, VKAudio var4) {
      super(true, var3);
      this.Field26 = var1;
      this.Field25 = var4;
   }

   public final void Method27(String var1) {
      Class362 var2;
      Class459.Method195(var2 = new Class362(this.Field26));

      try {
         String var3 = Class435.Method32(this.Field25);
         FileConnection var7;
         if (!(var7 = (FileConnection)Connector.open(var1 + var3, 3)).exists()) {
            this.Method22();
            (new Class163(this, var7, var2)).start();
            return;
         }

         Class36 var4 = new Class36();
         String var5 = var3;
         var3 = "fm.replaceConfirm";
         var3 = Localized.Method398("fm.replaceConfirm", var5, null);
         TextBlock var10001 = new TextBlock(var3);
         boolean var9 = true;
         TextBlock var8 = var10001;
         var10001.IsBold = true;
         var4.AddElement(var8.Method157(true));
         var4.AddElement(new Class160(this, Localized.GetString("action.ok"), var7, var2));
         var4.AddElement(new Class161(this, Localized.GetString("action.cancel")));
         Class198.Instance.Method481(var4);
      } catch (Exception var6) {
         Class198.Instance.ShowError(var6);
      }

   }

   static VKAudio Method409(Class14 var0) {
      return var0.Field25;
   }
}
