public final class Class263 extends MethodsWithParameters {
   //private static Class Field828;

   public Class263(int var1, int offset, boolean var3) {
      super(/*Field828 == null ? (Field828 = Method4("fn")) : Field828,*/ "friends.getRequests");
      this.AddIntiger("offset", offset);
      this.AddIntiger("count", 5);
      this.AddIntiger("out", var3 ? 1 : 0);//this.Method421("out", Method426(var3));
      this.AddIntiger("extended", 1);
      this.AddIntiger("need_viewed", 1);
      this.AddIntiger("suggested", 0);
      this.AddIntiger("need_mutual", 0);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
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
