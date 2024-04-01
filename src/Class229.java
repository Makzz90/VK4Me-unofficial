import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class229 extends SomeStringUtils {
   public String Token;
   public boolean Field733;
   public long UserId;

   public Class229(String token) throws Exception {
      this.Token = token;

      try {
         Class185 var7;
         if ((var7 = (Class185)(new Class216()).Method423(/*this,*/ false)) != null && var7.Method213() && var7.Method351().id != 0L) {
            long var4 = var7.Method351().id;
            this.UserId = var4;
         } else {
            throw new Exception("No user_id.");
         }
      } catch (Exception var6) {
         throw var6;
      }
   }

   public final Class229 RefreshToken()  {
      String var10000 = Class278.Field878 == null ? null : Class278.Field878.Method137();
      String var1 = var10000;
      Class238 var3;
      if (!IsStringEmpty(var10000) && (var3 = (Class238)(new Class241(var1)).Method423(/*this,*/ false)) != null && !Class238.IsStringEmpty(var3.Field749)) {
         String var2 = var3.Field749;
         this.Token = var2;
         //boolean var4 = true;
         this.Field733 = true;
         //Class190.Field608.SaveTokenToStore();
         //Settings.Instance.SaveToken();
         /*
          * public final void SaveTokenToStore() {
      if (this.SettingsInstanse != null && Class190.Field603 != null) {
         this.SettingsInstanse.Token = Class190.Field603.Token;
         this.SettingsInstanse.SaveToken();
      }

   }
          * */
          
      }

      return this;
   }

   public final boolean Method36() {
      if (IsStringEmpty(this.Token)) {
         return false;
      } else {
         try {
            return ((Class159)(new Class56()).DoDispatch()).IsSucsess();
         } catch (Exception var2) {
            return false;
         }
      }
   }
}
