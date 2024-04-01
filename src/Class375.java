import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

final class Class375 extends Thread {
   private final String Field1084;
   private final Class362 Field1085;
   private final Class202 Field1086;

   Class375(Class202 var1, String var2, Class362 var3) {
      this.Field1086 = var1;
      this.Field1084 = var2;
      this.Field1085 = var3;
   }

   public final void run() {
      try {
         FileConnection var1 = (FileConnection)Connector.open(this.Field1084, 1);
         VKPhoto var2;
         if ((var2 = Class336.Method135(((ConversationHistoryPage)Class271.Method386(Class202.Method82(this.Field1086))._page).Field474.GetPeerId(), var1.getName(), var1.fileSize(), var1.openInputStream(), this.Field1085)) == null) {
            Class271.Method386(Class202.Method82(this.Field1086)).Method21();
         } else {
            Class271.Method386(Class202.Method82(this.Field1086)).Field1103 = var2;
         }

         var1.close();
      } catch (Exception var3) {
         Class198.Instance.ShowError(var3);
      }
   }
}
