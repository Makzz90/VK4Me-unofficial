public final class Class71 extends DataJson {
   public String Field203;
   public String Field204;

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         var1.optGetInt("width");
         var1.optGetInt("height");
         this.Field203 = var1.optGetString("photo_68");
         this.Field204 = var1.optGetString("photo_135");
         var1.optGetString("photo_270");
         var1.optGetString("photo_300");
         var1.optGetString("photo_600");
         return this;
      }
   }
}
