public class VKDocument extends DataJson {
   private int id;
   public int size;
   private long owner_id;
   public String title;
   public String url;

   public final DataJson ProcessFields(JSONObject Json) {
      if (Json == null) {
         return this;
      } else {
         this.id = Json.optGetInt("id");
         this.owner_id = Json.optLong("owner_id");
         this.size = Json.optGetInt("size");
         Json.optGetInt("date");
         Json.optGetInt("type");
         this.title = Json.optGetString("title");
         Json.optGetString("ext");
         this.url = Json.optGetString("url");
         if ((Json = Json.Method180("preview")) != null) {
            (new Class44()).ProcessFields(Json);
         }

         return this;
      }
   }

   public final String toString() {
      return "doc" + this.owner_id + "_" + this.id;
   }
}
