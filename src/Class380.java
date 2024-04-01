public final class Class380 extends MethodsWithParameters {
   //private static Class Field1121;

   public Class380(long var1) {
      this(var1, "doc");
   }

   private Class380(long var1, String var3) {
      super(/*Field1121 == null ? (Field1121 = Method4("ex")) : Field1121,*/ "docs.getMessagesUploadServer");
      this.AddParameter("type", var3);
      this.AddParameter("peer_id", var1 != 0L ? String.valueOf(var1) : null);
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
