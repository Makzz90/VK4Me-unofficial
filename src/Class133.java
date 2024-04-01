public final class Class133 extends MethodsWithParameters {
   //private static Class Field523;

   public Class133() {
      super(/*Field523 == null ? (Field523 = Method4("gn")) : Field523,*/ "likes.delete");
   }

   public Class133(Class353 var1) {
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
