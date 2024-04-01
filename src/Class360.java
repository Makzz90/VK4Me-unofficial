import java.util.Enumeration;

public final class Class360 extends Page {
   private VKGroupOrUser Field1045;

   public Class360(VKGroupOrUser var1) {
      super(Localized.GetString("title.additionalInfo"));
      Class31.Method515(var1.GetId(), "can_message,ban_info,can_write_private_message,can_see_audio,followers,friend_status,common_count,blacklisted,blacklisted_by_me,fixed_post,ban_info,members_count,counters,photo_50,photo_100,text,views,reposts,likes,status,sex,online,online_app,online_mobile,last_seen,first_name_nom,first_name_gen,first_name_dat,first_name_acc,first_name_ins,first_name_abl,last_name_nom,last_name_gen,last_name_dat,last_name_acc,last_name_ins,last_name_abl,screen_name,image_status,emoji_status,crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name,occupation,description,activity,age_limits,bdate,education,contacts,home_town,country,city,interests,books,activities,about,connections,relation,movies,music,games,tv,quotes,personal,site");
      this.Field1045 = Class31.GetUser(var1.GetId());
      if (this.Field1045 != null) {
         this.Method287("@" + this.Field1045.Method349());
         if (this.Field1045.is_group) {
            TextBlock var10001;
            VKGroup var2;
            boolean var3;
            TextBlock var4;
            if (!SomeStringUtils.IsStringEmpty((var2 = this.Field1045.GetGroup()).activity)) {
               var10001 = new TextBlock(Localized.GetString("element.activity"));
               var3 = true;
               var4 = var10001;
               var10001.IsBold = true;
               this.AddElement(var4);
               this.AddElement(new TextBlock(var2.activity));
            }

            if (var2.age_limits != 0) {
               var10001 = new TextBlock(Localized.GetString("element.age_limits"));
               var3 = true;
               var4 = var10001;
               var10001.IsBold = true;
               this.AddElement(var4);
               this.AddElement(new TextBlock(Localized.GetString("ageLimits." + (var2.age_limits == 2 ? "sixteen" : (var2.age_limits == 3 ? "eighteen" : "none")))));
            }

            if (!SomeStringUtils.IsStringEmpty(var2.description)) {
               var10001 = new TextBlock(Localized.GetString("element.description"));
               var3 = true;
               var4 = var10001;
               var10001.IsBold = true;
               this.AddElement(var4);
               this.AddElement(new TextBlock(var2.description));
            }

            if (!SomeStringUtils.IsStringEmpty(var2.site)) {
               var10001 = new TextBlock(Localized.GetString("element.site"));
               var3 = true;
               var4 = var10001;
               var10001.IsBold = true;
               this.AddElement(var4);
               this.AddElement(new Class51(this, var2.site, (byte)2, var2));
            }

            if (!SomeStringUtils.IsStringEmpty(var2.country)) {
               var10001 = new TextBlock(Localized.GetString("element.country_title"));
               var3 = true;
               var4 = var10001;
               var10001.IsBold = true;
               this.AddElement(var4);
               this.AddElement(new TextBlock(var2.country));
            }

            if (!SomeStringUtils.IsStringEmpty(var2.city)) {
               var10001 = new TextBlock(Localized.GetString("element.city_title"));
               var3 = true;
               var4 = var10001;
               var10001.IsBold = true;
               this.AddElement(var4);
               this.AddElement(new TextBlock(var2.city));
            }

            return;
         }

         this.Method0();
      }

   }

   private void Method0() {
      TextBlock var10001;
      VKUser var1;
      boolean var2;
      TextBlock var6;
      if (!SomeStringUtils.IsStringEmpty((var1 = this.Field1045.GetUser()).bdate)) {
         var10001 = new TextBlock(Localized.GetString("element.bdate"));
         var2 = true;
         var6 = var10001;
         var10001.IsBold = true;
         this.AddElement(var6);
         this.AddElement(new TextBlock(var1.bdate));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.about)) {
         var10001 = new TextBlock(Localized.GetString("element.about"));
         var2 = true;
         var6 = var10001;
         var10001.IsBold = true;
         this.AddElement(var6);
         this.AddElement(new TextBlock(var1.about));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.mobile_phone)) {
         var10001 = new TextBlock(Localized.GetString("element.mobile_phone"));
         var2 = true;
         var6 = var10001;
         var10001.IsBold = true;
         this.AddElement(var6);
         this.AddElement(new TextBlock(var1.mobile_phone));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.home_phone)) {
         var10001 = new TextBlock(Localized.GetString("element.home_phone"));
         var2 = true;
         var6 = var10001;
         var10001.IsBold = true;
         this.AddElement(var6);
         this.AddElement(new TextBlock(var1.home_phone));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field144)) {
         var10001 = new TextBlock(Localized.GetString("element.site"));
         var2 = true;
         var6 = var10001;
         var10001.IsBold = true;
         this.AddElement(var6);
         this.AddElement(new Class53(this, var1.Field144, (byte)2, var1));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field146) && !SomeStringUtils.IsStringEmpty(var1.Field145)) {
         this.AddElement((new TextBlock(Localized.GetString("element.occupation"))).SetBold(true));
         this.AddElement(new TextBlock(Localized.GetString("occupation." + var1.Field145) + ", " + var1.Field146));
      }

      String var8 = "";
      if (!SomeStringUtils.IsStringEmpty(var1.university_name)) {
         var8 = var8 + var1.university_name;
      }

      if (!SomeStringUtils.IsStringEmpty(var1.faculty_name)) {
         if (var8.length() != 0) {
            var8 = var8 + ", ";
         }

         var8 = var8 + var1.faculty_name;
      }

      if (var1.graduation != 0) {
         if (var8.length() != 0) {
            var8 = var8 + ", ";
         }

         var8 = var8 + var1.graduation;
      }

      if (var8.length() != 0) {
         this.AddElement((new TextBlock(Localized.GetString("element.education"))).SetBold(true));
         this.AddElement(new TextBlock(var8));
      }

      String var4;
      String var5;
      if (var1.Field136 != null && var1.Field136.length() > 0) {
         this.AddElement((new TextBlock(Localized.GetString("element.connections"))).SetBold(true));
         var8 = "";
         Enumeration var3 = var1.Field136.keys();

         while(var3.hasMoreElements()) {
            if ((var4 = (String)var3.nextElement()) != null && (var5 = var1.Field136.optGetString(var4)) != null) {
               var8 = var8 + var4 + ": " + var5;
            }
         }

         this.AddElement(new TextBlock(var8));
      }

      if (var1.Field137 != 0) {
         this.AddElement((new TextBlock(Localized.GetString("element.relation"))).SetBold(true));
         this.AddElement(new TextBlock(Localized.GetString("relation." + String.valueOf(var1.Field137))));
         if (var1.Field147 != 0) {
            this.AddElement(LoginForm.GetHeaderElement(Class31.GetUser((long)var1.Field147), false, false, false, false, this));
         }
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field131)) {
         this.AddElement((new TextBlock(Localized.GetString("element.country_title"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field131));
      }

      if (!SomeStringUtils.IsStringEmpty(null)) {
         this.AddElement((new TextBlock(Localized.GetString("element.city_title"))).SetBold(true));
         this.AddElement(new TextBlock(null));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.home_town)) {
         this.AddElement((new TextBlock(Localized.GetString("element.home_town"))).SetBold(true));
         this.AddElement(new TextBlock(var1.home_town));
      }

      if (var1.personal != null) {
         this.AddElement((new TextBlock(Localized.GetString("element.personal"))).SetBold(true));
         int var10;
         if ((var10 = var1.personal.optGetInt("political")) != 0) {
            this.AddElement((new TextBlock(Localized.GetString("element.political"))).SetBold(true));
            this.AddElement(new TextBlock(Localized.GetString("political." + String.valueOf(var10))));
         }

         JSONArray var7;
         if ((var7 = var1.personal.optJSONArray("langs")) != null && var7.Count() != 0) {
            var4 = "";

            for(int i = 0; i < var7.Count(); i++) {
               if ((var8 = var7.Method510(i)) != null) {
                  if (var4.length() != 0) {
                     var4 = var4 + ", ";
                  }

                  var4 = var4 + var8;
               }
            }

            if (var4.length() != 0) {
               this.AddElement((new TextBlock(Localized.GetString("element.langs"))).SetBold(true));
               this.AddElement(new TextBlock(var4));
            }
         }

         if (!SomeStringUtils.IsStringEmpty(var4 = var1.personal.optGetString("religion"))) {
            this.AddElement((new TextBlock(Localized.GetString("element.religion"))).SetBold(true));
            this.AddElement(new TextBlock(var4));
         }

         if (!SomeStringUtils.IsStringEmpty(var5 = var1.personal.optGetString("inspired_by"))) {
            this.AddElement((new TextBlock(Localized.GetString("element.inspiredBy"))).SetBold(true));
            this.AddElement(new TextBlock(var5));
         }

         if ((var10 = var1.personal.optGetInt("people_main")) != 0) {
            this.AddElement((new TextBlock(Localized.GetString("element.people_main"))).SetBold(true));
            this.AddElement(new TextBlock(Localized.GetString("people_main." + String.valueOf(var10))));
         }

         if ((var10 = var1.personal.optGetInt("life_main")) != 0) {
            this.AddElement((new TextBlock(Localized.GetString("element.life_main"))).SetBold(true));
            this.AddElement(new TextBlock(Localized.GetString("life_main." + String.valueOf(var10))));
         }

         if ((var10 = var1.personal.optGetInt("smoking")) != 0) {
            this.AddElement((new TextBlock(Localized.GetString("element.smoking"))).SetBold(true));
            this.AddElement(new TextBlock(Localized.GetString("attitude." + String.valueOf(var10))));
         }

         if ((var10 = var1.personal.optGetInt("alcohol")) != 0) {
            this.AddElement((new TextBlock(Localized.GetString("element.alcohol"))).SetBold(true));
            this.AddElement(new TextBlock(Localized.GetString("attitude." + String.valueOf(var10))));
         }
      }

      if (!SomeStringUtils.IsStringEmpty(var1.interests)) {
         this.AddElement((new TextBlock(Localized.GetString("element.interests"))).SetBold(true));
         this.AddElement(new TextBlock(var1.interests));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field134)) {
         this.AddElement((new TextBlock(Localized.GetString("element.activities"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field134));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.books)) {
         this.AddElement((new TextBlock(Localized.GetString("element.books"))).SetBold(true));
         this.AddElement(new TextBlock(var1.books));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field141)) {
         this.AddElement((new TextBlock(Localized.GetString("element.tv"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field141));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field138)) {
         this.AddElement((new TextBlock(Localized.GetString("element.movies"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field138));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field139)) {
         this.AddElement((new TextBlock(Localized.GetString("element.music"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field139));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field140)) {
         this.AddElement((new TextBlock(Localized.GetString("element.games"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field140));
      }

      if (!SomeStringUtils.IsStringEmpty(var1.Field142)) {
         this.AddElement((new TextBlock(Localized.GetString("element.quotes"))).SetBold(true));
         this.AddElement(new TextBlock(var1.Field142));
      }

   }
}
