import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

public final class Logger {
   private static StringBuffer sb = new StringBuffer();
   static boolean IsEnabled = true;

   public static void Close() {
      sb.setLength(0);
      System.gc();
   }

   public final void PrintInfo(String text) {
      PrintToConsole(text);
   }

   public static void PrintError(Throwable th) {
      PrintErrorWithMessage(th);
   }

   public static void PrintErrorWithMessage(Throwable th) {
      if (th != null) {
         PrintToConsole(th.toString() + ": " + th.getMessage());
      }

   }

   public static void PrintToConsole(String text)
   {
      if (text != null) {
         try {
            if (IsEnabled) {
               text = "[" + Class291.Method441(System.currentTimeMillis() / 1000L, true) + "] " + text;
               sb.append(text).append('\n');
               System.out.println(text);
            }

         } catch (OutOfMemoryError var1) {
            Close();
         }
      }
   }

   public static void SaveToFile(String text) {
      try {
         String fileName = System.currentTimeMillis() + "-vk.log";//vk4me
         FileConnection file = (FileConnection)Connector.open(text + fileName, 3);
         if (!file.exists()) {
            file.create();
         }

         OutputStream stream = file.openOutputStream();
         stream.write(sb.toString().getBytes(Class514.Field1364));
         sb.setLength(0);
         stream.close();
         file.close();
         Class198.Instance.Method483(Localized.GetString("general.message"), Localized.Method398("general.logSaved", fileName, null));
      } catch (Throwable var3) {
         Class198.Instance.ShowError(var3);
      }
   }
}
