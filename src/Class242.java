public final class Class242 extends VKAttachment {
   public int Field763;
   public long Field764;
   public String Field765;
   public String Field766;

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         this.Field763 = var1.optGetInt("id");
         var1.optGetInt("thumb_id");
         this.Field764 = var1.optLong("owner_id");
         this.Field765 = var1.optGetString("title");
         this.Field766 = var1.optGetString("description");
         var1.optGetInt("created");
         var1.optGetInt("updated");
         var1.optGetInt("size");
         var1.optGetString("thumb_src");
         return this;
      }
   }

   public final String toString() {
      return "album" + this.Field764 + "_" + this.Field763;
   }
}
