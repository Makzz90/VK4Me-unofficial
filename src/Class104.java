public final class Class104 extends MethodsWithParameters {
   //private static Class Field456;

   public Class104() {
      super(/*Field456 == null ? (Field456 = Method4("c")) : Field456,*/ "likes.add");
   }

   public Class104(Class353 var1) {
      this();
      this.AddParameter("type", var1.GetType());
      this.AddLong("owner_id", var1.GetOwnerId());
      this.AddIntiger("item_id", var1.GetId());
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
