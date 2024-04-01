import java.util.Vector;

public final class Class473 extends MethodsWithParameters {
   private Vector Field1305;
   //private static Class Field1306;

   public Class473() {
      super(/*Field1306 == null ? (Field1306 = Method4("od")) : Field1306,*/ "groups.getById");
      this.Field1305 = new Vector();
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "can_message,ban_info,can_write_private_message,can_see_audio,followers,friend_status,common_count,blacklisted,blacklisted_by_me,fixed_post,ban_info,members_count,counters,photo_50,photo_100,text,views,reposts,likes,status,sex,online,online_app,online_mobile,last_seen,first_name_nom,first_name_gen,first_name_dat,first_name_acc,first_name_ins,first_name_abl,last_name_nom,last_name_gen,last_name_dat,last_name_acc,last_name_ins,last_name_abl,screen_name,image_status,emoji_status");
   }

   public Class473(long var1) {
      this();
      long var4 = var1;
      if (var1 < 0L) {
         var4 = -var1;
      }

      if (this.Field1305.indexOf(new Long(var4)) == -1) {
         this.Field1305.addElement(new Long(var4));
         Class473 var2;
         if ((var2 = this).Field1305 != null && var2.Field1305.size() > 0) {
            this.AddParameter("group_ids", Method432(",", this.Field1305));
         } else {
            this.AddParameter("group_ids", null);
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
