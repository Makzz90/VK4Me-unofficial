public final class Class393 extends DataJson {
   public final DataJson ProcessFields(JSONObject jObject) {
      if (jObject == null) {
         return this;
      } else {
         jObject.optGetInt("id");
         jObject.optGetString("name");
         return this;
      }
   }
}
