public class VKGraffiti extends DataJson implements Class184 {
   private int width;
   private int height;
   private int id;
   private long owner_id;
   private String url;

   public final String GetUrl(int var1) {
      return this.url;
   }

   public final int GetWidth(int var1) {
      return this.width;
   }

   public final int GetHeight(int var1) {
      return this.height;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.url = json.has("src") ? json.optGetString("src") : json.optGetString("url");
         this.width = json.optGetInt("width");
         this.height = json.optGetInt("height");
         this.owner_id = json.optLong("owner_id");
         this.id = json.optGetInt("id");
         return this;
      }
   }

   public final String toString() {
      return "graffiti" + this.owner_id + "_" + this.id;
   }
}
