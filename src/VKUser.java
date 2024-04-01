import java.util.Hashtable;

public final class VKUser extends VKGroupOrUser {
   public static boolean ReverseNames = false;
   public long id;
   public int sex;
   public String first_name;
   public String last_name;
   public String deactivated;
   private String photo_50;
   private String photo_100;
   public String status;
   private String screen_name;
   public boolean blacklisted;
   public int online;
   public int online_mobile;
   public int online_app;
   public int last_seen;
   public int friend_status;
   private Hashtable Field115 = new Hashtable();
   private Hashtable Field116 = new Hashtable();
   public boolean can_write_private_message;
   public int audios;
   public int friends;
   public int groups;
   public int online_friends;
   public int albums;
   public VKPhoto Field123;
   public String bdate;
   public String university_name;
   public String faculty_name;
   public int graduation;
   public String mobile_phone;
   public String home_phone;
   public String home_town;
   public String Field131;
   public String interests;
   public String books;
   public String Field134;
   public String about;
   public JSONObject Field136;
   public int Field137;
   public String Field138;
   public String Field139;
   public String Field140;
   public String Field141;
   public String Field142;
   public JSONObject personal;
   public String Field144;
   public String Field145;
   public String Field146;
   public int Field147;

   public final String GetStatus() {
      return this.status;
   }

   public VKUser() {
      super(false);
   }

   public final String GetPhoto50() {
      return !IsStringEmpty(this.photo_50) ? this.photo_50 : null;
   }

   public final long GetId() {
      return this.id;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optLong("id");
         this.sex = json.optGetInt("sex");
         this.status = json.optGetString("status");
         this.first_name = json.optGetString("first_name");
         this.last_name = json.optGetString("last_name");
         this.deactivated = json.optGetString("deactivated");
         this.photo_50 = json.optGetString("photo_50");
         this.photo_100 = json.optGetString("photo_100");
         json.optGetBoolean("is_closed");
         json.optGetBoolean("can_access_closed");
         this.online = json.optGetInt("online");
         this.online_app = json.optGetInt("online_app");
         this.online_mobile = json.optGetInt("online_mobile");
         this.friend_status = json.optGetInt("friend_status");
         this.blacklisted = Method433(json.optGetInt("blacklisted"));
         json.optGetInt("blacklisted_by_me");
         json.optGetInt("can_see_audio");
         this.can_write_private_message = Method433(json.optGetInt("can_write_private_message"));
         this.screen_name = json.optGetString("screen_name");
         JSONObject var2;
         if ((var2 = json.Method180("counters")) != null) {
            this.audios = var2.optGetInt("audios");
            this.friends = var2.optGetInt("friends");
            this.groups = var2.optGetInt("groups");
            this.online_friends = var2.optGetInt("online_friends");
            var2.optGetInt("mutual_friends");
            var2.optGetInt("followers");
            var2.optGetInt("photos");
            this.albums = var2.optGetInt("albums");
            var2.optGetInt("videos");
         }

         if ((var2 = json.Method180("last_seen")) != null) {
            this.last_seen = var2.optGetInt("time");
            var2.optGetInt("platform");
         }

         this.Field115.put("first_name_nom", json.getString("first_name_nom", this.first_name));
         this.Field115.put("first_name_gen", json.getString("first_name_gen", this.first_name));
         this.Field115.put("first_name_dat", json.getString("first_name_dat", this.first_name));
         this.Field115.put("first_name_acc", json.getString("first_name_acc", this.first_name));
         this.Field115.put("first_name_ins", json.getString("first_name_ins", this.first_name));
         this.Field115.put("first_name_abl", json.getString("first_name_abl", this.first_name));
         this.Field116.put("last_name_nom", json.getString("last_name_nom", this.last_name));
         this.Field116.put("last_name_gen", json.getString("last_name_gen", this.last_name));
         this.Field116.put("last_name_dat", json.getString("last_name_dat", this.last_name));
         this.Field116.put("last_name_acc", json.getString("last_name_acc", this.last_name));
         this.Field116.put("last_name_ins", json.getString("last_name_ins", this.last_name));
         this.Field116.put("last_name_abl", json.getString("last_name_abl", this.last_name));
         this.bdate = json.optGetString("bdate");
         if ((var2 = json.Method180("education")) != null) {
            this.university_name = var2.optGetString("university_name");
            this.faculty_name = var2.optGetString("faculty_name");
            this.graduation = var2.optGetInt("graduation");
         }

         if ((var2 = json.Method180("contacts")) != null) {
            this.mobile_phone = var2.optGetString("mobile_phone");
            this.home_phone = var2.optGetString("home_phone");
         }

         this.home_town = json.optGetString("home_town");
         if ((var2 = json.Method180("country")) != null) {
            this.Field131 = var2.optGetString("title");
         }

         if ((var2 = json.Method180("city")) != null) {
            this.Field131 = var2.optGetString("title");
         }

         this.interests = json.optGetString("interests");
         this.books = json.optGetString("books");
         this.Field134 = json.optGetString("activities");
         this.about = json.optGetString("about");
         this.Field137 = json.optGetInt("relation");
         this.Field138 = json.optGetString("movies");
         this.Field139 = json.optGetString("music");
         this.Field140 = json.optGetString("games");
         this.Field141 = json.optGetString("tv");
         this.Field142 = json.optGetString("quotes");
         this.Field144 = json.optGetString("site");
         this.Field136 = json.Method180("connections");
         this.personal = json.Method180("personal");
         if ((var2 = json.Method180("occupation")) != null) {
            this.Field145 = var2.optGetString("type");
            this.Field146 = var2.optGetString("name");
         }

         if ((var2 = json.Method180("crop_photo")) != null && (var2 = var2.Method180("photo")) != null) {
            this.Field123 = (VKPhoto)(new VKPhoto()).ProcessFields(var2);
         }

         if ((var2 = json.Method180("relation_partner")) != null) {
            this.Field147 = var2.optGetInt("id");
         }

         return this;
      }
   }

   public final String GetPhoto100() {
      return !IsStringEmpty(this.photo_100) ? this.photo_100 : this.GetPhoto50();
   }

   public final String Method355(String var1) {
      return ReverseNames ? this.Method527(var1) : this.Method526(var1);
   }

   public final String GetName(String var1) {
      return !IsStringEmpty(var1) && this.Field116.containsKey("last_name_" + var1) && this.Field115.containsKey("first_name_" + var1) ? this.Field115.get("first_name_" + var1) + " " + this.Field116.get("last_name_" + var1) : this.first_name + " " + this.last_name;
   }

   public final String Method526(String var1) {
      String var2 = (String)this.Field116.get("last_name_" + var1);
      var1 = (String)this.Field115.get("first_name_" + var1);
      if (var2 == null) {
         var2 = this.last_name;
      }

      if (var1 == null) {
         var1 = this.first_name;
      }

      return (var1 != null && var1.length() > 0 ? var1.charAt(0) + ". " : "") + var2;
   }

   public final String Method527(String var1) {
      String var2 = (String)this.Field116.get("last_name_" + var1);
      var1 = (String)this.Field115.get("first_name_" + var1);
      if (var2 == null) {
         var2 = this.last_name;
      }

      if (var1 == null) {
         var1 = this.first_name;
      }

      return var1 + (var2 != null && var2.length() > 0 ? " " + var2.charAt(0) + "." : "");
   }

   public final String Method349() {
      return this.screen_name;
   }
}
