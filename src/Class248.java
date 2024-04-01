import javax.microedition.lcdui.Display;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class248 {
   static int arrayIndex = -1;
   static int charIndex = -1;
   static int _textModicator = 0;
   static int Field788 = 0;
   static char[][] engDict = new char[][]{{' ', '*', '#', '+', '0'}, {'.', ',', '?', '!', '@', '\'', '-', '_', '(', ')', ':', ';', '/', '1'}, {'a', 'b', 'c', '2'}, {'d', 'e', 'f', '3'}, {'g', 'h', 'i', '4'}, {'j', 'k', 'l', '5'}, {'m', 'n', 'o', '6'}, {'p', 'q', 'r', 's', '7'}, {'t', 'u', 'v', '8'}, {'w', 'x', 'y', 'z', '9'}, {' ', '*', '#'}};
   static char[][] rusDict = new char[][]{{' ', '*', '#', '+', '0'}, {'.', ',', '?', '!', '@', '\'', '-', '_', '(', ')', ':', ';', '/', '1'}, {'à', 'á', 'â', 'ã', '2'}, {'ä', 'å', '¸', 'æ', 'ç', '3'}, {'è', 'é', 'ê', 'ë', '4'}, {'ì', 'í', 'î', 'ï', '5'}, {'ð', 'ñ', 'ò', 'ó', '6'}, {'ô', 'õ', 'ö', '÷', '7'}, {'ø', 'ù', 'ú', 'û', '8'}, {'ü', 'ý', 'þ', 'ÿ', '9'}};

   public static void Method230(int var0, TextBox2 var1) {
      Logger.PrintToConsole("[KEY]: " + var0);
      if (Method232(var0)) {
         if (var1 != null) {
            char var2 = (char)var0;
            if (var0 == 1000010) {
               var1.Method288(var1.Field477 != null && var1.Field477.Field876 != 0 ? var1.Field477.Method383() : null);
            } else if (!Character.isDigit(var2) && var2 != '*' && var2 != '#') {
               if (var0 == 32) {
                  var1.Method139((var1.Field477 == null ? "" : var1.Field477.toString()) + ' ');
               } else if (var0 == 1000011) {
                  var1.Method139((var1.Field477 == null ? "" : var1.Field477.toString()) + '\n');
               } else if (var0 == 8) {
                  var1.CommandExecuted();
                  Method233();
               } else {
                  if (Settings.Instance.ReplaceEmailAtYo && var2 == '@') {
                     var2 = 1105;
                  }

                  String var3 = var1.Field477 == null ? "" : var1.Field477.toString();
                  if (!(var1 instanceof PasswordBox) && Settings.Instance.UpperFirstChar && (var1.Field477 == null || var1.Field477.Field876 == 0 || var3.trim().endsWith("."))) {
                     if (Character.isUpperCase(var2)) {
                        var2 = Character.toLowerCase(var2);
                     } else {
                        var2 = Character.toUpperCase(var2);
                     }
                  }

                  var1.Method139(var3 + var2);
               }
            } else {
               Method234(var1, var2, false);
            }

            if (var1 instanceof PasswordBox) {
               ((PasswordBox)var1).Field968 = 3;
               ((PasswordBox)var1).Field967 = null;
            }

            Method233();
         }
      }
   }

   public static void Method231(int var0, TextBox2 var1) {
      if (Method232(var0)) {
         if (var1 != null) {
            char var2;
            if (!Character.isDigit(var2 = (char)var0) && var2 != '*' && var2 != '#') {
               if (var0 != 1000011) {
                  Method230(var0, var1);
               }

            } else {
               Method234(var1, var2, true);
               Method233();
            }
         }
      }
   }

   public static boolean Method232(int var0) {
      switch(var0) {
      case 8:
      case 32:
      case 1000010:
      case 1000011:
         return true;
      default:
         return var0 >= 32 || Character.isDigit((char)var0) || Character.isLowerCase((char)var0) || Character.isUpperCase((char)var0);
      }
   }

   public static void Method233() {
      if (Settings.Instance.FeedKeyVibro) {
         Display.getDisplay(Midlet.Instance).vibrate(100);
      }

   }

   private static void Method234(TextBox2 var0, int var1, boolean var2) {
      if (var0 != null) {
         if (!Settings.Instance.UseKeypadInput) {
            var0.Method139((var0.Field477 == null ? "" : var0.Field477.toString()) + (char)var1);
         } else {
            if (var1 == 35) {
               var1 = 10;
            } else if (var1 == 42) {
               var1 = 11;
            } else {
               var1 -= 48;
            }

            if (var1 == 11) {
               _textModicator = (_textModicator + 1) % 4;
               arrayIndex = 11;
               charIndex = -1;
               Field788 = 6;
            } else if (var1 == 10) {
               arrayIndex = 10;
               charIndex = -1;
               Field788 = 6;
               var0.Method288(var0.Field477 != null && var0.Field477.Field876 != 0 ? var0.Field477.Method383() : null);
            } else {
               char ch;
               if (arrayIndex == var1 && charIndex != -1) {
                  Field788 = 6;
                  charIndex = (charIndex + 1) % (_textModicator / 2 == 0 ? engDict[arrayIndex].length : rusDict[arrayIndex].length);
                  if (var2) {
                     charIndex = (_textModicator / 2 == 0 ? engDict[arrayIndex].length : rusDict[arrayIndex].length) - 1;
                  }

                  ch = _textModicator / 2 == 0 ? engDict[arrayIndex][charIndex] : rusDict[arrayIndex][charIndex];
                  if (_textModicator % 2 == 1) {
                     ch = Character.toUpperCase(ch);
                  }

                  var0.Method288(var0.Field477 != null && var0.Field477.Field876 != 0 ? var0.Field477.Method383() : null);
                  var0.Method139((var0.Field477 == null ? "" : var0.Field477.toString()) + ch);
               } else {
                  arrayIndex = var1;
                  charIndex = 0;
                  if (var2) {
                     charIndex = (_textModicator / 2 == 0 ? engDict[arrayIndex].length : rusDict[arrayIndex].length) - 1;
                  }

                  Field788 = 6;
                  ch = _textModicator / 2 == 0 ? engDict[arrayIndex][charIndex] : rusDict[arrayIndex][charIndex];
                  if (_textModicator % 2 == 1) {
                     ch = Character.toUpperCase(ch);
                  }

                  var0.Method139((var0.Field477 == null ? "" : var0.Field477.toString()) + ch);
               }
            }
         }
      }
   }
}
