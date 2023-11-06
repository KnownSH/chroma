package net.knsh.chroma.util;

import java.util.Optional;

public class DrunkifyMessage extends MessageModifier {
    public DrunkifyMessage(String replace, String to, Optional<Integer> percentage, Optional<String> pre, Optional<Boolean> match, Optional<Integer> alcohol) {
        super(replace, to, percentage, pre, match, alcohol);
    }

    public static void createDrunkWords() {
        new DrunkifyMessage("s", "sh", Optional.of(90), Optional.empty(), Optional.empty(), Optional.of(30));
        new DrunkifyMessage("ch", "sh", Optional.of(90), Optional.of("u,s,o,a"), Optional.of(false), Optional.of(10));
        new DrunkifyMessage("h", "hh", Optional.of(60), Optional.of("sch,h,t"), Optional.of(false), Optional.of(20));
        new DrunkifyMessage("th", "thl", Optional.of(40), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("sch", "shk", Optional.of(60), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("u", "uuh", Optional.of(20), Optional.empty(), Optional.empty(), Optional.empty());
        new DrunkifyMessage("y", "yy", Optional.of(60), Optional.empty(), Optional.empty(), Optional.of(15));
        new DrunkifyMessage("e", "ee", Optional.of(40), Optional.empty(), Optional.empty(), Optional.of(15));
        new DrunkifyMessage("you", "u", Optional.of(40), Optional.empty(), Optional.empty(), Optional.empty());
        new DrunkifyMessage("u", "uo", Optional.of(60), Optional.of("u"), Optional.of(false), Optional.empty());
        new DrunkifyMessage("that", "taht", Optional.of(20), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("p", "b", Optional.of(30), Optional.empty(), Optional.empty(), Optional.empty());
        new DrunkifyMessage("p", "b", Optional.of(70), Optional.empty(), Optional.empty(), Optional.of(60));
        new DrunkifyMessage("up", "ubb", Optional.of(80), Optional.empty(), Optional.empty(), Optional.of(25));
        new DrunkifyMessage("o", "oh", Optional.of(20), Optional.empty(), Optional.empty(), Optional.empty());
        new DrunkifyMessage("ei", "i", Optional.of(30), Optional.empty(), Optional.empty(), Optional.of(15));
        new DrunkifyMessage("b", "bb", Optional.of(80), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("!!!", "!!!111!!!eleven!1!", Optional.of(20), Optional.of("!"), Optional.of(false), Optional.of(70));
        new DrunkifyMessage("!", "!!", Optional.of(90), Optional.of("!"), Optional.of(false), Optional.empty());
        new DrunkifyMessage("drunk", "dhrkunn", Optional.of(70), Optional.of("are"), Optional.of(false), Optional.of(65));
        new DrunkifyMessage("walk", "whhealhk", Optional.of(80), Optional.of("you can, you can still, you can not"), Optional.of(false), Optional.of(30));
        new DrunkifyMessage("wtf", "wft", Optional.of(20), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("lol", "loool", Optional.of(80), Optional.empty(), Optional.empty(), Optional.of(10));
        new DrunkifyMessage("afk", "aafkayyy", Optional.of(30), Optional.empty(), Optional.empty(), Optional.of(30));
        new DrunkifyMessage("write", "wreitt", Optional.of(80), Optional.of("you can,you can still,you can not"), Optional.of(false), Optional.of(50));
        new DrunkifyMessage("drink", "booze", Optional.of(80), Optional.empty(), Optional.empty(), Optional.of(70));
        new DrunkifyMessage("?", "????", Optional.of(80), Optional.of("?"), Optional.of(false), Optional.of(40));
        new DrunkifyMessage("-space", "", Optional.empty(), Optional.of("h,g,w"), Optional.of(true), Optional.of(10));
        new DrunkifyMessage("-space", "", Optional.of(30), Optional.empty(), Optional.empty(), Optional.of(35));
        new DrunkifyMessage("-space", "", Optional.of(10), Optional.empty(), Optional.empty(), Optional.empty());
        new DrunkifyMessage("-start", "dho", Optional.of(15), Optional.empty(), Optional.empty(), Optional.of(50));
        new DrunkifyMessage("-start", "hhn", Optional.of(10), Optional.empty(), Optional.empty(), Optional.of(50));
        new DrunkifyMessage("-random", "lu", Optional.of(10), Optional.empty(), Optional.empty(), Optional.empty());
        new DrunkifyMessage("-random", "lug", Optional.of(10), Optional.empty(), Optional.empty(), Optional.of(50));
        new DrunkifyMessage("-random", "blub", Optional.of(20), Optional.empty(), Optional.empty(), Optional.of(80));
        new DrunkifyMessage("-random", "lerg", Optional.of(40), Optional.empty(), Optional.empty(), Optional.of(85));
        new DrunkifyMessage("-random", "gul", Optional.of(40), Optional.empty(), Optional.empty(), Optional.of(80));
        new DrunkifyMessage("-random", " ", Optional.of(100), Optional.empty(), Optional.empty(), Optional.of(70));
        new DrunkifyMessage("-random", " ", Optional.of(60), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("-random", " ", Optional.of(50), Optional.empty(), Optional.empty(), Optional.of(30));
        new DrunkifyMessage("-end", "!", Optional.of(40), Optional.empty(), Optional.empty(), Optional.of(30));
        new DrunkifyMessage("-random", " *hic* ", Optional.of(80), Optional.empty(), Optional.empty(), Optional.of(70));
        new DrunkifyMessage("-random", " *hic* ", Optional.of(15), Optional.empty(), Optional.empty(), Optional.of(40));
        new DrunkifyMessage("-space", " *hic* ", Optional.of(5), Optional.empty(), Optional.empty(), Optional.of(20));
        new DrunkifyMessage("-end", " *hic* ", Optional.of(70), Optional.empty(), Optional.empty(), Optional.of(50));
        new DrunkifyMessage("-all", "*burp*", Optional.of(3), Optional.empty(), Optional.empty(), Optional.of(60));
        new DrunkifyMessage("-all", "*burp*", Optional.of(6), Optional.empty(), Optional.empty(), Optional.of(80));
    }
}
