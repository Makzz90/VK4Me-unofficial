

final class Class123 extends Thread {
   private final String _login;
   private final String _password;
   private final String Field488;
   private final String Field489;
   private final String Field490;
   private final boolean Field491;
   private final boolean Field492;

   Class123(String var1, String var2, String var3, String var4, String var5, boolean var6, boolean var7) {
      this._login = var1;
      this._password = var2;
      this.Field488 = var3;
      this.Field489 = var4;
      this.Field490 = var5;
      this.Field491 = var6;
      this.Field492 = var7;
   }

   public final void run() {
      try {
         Class512 result;
         String var2;
         String var3;
         String var10;
         switch((result = Localized.Method401(this._login, this._password, this.Field488, this.Field489, this.Field490, this.Field491)).Method334()) {
         case -3:
            AuthData var14;
            if ((var2 = (var14 = result.GetAuthData()).error_description) == null) {
               var2 = var14.error_msg;
            }

            if ((var3 = var14.error) == null) {
               var3 = var14.error_code + "";
            }

            Class198.Instance.ShowError(var3 + ": " + var2);
            break;
         case -2:
         case -1:
         case 2:
            boolean var13 = this.Field492;
            var2 = this._password;
            var10 = this._login;
            Class36 var15;
            (var15 = new Class36()).Method287(Localized.GetString("title.2FA"));
            TextBox2 var16 = new TextBox2(Localized.GetString("element.2FACode"));
            var15.AddElement(var16);
            var15.AddElement(new Class129(Localized.GetString("action.confirm"), var10, var2, var13, var16));
            var15.AddElement(new Class130(Localized.GetString("action.cancel")));
            Class198.Instance.Method481(var15);
            break;
         case 0:
            Class198.Instance.Method483(Localized.GetString("auth.unknownError"), result.Method336() == null ? "No JSON response." : result.Method336().toString());
            break;
         case 1:
            String var10000 = result.GetAuthData().captcha_img;
            String var6 = this.Field490;
            boolean var5 = this.Field492;
            String var4 = this._password;
            var3 = this._login;
            var2 = result.GetAuthData().captcha_sid;
            var10 = var10000;
            Class36 var7;
            (var7 = new Class36()).Method287(Localized.GetString("title.CAPTCHA"));
            TextBox2 var8 = new TextBox2(Localized.GetString("element.CAPTCHACode"));
            ImageElement var10001 = new ImageElement(null, var10, false, 130, 50);
            boolean var11 = true;
            ImageElement var12 = var10001;
            var10001.Field1185 = 1;
            var10001 = var12;
            var11 = true;
            var12 = var10001;
            var10001.Field1184 = true;
            var7.AddElement(var12);
            var7.AddElement(var8);
            var7.AddElement(new Class126(Localized.GetString("action.confirm"), var8, var2, var3, var4, var5, var6));
            var7.AddElement(new Class128(Localized.GetString("action.cancel")));
            Class198.Instance.Method481(var7);
            break;
         case 3:
            Class198.Instance.ShowError(Localized.GetString("auth.invalidPair"));
            break;
         case 4:
            if (this.Field492) {
               //Settings.Instance.Token = Class190.Field603.Token;
               //Settings.Instance.SaveToken();//todo
            }
            //
            Settings.Instance.Token = result.GetAuthData().access_token;
            Settings.Instance.UserId = result.GetAuthData().user_id;
            Settings.Instance.Save();
            //
            LoginForm.Method262();
         }
      } catch (Exception var9) {
         Logger.PrintErrorWithMessage(var9);
         Class198.Instance.ShowError(Class291.Method438(Class291.Method438(Class291.Method438(Class291.Method438(var9.toString(), this._login, "*censored*"), this._password, "*censored*"), Class278.Method377(this._login), "*censored*"), Class278.Method377(this._password), "*censored*"));
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
