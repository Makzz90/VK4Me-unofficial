public final class Class434 extends MethodsWithParameters {
   //private static Class Field1205;

   public Class434() {
      super(/*Field1205 == null ? (Field1205 = Method4("ba")) : Field1205,*/ "messages.delete");
   }

   public Class434(int var1) {
      this();
      this.AddIntiger("message_ids", var1);
   }

   public final Class434 Method41(boolean var1) {
      this.AddParameter("delete_for_all", var1 ? "1" : null);
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
