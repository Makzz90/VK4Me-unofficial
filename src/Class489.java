public final class Class489 extends DataJson {
   public String Field1335;
   public String Field1336;

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         this.Field1335 = var1.optGetString("photo_50");
         this.Field1336 = var1.optGetString("photo_100");
         return this;
      }
   }
}
