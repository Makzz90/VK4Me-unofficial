

public final class Class479 extends MethodsWithParameters {
   //private static Class Field1313;

   public Class479() {
      super(/*Field1313 == null ? (Field1313 = Method4("pj")) : Field1313,*/ "wall.editComment");
   }

   public Class479(long var1, int var3, String var4) {
      this();
      this.AddLong("owner_id", var1);
      this.AddIntiger("comment_id", var3);
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
