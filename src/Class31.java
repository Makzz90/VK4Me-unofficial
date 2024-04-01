import java.util.Hashtable;

public final class Class31 {
   private static Hashtable _dictionary = new Hashtable();

   public static VKGroupOrUser GetUser(long userId)  {
      if (userId == 0) {
         userId = Settings.Instance.UserId;
      }

      if (!_dictionary.containsKey(String.valueOf(userId))) {
         Method515(userId, "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
      }

      return (VKGroupOrUser)_dictionary.get(String.valueOf(userId));
   }

   public static void Method514(long userId)
   {
		Method515(userId, "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   public static void Method515(long userId, String fields)  {
      if (Settings.Instance.IsAutorized()) {
         if (userId == 0L) {
            userId = Settings.Instance.UserId;
         }

         if (userId > 0L)
         {
            Class185 var4;
            //
            var4 = new Class185();
            Class216 temp = new Class216(userId);
            temp.AddParameter("fields", fields);
            JSONObject result = temp.GetResponse();
            var4.ProcessFields(result);
            //
            //if ((var4 = (Class185)(new Class216(userId)).AddParameter("fields", fields).DoDispatch()) != null && var4.Method213())
            if (var4 != null && var4.Method213())
            {
               AddToCache(var4.Method351());
            }

            return;
         }

         Class394 var3;
         //
         Class473 temp = new Class473(userId);
         temp.AddParameter("fields", fields);
         var3 = new Class394();
         JSONObject result = temp.GetResponse();
         var3.ProcessFields(result);
         //
         //if (userId != 0L && (var3 = (Class394)(new Class473(userId)).AddParameter("fields", fields).DoDispatch()) != null && var3.Method350() != null)
         if (userId != 0L && var3 != null && var3.Method350() != null)
         {
            AddToCache(var3.Method350());
         }
      }

   }

   public static void Method516(VKError error) {
      if (error != null)
      {
         VKUser user;
         VKGroup group;
         int i;
         //TODO
         /*
         if (error instanceof VKUsersAndGroups)
         {
            VKUsersAndGroups var11;
            VKUsersAndGroups var13;
            if ((var13 = var11 = (VKUsersAndGroups)error).users != null && var13.users.length > 0) {
               for(i = 0; i < var11.users.length; i++) {
                  if ((user = var11.users[i]) != null) {
                     AddToCache(user);
                  }
               }
            }

            if (var11.groups != null && var11.groups.length > 0) {
               for(i = 0; i < var11.groups.length; i++) {
                  if ((group = var11.groups[i]) != null) {
                     AddToCache(group);
                  }
               }
            }

         } else */if (error instanceof Class185) {
            Class185 var9;
            if ((var9 = (Class185)error).Method36()) {
               for(i = 0; i < var9.Field597.length; i++) {
                  if ((user = var9.Field597[i]) != null) {
                     AddToCache(user);
                  }
               }
            }

         } else if (error instanceof Class394) {
            Class394 var8;
            if ((var8 = (Class394)error).Method36()) {
               for(i = 0; i < var8.Field1137.length; i++) {
                  if ((group = var8.Field1137[i]) != null) {
                     AddToCache(group);
                  }
               }
            }

         }/*
         else if (error instanceof Class294) {
            Class294 var6= (Class294)error;
            if (var6.GotSomeGroups())
            {
               for(i = 0; i < var6.groups.length; i++) {
                  if ((group = var6.groups[i]) != null) {
                     AddToCache(group);
                  }
               }
            }

         }
         else if (error instanceof Class195) {
            Class195 var5;
            if ((var5 = (Class195)error).GotSomeItems()) {
               for(i = 0; i < var5.Field614.length; i++) {
                  if ((user = var5.Field614[i]) != null) {
                     AddToCache(user);
                  }
               }
            }

         }*/ 
         else if (error instanceof Class192) {
            Class192 var4;
            Class192 var10;
            if ((var10 = var4 = (Class192)error).Field610 != null && var10.Field610.length > 0) {
               for(i = 0; i < var4.Field610.length; i++) {
                  if ((user = var4.Field610[i]) != null) {
                     AddToCache(user);
                  }
               }
            }

         } else {
            Class392 var1;
            Class392 var3;
            if (error instanceof Class392 && (var1 = var3 = (Class392)error).Field1136 != null && var1.Field1136.length > 0) {
               for(i = 0; i < var3.Field1136.length; i++) {
                  if ((user = var3.Field1136[i]) != null) {
                     AddToCache(user);
                  }
               }
            }

         }
      }
   }

   public static long AddToCache(VKGroupOrUser profile) {
      _dictionary.put(String.valueOf(profile.GetId()), profile);
      return profile.GetId();
   }
}
