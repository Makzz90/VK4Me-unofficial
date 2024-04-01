import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class21 extends Class247 {
   private final VKAudioMessage Field42;
   private final AttachmentItemUC Field43;

   Class21(AttachmentItemUC var1, boolean var2, Page var3, VKAudioMessage var4) {
      super(true, var3);
      this.Field43 = var1;
      this.Field42 = var4;
   }

   public final void Method27(String var1) {
      Class362 var2;
      Class459.Method195(var2 = new Class362(this.Field43));

      try {
         FileConnection var7;
         if (!(var7 = (FileConnection)Connector.open(var1 + this.Field42.toString() + ".mp3", 3)).exists()) {
            this.Method22();
            (new Class201(this, var7, var2)).start();
            return;
         }

         Class36 var3 = new Class36();
         String var5 = this.Field42.toString() + ".mp3";
         String var4 = "fm.replaceConfirm";
         var4 = Localized.Method398("fm.replaceConfirm", var5, null);
         TextBlock var10001 = new TextBlock(var4);
         //boolean var9 = true;
         TextBlock var8 = var10001;
         var10001.IsBold = true;
         var3.AddElement(var8.Method157(true));
         var3.AddElement(new Class203(this, Localized.GetString("action.ok"), var7, var2));
         var3.AddElement(new Class205(this, Localized.GetString("action.cancel")));
         Class198.Instance.Method481(var3);
      } catch (Exception var6) {
         Class198.Instance.ShowError(var6);
      }

   }

   static VKAudioMessage Method449(Class21 var0) {
      return var0.Field42;
   }
}
