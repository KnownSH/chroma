package net.knsh.chroma.util;

public class DrunkifyMessage extends MessageModifier {
    public DrunkifyMessage(WordModifier word) {
        super(word);
    }

    public static void register() {
        new DrunkifyMessage(new WordModifier("s", "sh", 90, null, null, 30));
        new DrunkifyMessage(new WordModifier("s", "sh", 90, null, null, 30));
        new DrunkifyMessage(new WordModifier("ch", "sh", 90, "u,s,o,a", false, 10));
        new DrunkifyMessage(new WordModifier("h", "hh", 60, "sch,h,t", false, 20));
        new DrunkifyMessage(new WordModifier("th", "thl", 40, null, null, 40));
        new DrunkifyMessage(new WordModifier("sch", "shk", 60, null, null, 40));
        new DrunkifyMessage(new WordModifier("u", "uuh", 20, null, null, 0));
        new DrunkifyMessage(new WordModifier("y", "yy", 60, null, null, 15));
        new DrunkifyMessage(new WordModifier("e", "ee", 40, null, null, 15));
        new DrunkifyMessage(new WordModifier("you", "u", 40, null, null, 0));
        new DrunkifyMessage(new WordModifier("u", "uo", 60, "u", false, 0));
        new DrunkifyMessage(new WordModifier("that", "taht", 20, null, null, 40));
        new DrunkifyMessage(new WordModifier("p", "b", 30, null, null, 0));
        new DrunkifyMessage(new WordModifier("p", "b", 70, null, null, 60));
        new DrunkifyMessage(new WordModifier("up", "ubb", 80, null, null, 25));
        new DrunkifyMessage(new WordModifier("o", "oh", 20, null, null, 0));
        new DrunkifyMessage(new WordModifier("ei", "i", 30, null, null, 15));
        new DrunkifyMessage(new WordModifier("b", "bb", 80, null, null, 40));
        new DrunkifyMessage(new WordModifier("!!!", "!!!111!!!eleven!1!", 20, "!", false, 70));
        new DrunkifyMessage(new WordModifier("!", "!!", 90, "!", false, 0));
        new DrunkifyMessage(new WordModifier("drunk", "dhrkunn", 70, "are", false, 65));
        new DrunkifyMessage(new WordModifier("walk", "whhealhk", 80, "you can, you can still, you can not", false, 30));
        new DrunkifyMessage(new WordModifier("wtf", "wft", 20, null, null, 40));
        new DrunkifyMessage(new WordModifier("lol", "loool", 80, null, null, 10));
        new DrunkifyMessage(new WordModifier("afk", "aafkayyy", 30, null, null, 30));
        new DrunkifyMessage(new WordModifier("write", "wreitt", 80, "you can,you can still,you can not", false, 50));
        new DrunkifyMessage(new WordModifier("drink", "booze", 80, null, null, 70));
        new DrunkifyMessage(new WordModifier("?", "????", 80, "?", false, 40));
        new DrunkifyMessage(new WordModifier("-space", "", null, "h,g,w", true, 10));
        new DrunkifyMessage(new WordModifier("-space", "", 30, null, null, 35));
        new DrunkifyMessage(new WordModifier("-space", "", 10, null, null, 0));
        new DrunkifyMessage(new WordModifier("-start", "dho", 15, null, null, 50));
        new DrunkifyMessage(new WordModifier("-start", "hhn", 10, null, null, 50));
        new DrunkifyMessage(new WordModifier("-random", "lu", 10, null, null, 0));
        new DrunkifyMessage(new WordModifier("-random", "lug", 10, null, null, 50));
        new DrunkifyMessage(new WordModifier("-random", "blub", 20, null, null, 80));
        new DrunkifyMessage(new WordModifier("-random", "lerg", 40, null, null, 85));
        new DrunkifyMessage(new WordModifier("-random", "gul", 40, null, null, 80));
        new DrunkifyMessage(new WordModifier("-random", " ", 100, null, null, 70));
        new DrunkifyMessage(new WordModifier("-random", " ", 60, null, null, 40));
        new DrunkifyMessage(new WordModifier("-random", " ", 50, null, null, 30));
        new DrunkifyMessage(new WordModifier("-end", "!", 40, null, null, 30));
        new DrunkifyMessage(new WordModifier("-random", " *hic* ", 80, null, null, 70));
        new DrunkifyMessage(new WordModifier("-random", " *hic* ", 15, null, null, 40));
        new DrunkifyMessage(new WordModifier("-space", " *hic* ", 5, null, null, 20));
        new DrunkifyMessage(new WordModifier("-end", " *hic* ", 70, null, null, 50));
        new DrunkifyMessage(new WordModifier("-all", "*burp*", 3, null, null, 60));
        new DrunkifyMessage(new WordModifier("-all", "*burp*", 6, null, null, 80));
    }
}
