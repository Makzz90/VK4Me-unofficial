import java.util.Random;
import java.util.Vector;

public final class Class176 extends MethodsWithParameters {
   private static Random Field585 = new Random();
   //private static Class Field586;

   public Class176() {
      super(/*Field586 == null ? (Field586 = Method4("ju")) : Field586,*/ "messages.send");
      long var2 = Field585.nextLong();
      this.AddParameter("random_id", String.valueOf(var2 > 0L ? var2 : -var2));
   }

   public Class176(long var1, String var3) {
      this();
      this.AddLong("peer_id", var1);
      this.AddParameter("message", var3 != null ? Class278.Method377(var3) : null);
   }

   public final Class176 Method412(String var1) {
      this.AddParameter("attachment", var1);
      return this;
   }

   public final Class176 Method413(Vector var1) {
      if (var1 == null) {
         this.AddParameter("forward_messages", null);
      }

      Vector var2 = new Vector();

      for(int i = 0; i < var1.size(); i++) {
         if (var1.elementAt(i) != null) {
            var2.addElement(String.valueOf(((VKMessage)var1.elementAt(i)).id));
         }
      }

      if (var1.isEmpty()) {
         this.AddParameter("forward_messages", null);
      } else {
         this.AddParameter("forward_messages", Class291.Method440(",", var2));
      }

      return this;
   }

   public final Class176 Method414(VKMessage var1) {
      this.AddParameter("reply_to", var1 == null ? null : String.valueOf(var1.id));
      return this;
   }
/*
   private static Class Method4(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var1) {
         throw new NoClassDefFoundError(var1.getMessage());
      }
   }*/
}
