

public final class SettingsBehaviorForm extends Page {
   Button _btnNetworkMode;
   Button _btnDownloadMode;

   public final void Method379(Class288 var1, boolean var2) {
      Class36 var3;
      Class36 var10000 = var3 = new Class36();
      TextBlock var10001 = new TextBlock(Localized.GetString("element.setCustomValue"));
      //boolean var4 = true;
      TextBlock var5 = var10001;
      var10001.IsBold = true;
      var10000.AddElement(var5.Method157(true));
      TextBox2 var6 = new TextBox2(Localized.GetString("element.timeInSecs"));
      var3.AddElement(var6);
      var3.AddElement(new Class511(this, Localized.GetString("action.ok"), var6, var1, var2));
      var3.AddElement(new Class508(this, Localized.GetString("action.cancel")));
      Class198.Instance.Method481(var3);
      var3.Field814 = 1;
   }

   public SettingsBehaviorForm(SettingsPage var1, boolean showToken) {
      super(Localized.GetString("title.behaviorSettings"));
      TextBlock var10001 = new TextBlock(Localized.GetString("settings.general"));
      //boolean var9 = true;
      TextBlock var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.increaseTextLimit"), (short)34, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.useKeypadInput"), (short)40, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.pqSofts"), (short)26, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.upperFirstChar"), (short)45, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.replaceEmailAtYo"), (short)46, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.showReplies"), (short)29, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.translitFiles"), (short)20, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.doNotLoadImages"), (short)25, (byte)1));
      this.AddElement(this._btnDownloadMode = new Class63(this, Localized.GetString("settings.downloadMode"), (byte)2, var1));
      Button var10000 = this._btnDownloadMode;
      String var16 = Localized.GetString(Settings.Instance.DownloadMode == 1 ? "settings.downloadFile" : (Settings.Instance.DownloadMode == 2 ? "settings.openBrowser" : "settings.askEverytime"));
      
      var10000.SetSubtitle(Localized.Method398("settings.currentMode", var16, null));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.messaging"));
      //var9 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.showMessagesFromEnd"),(short)24, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.DNR"), (short)31, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.DNT"), (short)32, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.typingInDialogs"), (short)44, (byte)1));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.networkSettings"));
      //var9 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(this._btnNetworkMode = new Class79(this, Localized.GetString("settings.networkMode"), (byte)2, var1));
      var10000 = this._btnNetworkMode;
      var16 = Localized.GetString(Settings.Instance.NetworkMode == 1 ? "settings.https" : (Settings.Instance.NetworkMode == 2 ? "settings.custom" : (Settings.Instance.NetworkMode == 3 ? "settings.openvkHttp" : (Settings.Instance.NetworkMode == 4 ? "settings.openvkHttps" : "settings.http"))));
      
      var10000.SetSubtitle(Localized.Method398("settings.currentMode", var16, null));
      this.AddElement((new Class83(this, Localized.GetString("settings.useFlushUpload"), (byte)1, var1)).SetSubtitle(Localized.GetString("settings.partWarning")).Method115(Settings.Instance.UseFlushUpload));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.feedback"));
      //var9 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.keyboardVibration"), (short)13, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.notificationVibration"), (short)14, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.notificationSound"), (short)15, (byte)1));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.longpoll"));
      //var9 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      var16 = Settings.Instance.LpSpeed + " " + Localized.GetString("general.secs");
      
      TextBlock var11 = (TextBlock)(new TextBlock(Localized.Method398("settings.longpollSpeed", var16, null))).Method157(true);
      this.AddElement(var11);
      Class25 var18 = new Class25(this, Settings.Instance.LpSpeed - 1, var1, var11);
      long var17 = 19L;
      Class25 var13 = var18;
      var18.Field1074 = var17;
      Class288 var14 = (Class288)var13;
      this.AddElement(var14);
      this.AddElement(new Class20(this, Localized.GetString("element.setCustomValue"), var1, var11, var14));
      var16 = Settings.Instance.LpsSpeed + " " + Localized.GetString("general.secs");
      
      var11 = (TextBlock)(new TextBlock(Localized.Method398("settings.longpollSleepSpeed", var16, null))).Method157(true);
      this.AddElement(var11);
      Class22 var19 = new Class22(this, Settings.Instance.LpsSpeed - 10, var1, var11);
      var17 = 50L;
      Class22 var15 = var19;
      var19.Field1074 = var17;
      var14 = (Class288)var15;
      this.AddElement(var14);
      this.AddElement(new Class15(this, Localized.GetString("element.setCustomValue"), var1, var11, var14));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.sleepWithTimeout"), (short)42, (byte)1));
      var16 = Settings.Instance.SleepTimeout + "";
      
      var11 = (TextBlock)(new TextBlock(Localized.Method398("settings.sleepTimeout", var16, null))).Method157(true);
      this.AddElement(var11);
      var16 = Settings.Instance.SleepTimeout + "";
      
      this.AddElement(new Class10(this, Localized.Method398("element.setCustomValue", var16, null), var1, var11));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.debugging"));
      //var9 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.setOffline"), (short)47, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.loggerEnabled"), (short)33, (byte)1));
      this.AddElement(new Class8(this, Localized.GetString("settings.flushLog"), var1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.drawLPState"), (short)41, (byte)1));
      //if (showToken) {
      //   this.AddElement(new Class34(this, Localized.GetString("settings.showToken"), var1));
      //}

      Class198.Instance.NavigateForward(this);
   }
}
