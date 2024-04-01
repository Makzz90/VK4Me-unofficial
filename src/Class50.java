

public final class Class50 extends MethodsWithParameters {
   //private static Class Field150;

   public Class50() {
      super(/*Field150 == null ? (Field150 = Method4("co")) : Field150,*/ "messages.edit");
      this.AddParameter("keep_forward_messages", "1");
      this.AddParameter("keep_snippets", "1");
   }

   public Class50(long peer_id, int var3, String var4) {
      this();
      this.AddLong("peer_id", peer_id);
      this.AddIntiger("message_id", var3);
      this.AddParameter("message", !IsStringEmpty(var4) ? Class278.Method377(var4) : null);
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
