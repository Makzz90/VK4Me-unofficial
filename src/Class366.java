import java.io.IOException;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.DatagramConnection;
import javax.microedition.midlet.MIDlet;

public final class Class366 {
   private static final boolean Field1055 = System.getProperty("com.symbian.midp.serversocket.support") == null && System.getProperty("com.symbian.default.to.suite.icon") == null && System.getProperty("microedition.platform").indexOf("platform=S60") == -1;
   private static DatagramConnection Field1056;
   private static Exception Field1057;

   private static boolean Method271(MIDlet var0, String var1) throws IOException {
      try {
         return var0.platformRequest("javaapp:" + var1);
      } catch (ConnectionNotFoundException var2) {
         if (var2.getMessage() != null) {
            if (!var2.getMessage().startsWith("Cannot start Java application") && var2.getMessage().indexOf("following error: -12") == -1) {
               if (var2.getMessage().indexOf("Invalid localapp URL") == -1 && var2.getMessage().indexOf("Invalid URL") == -1) {
                  throw var2;
               } else {
                  throw new Class55(var2.getMessage());
               }
            } else {
               throw new Class110(var2.getMessage());
            }
         } else {
            throw var2;
         }
      }
   }

   public static boolean Method272(MIDlet var0, String var1, String var2, String var3, int var4, String var5) throws IOException {
      try {
         if (System.getProperty("com.nokia.mid.cmdline.instance") != null) {
            if (var3 == null) {
               return Method271(var0, "midlet-name=" + Page.Method374(var1) + ";midlet-vendor=" + Page.Method374(var2) + ";" + (var5 != null && var5.length() > 0 ? Page.Method374(var5) : "empty=1"));
            }

            return Method271(var0, "midlet-uid=" + Page.Method374(var3) + ";" + (var5 != null && var5.length() > 0 ? Page.Method374(var5) : "empty=1"));
         }
      } catch (IOException var6) {
      }

      return Method273(1260, var5);
   }

   private static boolean Method273(int var0, String var1) throws IOException {
      if (Field1056 != null) {
         throw new IllegalStateException();
      } else {
         Field1057 = null;

         try {
            if (var1 == null) {
               var1 = "empty=1";
            }

            Object var2 = new Object();
            Class462 var7;
            (var7 = new Class462(var0, var1, var2)).start();

            try {
               synchronized(var2) {
                  var2.wait(4000L);
               }
            } catch (Exception var5) {
            }

            if (Field1056 != null) {
               var7.interrupt();

               try {
                  Field1056.close();
               } catch (Exception var3) {
               }

               throw new Class110();
            } else if (Field1057 != null) {
               IOException var8 = (IOException)Field1057;
               Field1057 = null;
               throw var8;
            } else {
               return Field1055;
            }
         } catch (Error var6) {
            throw new Class55(var6.toString());
         }
      }
   }

   static DatagramConnection Method274(DatagramConnection var0) {
      Field1056 = var0;
      return var0;
   }

   static DatagramConnection Method275() {
      return Field1056;
   }

   static Exception Method276(Exception var0) {
      Field1057 = var0;
      return var0;
   }
}
