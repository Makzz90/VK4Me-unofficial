

final class SettingsInterfaceForm extends Page {
   private SettingsInterfaceForm(SettingsPage pageSettings, byte var2) {
      super(Localized.GetString("title.interfaceSettings"));
//      this.AddElement((new Class151(this, Localized.GetString("element.theming"), (byte)2, var1)).Method99("new/palette.rle"));
      Button btnShowHeader = (new Class153(this, Localized.GetString("settings.showHeader"), (byte)1, pageSettings)).Method115(Settings.Instance.GuiShowHeader || Settings.Instance.GuiFullscreen || Settings.Instance.GuiTouchHud);
      Button btnShowFooter = (new Class147(Localized.GetString("settings.showFooter"), (byte)1)).Method115(Settings.Instance.GuiShowFooter || Settings.Instance.GuiFullscreen || Settings.Instance.GuiTouchHud);
      TextBlock var10001 = new TextBlock(Localized.GetString("settings.screenSettings"));
      //boolean var13 = true;
      TextBlock var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement((new Class149(this, Localized.GetString("settings.reverseSofts"), (byte)1, pageSettings)).SetSubtitle(Localized.GetString("element.onlyForNonTouchUI")).Method115(Settings.Instance.GuiReverseSofts));
      this.AddElement(   (new Class142(this, Localized.GetString("settings.fullscreenMode"),   btnShowFooter, btnShowHeader)).Method115(Settings.Instance.GuiFullscreen));
      this.AddElement(    (new Class144(this, Localized.GetString("settings.longTouchScreenHudMode"),   btnShowFooter, btnShowHeader)).Method115(Settings.Instance.GuiTouchHud));
      this.AddElement((new ButtonOnSettings( Localized.GetString("settings.slimHeader"), (short)27, (byte)1)).SetSubtitle(Localized.GetString("element.touchOnly")).Method115(Settings.Instance.GuiSlimHeader));
      this.AddElement((new Class141(this, Localized.GetString("settings.useDrawer"), (byte)1, pageSettings)).SetSubtitle(Localized.GetString("element.touchOnly")).Method115(Settings.Instance.GuiUseDrawer));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.shiftTitleRight"), (short)39,(byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.oldMessagesSoft"), (short)35, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.oldCommentsSoft"), (short)36, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.showMsgFieldByOpen"), (short)37, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.showCmtFieldByOpen"), (short)38, (byte)1));
      this.AddElement(btnShowHeader);
      this.AddElement(btnShowFooter);
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.graphics"));
      //var13 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.animations"), (short)5, (byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.gradients"), (short)21,(byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.smoothScroll"), (short)6,(byte)1));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.renderDimm"), (short)4, (byte)1));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.general"));
      //var13 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      VKUser user;
      (user = new VKUser()).first_name = Localized.GetString("element.testItemFName");
      user.last_name = Localized.GetString("element.testItemLName");
      btnShowFooter = (new Button(Settings.Instance.GuiReverseNames ? user.Method527("nom") : user.Method526("nom"), (byte)3)).Method109(true).SetSubtitle(Localized.GetString("element.testItemDesc")).SetPngIcon("new/crosh.png").Method97(1).Method116((short)13).Method95(1627145577);
      this.AddElement(btnShowFooter);
      VKMessage var17;
      (var17 = new VKMessage()).text = Localized.GetString("element.testItemDesc");
      Class343 var18;
      (var18 = new Class343(this, (ConversationHistoryPage)null, var17, pageSettings)).Field1242 = false;
      VKMessage var5;
      (var5 = new VKMessage()).out = true;
      var5.text = Localized.GetString("element.testMessageText");
      Class342 var19;
      (var19 = new Class342(this, (ConversationHistoryPage)null, var5, pageSettings)).Field1242 = false;
      this.AddElement(var18);
      this.AddElement(var19);
      String var23 = Settings.Instance.GuiAvatarCircleType + "%";
      
      this.AddElement(var4 = (TextBlock)(new TextBlock(Localized.Method398("settings.cornerRadius", var23, null))).Method157(true));
      Class309 var25 = new Class309(this, Settings.Instance.GuiAvatarCircleType / 5, pageSettings, var4);
      long var24 = 20L;
      Class309 var21 = var25;
      var25.Field1074 = var24;
      this.AddElement(var21);
      var23 = Settings.Instance.GuiPhotosCircleType + "%";
      
      this.AddElement(var4 = (TextBlock)(new TextBlock(Localized.Method398("settings.avatarsCircling", var23, null))).Method157(true));
      Class304 var26 = new Class304(this, Settings.Instance.GuiPhotosCircleType / 5, pageSettings, var4);
      var24 = 20L;
      Class304 var22 = var26;
      var26.Field1074 = var24;
      this.AddElement(var22);
      this.AddElement((new Class306(this, Localized.GetString("settings.reverseProfilesNames"), (byte)1, pageSettings, btnShowFooter, user)).Method115(Settings.Instance.GuiReverseNames));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.dialogsInterface"));
      //var13 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.hideFieldAfterSending"), (short)43, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.drawMessagesBorder"), (short)2, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.showMessagesAvatars"), (short)11, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.drawMessagesClouds"), (short)7, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.messsageDiffSides"), (short)17, (byte)1));
      this.AddElement(new OffsetElementUI());
      var10001 = new TextBlock(Localized.GetString("settings.debugging"));
      //var13 = true;
      var4 = var10001;
      var10001.IsBold = true;
      this.AddElement(var4.Method157(true));
      this.AddElement(new ButtonOnSettings(Localized.GetString("settings.drawFPS"), (short)8, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.drawEmojiRed"), (short)9, (byte)1));
      this.AddElement(new ButtonOnSettings( Localized.GetString("settings.drawImagesFrames"), (short)16, (byte)1));
      Class198.Instance.NavigateForward(this);
   }

   SettingsInterfaceForm(SettingsPage var1) {
      this(var1, (byte)0);
   }
}
