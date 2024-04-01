public final class Class505 extends DataJson {
   public String Field1355;

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         this.Field1355 = var1.optGetString("name");
         var1.optGetString("id");
         var1.optGetString("domain");
         return this;
      }
   }
}
