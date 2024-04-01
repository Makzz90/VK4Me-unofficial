public final class Class494 extends MethodsWithParameters {
   //private static Class Field1347;

   public Class494() {
      super(/*Field1347 == null ? (Field1347 = Method4("pk")) : Field1347,*/ "messages.markAsRead");
   }

   public Class494(long peer_id, int start_message_id) {
      this();
      this.AddLong("peer_id", peer_id);
      this.AddIntiger("start_message_id", start_message_id);
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
