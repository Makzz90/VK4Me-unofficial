public class VKVideo extends DataJson {
   private int id;
   public int duration;
   private long owner_id;
   public String title;
   public String description;
   public String platform;
   public String Field1114;
   public String Field1115;
   public String Field1116;
   public String Field1117;
   public String Field1118;
   public String Field1119;
   public String Field1120;

   public final String toString() {
      return "video" + this.owner_id + "_" + this.id;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optGetInt("id");
         this.owner_id = json.optLong("owner_id");
         JSONObject var2;
         if ((var2 = json.Method180("files")) != null) {
            this.Field1115 = var2.optGetString("mp4_1080");
            this.Field1116 = var2.optGetString("mp4_720");
            this.Field1117 = var2.optGetString("mp4_480");
            this.Field1118 = var2.optGetString("mp4_360");
            this.Field1119 = var2.optGetString("mp4_240");
            this.Field1120 = var2.optGetString("mp4_144");
         }

         this.description = json.optGetString("description");
         this.title = json.optGetString("title");
         this.platform = json.optGetString("platform");
         this.Field1114 = json.optGetString("player");
         this.duration = json.optGetInt("duration");
         return this;
      }
   }
}
