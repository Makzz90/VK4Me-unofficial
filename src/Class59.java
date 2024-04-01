

public final class Class59 extends MethodsWithParameters {
   //private static Class Field157;

   public Class59() {
      super(/*Field157 == null ? (Field157 = Method4("hb")) : Field157,*/ "photos.saveMessagesPhoto");
   }

   public Class59(String var1, long server, String var4) {
      this();
      this.AddParameter("photo", var1 != null ? Class278.Method377(var1) : null);
      this.AddLong("server", server);
      this.AddParameter("hash", var4);
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
