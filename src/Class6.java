

public final class Class6 {
   //private static ApplicationTheme[] _theme;
   public static RecordStoreHelper Field13 = new RecordStoreHelper(3);
   public static Colors ColorsInstanse;
   private static int[] Field15;
   private static int[] Field16;

   private static void Method337(Colors colors) {
      if (ColorsInstanse == null) {
         ColorsInstanse = colors;
      } else {
         Field13.Field378 = 255;
         Field13.Field377 = 0;
         if (Settings.Instance.GuiAnimations) {
            Field13.SetAnimationDuration(2000);
         } else {
            Field13.Field379 = 255;
         }

         Field15 = ColorsInstanse.Method148();
         Field16 = colors.Method148();
         Method338();
      }
   }

   public static void Method338() {
      if (Field13.Method156()) {
         ColorsInstanse.Method147(Field16);
         Field15 = null;
         Field16 = null;
         Field13.Method155();
      } else {
         int[] var0 = new int[100];
         int var1 = Field13.Field379;

         for(int i = 0; i < var0.length; i++)
         {
            var0[i] = Class252.Method332(Field15[i], Field16[i], var1);
         }

         ColorsInstanse.Method147(var0);
      }

      Class198.Instance.Repaint();
   }
   /*
   private static boolean Method339(String fileName) {
      try {
         Runtime.getRuntime().getClass().getResourceAsStream("/themes/" + fileName + ".theme").close();
         return true;
      } catch (Exception var1) {
         return false;
      }
   }

   public static ApplicationTheme[] Method340() {
      if (_theme != null) {
         return _theme;
      } else {
         Vector var0 = new Vector();

         try {
            Vector files = Class291.Separete(new String(Class278.Method378(Runtime.getRuntime().getClass().getResourceAsStream("/themes/list.themes")), Class514.Field1364), "\n");

            for(int i = 0; i < files.size(); i++)
            {
               String file= (String)files.elementAt(i);
               
               if (file != null && !file.startsWith("#")) {
                  Vector var6 = Class291.Separete(file, ";");
                  ApplicationTheme var4 = new ApplicationTheme();
                  if (var6.size() > 1) {
                     var4.Version = ((String)var6.elementAt(1)).trim();
                     var4.Name = ((String)var6.elementAt(0)).trim();
                  }

                  if (!Class291.IsNullOrEmpty(var4.Name) && Method339(var4.Name)) {
                     var0.addElement(var4);
                  }
               }
            }

            _theme = new ApplicationTheme[var0.size()];
            var0.copyInto(_theme);
         } catch (Exception var5) {
            _theme = new ApplicationTheme[0];
            System.gc();
         }

         return _theme;
      }
   }

   public static String Method341() {
      return "Classic Dark";
   }
*/
   public static void Method342(String fileName, boolean var1)
   {
	   /*
      Colors colors;
      try {
         if (!var1) {
            colors = new Colors(Class278.Method378(Runtime.getRuntime().getClass().getResourceAsStream("/themes/" + fileName + ".theme")));
         } else {
            colors = new Colors(RecordStoreHelper.GetRecord(fileName + "_theme"));
         }
      } catch (Throwable var2) {
         Logger.PrintErrorWithMessage(var2);
         System.gc();
         colors = new Colors();
      }
*/
	   Colors colors = new Colors();
      Method337(colors);
   }
}
