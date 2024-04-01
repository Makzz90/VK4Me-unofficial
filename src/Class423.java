public final class Class423 extends VKResponse {
   //private static Class Field1178;

   public Class423()
   {
      super(/*Field1178 == null ? (Field1178 = Method4("hp")) : Field1178,*/ "newsfeed.get");//Class224
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
      this.AddIntiger("return_banned", 0);
      this.AddIntiger("max_photos", 4);
      this.AddCountParameter(20);
      this.AddParameter("filters", "post");
   }

   public final Class423 AddCountParameter(int var1) {
      this.AddIntiger("count", var1);
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
