import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.Datagram;
import javax.microedition.io.DatagramConnection;

final class Class462 extends Thread {
   private final int Field1282;
   private final String Field1283;
   private final Object Field1284;

   Class462(int var1, String var2, Object var3) {
      this.Field1282 = var1;
      this.Field1283 = var2;
      this.Field1284 = var3;
   }

   public final void run() {
      try {
         Class366.Method274((DatagramConnection)Connector.open("datagram://127.0.0.1:" + this.Field1282));
         Datagram var1;
         (var1 = Class366.Method275().newDatagram(Class366.Method275().getMaximumLength())).reset();
         var1.writeUTF(this.Field1283);
         Class366.Method275().send(var1);

         try {
            Class366.Method275().send(var1);
         } catch (Exception var4) {
         }

         Class366.Method275().close();
      } catch (IOException var5) {
         Class366.Method276(var5);
      } catch (Exception var6) {
      }

      Class366.Method274((DatagramConnection)null);
      synchronized(this.Field1284) {
         this.Field1284.notify();
      }
   }
}
