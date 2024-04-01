public final class VKGroup extends VKGroupOrUser {
	public long id;
   public int is_closed;
   public int invited_by;
   public String name;
   public String screen_name;
   public String deactivated;
   public String photo_50;
   public String photo_100;
   public String status;
   public boolean Field856;
   public boolean Field857;
   public boolean Field858;
   public int members_count;
   public int audios;
   public int albums;
   public String description;
   public String activity;
   public int age_limits;
   public String city;
   public String country;
   public String site;
   public VKPhoto Field868;

   public VKGroup() {
      super(true);
   }

   public final String GetStatus() {
      return this.status;
   }

   public final String GetPhoto50() {
      return !IsStringEmpty(this.photo_50) ? this.photo_50 : null;
   }

   public final String GetPhoto100() {
      return !IsStringEmpty(this.photo_100) ? this.photo_100 : this.GetPhoto50();
   }

   public final String GetName(String var1) {
      return this.name;
   }

   public final long GetId() {
      return -this.id;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optLong("id");
         this.is_closed = json.optGetInt("is_closed");
         json.optGetInt("admin_level");
         this.invited_by = json.optGetInt("invited_by");
         this.name = json.optGetString("name");
         this.screen_name = json.optGetString("screen_name");
         this.deactivated = json.optGetString("deactivated");
         json.optGetString("type");
         this.photo_50 = json.optGetString("photo_50");
         this.photo_100 = json.optGetString("photo_100");
         this.members_count = json.optGetInt("members_count");
         this.Field857 = Method433(json.optGetInt("is_member"));
         json.optGetInt("is_admin");
         json.optGetInt("is_advertiser");
         this.status = json.optGetString("status");
         this.Field858 = json.optGetBoolean("can_message");
         JSONObject var2;
         if ((var2 = json.Method180("ban_info")) != null) {
            this.Field856 = true;
            var2.optGetString("comment");
            var2.getInt("reason", -1);
            var2.optGetInt("end_date");
         }

         if ((var2 = json.Method180("counters")) != null) {
            this.audios = var2.optGetInt("audios");
            this.albums = var2.optGetInt("albums");
            var2.optGetInt("photos");
            var2.optGetInt("videos");
            var2.optGetInt("topics");
            var2.optGetInt("docs");
         }

         this.description = json.optGetString("description");
         this.activity = json.optGetString("activity");
         this.age_limits = json.optGetInt("age_limits");
         this.site = json.optGetString("site");
         if ((var2 = json.Method180("city")) != null) {
            this.city = var2.optGetString("title");
         }

         if ((var2 = json.Method180("country")) != null) {
            this.country = var2.optGetString("title");
         }

         if ((var2 = json.Method180("crop_photo")) != null && (var2 = var2.Method180("photo")) != null) {
            this.Field868 = (VKPhoto)(new VKPhoto()).ProcessFields(var2);
         }

         return this;
      }
   }

   public final String Method355(String var1) {
      return this.name != null && this.name.length() > 0 ? this.name.charAt(0) + "." : this.name;
   }

   public final String Method349() {
      return this.screen_name;
   }
}
