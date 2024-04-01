import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class465 extends Thread {
   private final String Field1286;
   private final Class362 Field1287;
   private final Class211 Field1288;

   Class465(Class211 var1, String var2, Class362 var3) {
      this.Field1288 = var1;
      this.Field1286 = var2;
      this.Field1287 = var3;
   }

   public final void run() {
      try {
         FileConnection var1 = (FileConnection)Connector.open(this.Field1286, 1);
         VKAttachment var2;
         if ((var2 = Class336.Method136(((ConversationHistoryPage)Class269.Method358(Class211.Method138(this.Field1288))._page).Field474.GetPeerId(), var1.getName(), var1.fileSize(), var1.openInputStream(), this.Field1287)) == null) {
            Class269.Method358(Class211.Method138(this.Field1288)).Method21();
         } else {
            Class269.Method358(Class211.Method138(this.Field1288)).Field1103 = var2;
         }

         var1.close();
      } catch (Exception var3) {
         Class198.Instance.ShowError(var3);
      }
   }
}
