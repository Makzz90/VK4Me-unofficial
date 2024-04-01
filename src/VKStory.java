public class VKStory extends DataJson {
   private int id;
   private long owner_id;

   public final String toString() {
      return "story" + this.owner_id + "_" + this.id;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optGetInt("id");
         this.owner_id = json.optLong("owner_id");
         json.optGetString("type");
         JSONObject var2;
         if ((var2 = json.Method180("photo")) != null) {
            (new VKPhoto()).ProcessFields(var2);
         }

         if ((var2 = json.Method180("video")) != null) {
            (new VKVideo()).ProcessFields(var2);
         }

         return this;
      }
   }
}
