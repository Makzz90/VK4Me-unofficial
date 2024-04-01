import java.util.Vector;

public final class Class216 extends MethodsWithParameters {
   private Vector Field718;
   //private static Class Field719;

   public Class216() {
      super(/*Field719 == null ? (Field719 = Method4("gc")) : Field719,*/ "users.get");
      this.Field718 = new Vector();
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "can_message,ban_info,can_write_private_message,can_see_audio,followers,friend_status,common_count,blacklisted,blacklisted_by_me,fixed_post,ban_info,members_count,counters,photo_50,photo_100,text,views,reposts,likes,status,sex,online,online_app,online_mobile,last_seen,first_name_nom,first_name_gen,first_name_dat,first_name_acc,first_name_ins,first_name_abl,last_name_nom,last_name_gen,last_name_dat,last_name_acc,last_name_ins,last_name_abl,screen_name,image_status,emoji_status");
   }

   public Class216(long var1) {
      this();
      long var4 = var1;
      if (var1 < 0L) {
         var4 = -var1;
      }

      if (this.Field718.indexOf(new Long(var4)) == -1) {
         this.Field718.addElement(new Long(var4));
         Class216 var2;
         if ((var2 = this).Field718 != null && var2.Field718.size() > 0) {
            this.AddParameter("user_ids", Method432(",", this.Field718));
         } else {
            this.AddParameter("user_ids", null);
         }
      }

   }
/*
   private static Class Method4(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var1) {
         throw new NoClassDefFoundError(var1.getMessage());
      }
   }*/
}
