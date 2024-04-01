import java.util.Vector;


public final class LoginForm {
   public static Page HomePage;

   public static void Method251(boolean var0, String var1, String var2, String login, String password, boolean var5, String var6) {
      Settings.Instance.ApplyUrls();
      Class198.Instance.SetInLoadingState(true);
      
      (new Class123(login, password, var1, var2, var6, true, var5)).start();
   }

   public static void Method252(Page page, Vector var1, int var2)
   {
/*
      if (ConversationsPage.Instance == null)
      {
         ConversationsPage.Instance = new ConversationsPage();
      }
      else
      {
         ConversationsPage.Instance.Method283(var1, var2);
         Class198.Instance.NavigateForward(ConversationsPage.Instance.Method361(page));
      }
*/
	   Class198.Instance.NavigateForward(new ConversationsPage());
   }

   public static void Method253(Page paramClass261, long paramLong)  {
	    String str2 = (Class31.GetUser(paramLong) != null) ? Class31.GetUser(paramLong).GetTitle("gen") : Localized.GetString("general.unknownUser");
	    //Class229 class229;
	    //String str1;
	    Class198.Instance.NavigateForward((new Class395((Settings.Instance.UserId == paramLong) ? Localized.GetString("title.myMusic") : Localized.Method398( "title.usersMusic", str2, null), true, paramLong)).Method361(paramClass261));
	  }

   public static void Method254(Page page, VKGroupOrUser var1) {
      if (var1 != null) {
        
			Class198.Instance.NavigateForward((new Class467(var1.GetId())).Method361(page));
		
      }
   }

   public static void Method255(long var0, int var2, Page var3) {
      Class446 var4 = (Class446)(new Class410(Localized.GetString("title.photos"), true, var0, var2)).Method361(var3);
      Class198.Instance.NavigateForward(var4);
   }

   public static void Method256(long var0, Page var2) throws Exception {
      Class446 var3 = (Class446)(new PhotoAlbumsPage(Localized.GetString("title.albums"), true, var0)).Method361(var2);
      Class198.Instance.NavigateForward(var3);
   }

   public static void Method257(Page var0, boolean var1) throws Exception {
      Class446 var2 = (Class446)(new Class407(Localized.GetString("title.friendRequests"), true, var1)).Method361(var0);
      Class198.Instance.NavigateForward(var2);
   }

   public static void Method258(Page paramClass261, long paramLong) throws Exception {
	    String str2 = (Class31.GetUser(paramLong) != null) ? Class31.GetUser(paramLong).GetTitle("gen") : Localized.GetString("general.unknownUser");
	    //String str1;
	    //Class229 class229;
	    ((Class446)(paramClass261 = (new FiendsPage((Settings.Instance.UserId == paramLong) ? Localized.GetString("title.myFriends") : Localized.Method398( "title.usersFriends", str2, null), true, paramLong)).Method361(paramClass261))).Field825.AddElement((new Class405(Localized.GetString("action.showRequestsIn"), (Class446)paramClass261)).SetRleIcon("new/reply.rle"));
	    ((Class446)paramClass261).Field825.AddElement((new Class404(Localized.GetString("action.showRequestsOut"), (Class446)paramClass261)).SetRleIcon("new/account-arrow-right.rle"));
	    Class198.Instance.NavigateForward(paramClass261);
	  }

   public static void Method259(Page paramClass261, long paramLong) throws Exception {
	    String str2 = (Class31.GetUser(paramLong) != null) ? Class31.GetUser(paramLong).GetTitle("gen") : Localized.GetString("general.unknownUser");
	    //String str1;
	    //Class229 class229;
	    Class198.Instance.NavigateForward((new GroupsPage((Settings.Instance.UserId == paramLong) ? Localized.GetString("title.myGroups") : Localized.Method398( "title.usersGroups", str2, null), true, paramLong)).Method361(paramClass261));
	  }
	  

   public static Button GetHeaderElement(VKGroupOrUser owner, boolean sex, boolean var2, boolean var3, boolean var4, Page var5) {
      Button btn = (new Class347(sex ? owner.GetTitle("nom") : owner.GetName("nom"), var5, owner)).Method109(var2);
      String subtitle;
      if (!var3) {
         subtitle = null;
      } else {
         String var8;
         if (owner.is_group) {
            if (owner.IsStatusExists() && !var4) {
               subtitle = owner.GetGroup().status;
            } else {
               int var6;
               
               if ((var6 = owner.GetGroup().members_count) % 100 / 10 == 1) {
                  var8 = var6 + "";
                  
                  subtitle = Localized.Method398("element.followersCount", var8, null);
               } else {
                  switch(var6 % 10) {
                  case 1:
                     var8 = var6 + "";
                     
                     subtitle = Localized.Method398("element.followersCountOne", var8, null);
                     break;
                  case 2:
                  case 3:
                  case 4:
                     var8 = var6 + "";
                     
                     subtitle = Localized.Method398("element.followersCountSome", var8, null);
                     break;
                  default:
                     var8 = var6 + "";
                     
                     subtitle = Localized.Method398("element.followersCount", var8, null);
                  }
               }
            }
         } else if (owner.IsStatusExists() && !var4) {
            subtitle = owner.GetUser().status;
         } else if (owner.GetUser().online == 1) {
            subtitle = Localized.GetString("element.online");
         } else {
            boolean var10 = owner.GetUser().sex != 1;
            int lastSeen = owner.GetUser().last_seen;
            sex = var10;
            subtitle = "element.lastSeen" + (sex ? "Male" : "Female");
            var8 = Class467.GetDateForUI(lastSeen);
            subtitle = Localized.Method398(subtitle, var8, null);
         }
      }

      return btn.SetSubtitle(subtitle).SetIconByOwner(owner).Method97(Method261(owner));
   }

   public static int Method261(VKGroupOrUser var0) {
      if (var0 != null && !var0.is_group) {
         VKUser var1;
         if ((var1 = (VKUser)var0).online == 1) {
            if (var1.online_app != 0) {
               switch(var1.online_app) {
               case 2274003:
               case 2685278:
                  return 3;
               case 3140623:
                  return 4;
               case 3697615:
                  return 5;
               case 6146827:
                  return 2;
               default:
                  return 1;
               }
            } else {
               return var1.online_mobile == 1 ? 2 : 1;
            }
         } else {
            return 0;
         }
      } else {
         return 0;
      }
   }

   public static void Method262()  {
      if (!Settings.Instance.IsAutorized())
      {
         ShowLoginForm();
      } else {
         //Class243.Field767 = new Class243();//TODO for what?
         LongPollInstanse.Start();
         Method265();
      }
   }

   public static void ShowLoginForm() {
      LongPollInstanse.Stop(true);
      //Class190.Field603 = null;
      Settings.Instance.Token = null;
      //Settings.Instance.SaveToken();//TODO save settings
//      ConversationsPage.Instance = null;
      Settings.Instance.Method129();
      HomePage = null;
      Page var0 = new Page(Localized.GetString("title.auth"));
      int size = Math.min(Class198.Instance.getWidth() / 3, Class198.Instance.getHeight() / 3);
      ImageElement var5 = new ImageElement(null, "new/phmini.png", true, size, size);
      //boolean var4 = true;
      //ImageElement var5 = var10001;
      var5.Field1185 = 1;
      //var10001 = var5;
      //var4 = true;
      //var5 = var10001;
      var5.Field1184 = true;
//      var0.AddElement(var5);
      TextBox2 textBox = new TextBox2(Localized.GetString("element.login"));
      PasswordBox passwordBox = new PasswordBox(Localized.GetString("element.password"));
      Button checkBox = new Button(Localized.GetString("element.rememberPassword"), (byte)1);
      var0.AddElement(textBox);
      var0.AddElement(passwordBox);
//      var0.AddElement(checkBox);
      var0.AddElement((new Class132(Localized.GetString("action.logIn"), textBox, passwordBox, checkBox)).Method109(true).SetRleIcon("new/exit-to-app.rle"));
      var0.AddElement((new Class134(Localized.GetString("element.settings"), var0)).Method109(true).SetRleIcon("new/cog.rle"));
      var0.AddElement((new Class136(Localized.GetString("action.quit"))).Method109(true).SetRleIcon("new/close.rle"));
      Class198.Instance.NavigateForward(var0);
      Class198.Instance.Method499();
   }

   public static void Method264(Page var0, VKNewsfeedPost var1, VKWallReply var2) {
     
		Class198.Instance.NavigateForward((new Class240(var1, null)).Method361(var0));
	
   }

   public static void Method265() {
      Class198 var10000 = Class198.Instance;
      Page page;
      if (HomePage != null) {
         page = HomePage;
      } else {
    	 HomePage = new Page(Localized.GetString("title.home"));
         HomePage.AddElement((new Class135("", (byte)2)).SetSubtitle("").Method109(true));
         HomePage.AddElement((new Class379(Localized.GetString("element.newsfeed"), (byte)0)).SetRleIcon("new/newspaper-variant.rle"));
         HomePage.AddElement((new Class388(Localized.GetString("element.messages"), (byte)3)).SetRleIcon("new/email.rle").Method96(true));
         HomePage.AddElement((new Class387(Localized.GetString("element.myFriends"), (byte)3)).SetRleIcon("new/account.rle").Method96(true));
         HomePage.AddElement((new Class390(Localized.GetString("element.myGroups"), (byte)3)).SetRleIcon("new/account-supervisor.rle").Method96(true));
         HomePage.AddElement((new Class389(Localized.GetString("title.albums"), (byte)3)).SetRleIcon("new/image.rle").Method96(true));
         HomePage.AddElement((new Class383(Localized.GetString("element.myMusic"), (byte)3)).SetRleIcon("new/music-note.rle").Method96(true));
         HomePage.AddElement((new Class382(Localized.GetString("title.docs"), (byte)3)).SetRleIcon("new/file.rle").Method96(true));
         HomePage.AddElement((new Class386(Localized.GetString("element.settings"), (byte)3)).SetRleIcon("new/cog.rle").Method96(true));
         HomePage.AddElement((new Class385(Localized.GetString("action.quit"), (byte)0)).SetRleIcon("new/close.rle").Method109(true));
         int[] var0 = Class291.Method435(Class291.Method434());
         if (var0[3] == 9 && var0[4] == 1)
         {
            HomePage.AddElement((new Class391(Localized.GetString("event.happyBirthday"), (byte)2)).SetSubtitle(Localized.GetString("event.happyBirthdayDevCongratulation")).SetRleIcon("new/gift.rle"));
         }

         (new Class396()).start();
         page = HomePage;
      }

      var10000.NavigateForward(page);
   }
   
   //похоже эта функция отвечает за обновление счетчиков в меню
   static void Method269(Page page) 
   {
      //Class31.Method514(0L);
      VKUser user = (VKUser)Class31.GetUser(0L);
      if(user==null)
    	  return;
      
      ((Button)page.ElementAt(0)).SetLable(user.GetName("nom")).SetSubtitle(user.IsStatusExists() ? user.status : Localized.GetString("element.yourProfile")).SetIconByOwner(user);
/*
      if (ConversationsPage.Instance != null)
      {
         ConversationsPage.Instance.Method23();
         ((Button)page.ElementAt(2)).SetContent(Class467.Method12(Math.min(9999, ConversationsPage.Instance.peerIds.size())));
      }
*/

      ((Button)page.ElementAt(3)).SetContent((user.online_friends > 0 ? Class467.Method12(user.online_friends) + " / " : "") + Class467.Method12(user.friends));
      ((Button)page.ElementAt(4)).SetContent(Class467.Method12(user.groups));
      ((Button)page.ElementAt(5)).SetContent(Class467.Method12(user.albums));
      ((Button)page.ElementAt(6)).SetContent(Class467.Method12(user.audios));
      //((Button)page.ElementAt(8)).SetContent(SettingsPage.isUpdateAvaliable ? Localized.GetString("event.updateAvaliable") : null);
      if (user.bdate != null) {
         int[] var2 = Class291.Method435(Class291.Method434());
         int[] var3 = Class291.Method442(user.bdate);
         if (var3[3] == var2[3] && var3[4] == var2[4]) {
            page.AddElement((new Button(Localized.GetString("event.happyBirthday"), (byte)0)).SetSubtitle(Localized.GetString("event.happyBirthdayCongratulation")).SetRleIcon("new/gift.rle"));
         }
      }

      Class198.Instance.Repaint();
   }
   
   public static void AuthError() {
      LongPollInstanse.Stop(true);
      //Class190.Field603 = null;
//      ConversationsPage.Instance = null;
      Page page = new Page(Localized.GetString("title.authError"));
      page.AddElement(new TextBlock(Localized.GetString("element.authError")));
      page.AddElement((new Class349(Localized.GetString("action.tryAgain"))).SetRleIcon("new/refresh.rle").Method109(true));
      page.AddElement((new Class348(Localized.GetString("action.resetSession"))).SetRleIcon("new/exit-to-app.rle").Method109(true));
      page.AddElement((new Class351(Localized.GetString("element.settings"), page)).SetRleIcon("new/cog.rle").Method109(true));
      page.AddElement((new Class350(Localized.GetString("action.close"))).SetRleIcon("new/close.rle").Method109(true));
      Class198.Instance.NavigateForward(page);
   }

   public static void UpdateCounters()
   {
	   /*
      if (ConversationsPage.Instance != null) {
         ConversationsPage.Instance.Method23();
         if (HomePage != null && HomePage.Count() >= 3) {
            ((Button)HomePage.ElementAt(2)).SetContent(Class467.Method12(Math.min(9999, ConversationsPage.Instance.peerIds.size())));
         }

      }*/
   }

   static void Method268(Page var0, boolean var1) {
      (new SettingsPage(var1)).Method361(var0);
   }

   static Button Method270(VKAudio audio, int var1)
   {
	   VKAttachment a = new VKAttachment();
	   a.type="audio";
	   a.audio=audio;
      return new AttachmentItemUC(a);
   }
}
