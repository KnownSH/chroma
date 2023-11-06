package net.knsh.chroma.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// From the BreweryNG plugin by BlueMoonVineyard
// https://github.com/BlueMoonVineyard/BreweryNG/blob/dev/src/com/dre/brewery/DistortChat.java
// Modified for Chroma by KnownSH

public class MessageModifier {
    public static List<MessageModifier> words = new ArrayList<>();

    private String from;
    private String to;
    private String[] pre;
    private Boolean match = false;
    private int alcohol = 1;
    private int percentage = 100;

    public MessageModifier(String replace, String to, Optional<Integer> percentage, Optional<String> pre, Optional<Boolean> match, Optional<Integer> alcohol) {
        this.from = replace;
        this.to = to;

        if (pre.isPresent()) {
            String fullPre = pre.toString();
            this.pre = fullPre.split(",");
        }

        match.ifPresent(bool -> this.match = bool);
        alcohol.ifPresent(integer -> this.alcohol = integer);
        percentage.ifPresent(integer -> this.percentage = integer);

        if (this.from != null && this.to != null) {
            words.add(this);
        }
    }

    public static String alterString(String message, int drunkenness) {
        if (message.length() > 1) {
            List<MessageModifier> words = MessageModifier.words;
            for (MessageModifier word : words) {
                if (word.alcohol <= drunkenness) {
                    message = word.distort(message);
                }
            }
        }
        return message;
    }

    public String distort(String words) {
        String from = this.from;
        String to = this.to;

        if (from.equalsIgnoreCase("-end")) {
            from = words;
            to = words + to;
        } else if (from.equalsIgnoreCase("-start")) {
            from = words;
            to = to + words;
        } else if (from.equalsIgnoreCase("-all")) {
            from = words;
        } else if (from.equalsIgnoreCase("-space")) {
            from = " ";
        } else if (from.equalsIgnoreCase("-random")) {
            // inserts "to" on a random position in "words"
            int charIndex = (int) (Math.random() * (words.length() - 1));
            if (charIndex < words.length() / 2) {
                from = words.substring(charIndex);
                to = to + from;
            } else {
                from = words.substring(0, charIndex);
                to = from + to;
            }
        }

        if (words.contains(from)) {
            // some characters (*,?) disturb split() which then throws
            // PatternSyntaxException
            try {
                if (pre == null && percentage == 100) {
                    // All occurences of "from" need to be replaced
                    return words.replaceAll(from, to);
                }
                StringBuilder newWords = new StringBuilder();
                if (words.endsWith(from)) {
                    // add space to end to recognize last occurence of "from"
                    words = words + " ";
                }
                // remove all "from" and split "words" there
                String[] splitted = words.split(java.util.regex.Pattern.quote(from));
                int index = 0;
                String part;

                // if there are occurences of "from"
                if (splitted.length > 1) {
                    // - 1 because dont add "to" to the end of last part
                    while (index < splitted.length - 1) {
                        part = splitted[index];
                        // add current part of "words" to the output
                        newWords.append(part);
                        // check if the part ends with correct string

                        if (doesPreMatch(part) && Math.random() * 100.0 <= percentage) {
                            // add replacement
                            newWords.append(to);
                        } else {
                            // add original
                            newWords.append(from);
                        }
                        index++;
                    }
                    // add the last part to finish the sentence
                    part = splitted[index];
                    if (part.equals(" ")) {
                        // dont add the space to the end
                        return newWords.toString();
                    } else {
                        return newWords.append(part).toString();
                    }
                }
            } catch (java.util.regex.PatternSyntaxException e) {
                // e.printStackTrace();
                return words;
            }
        }
        return words;
    }

    public boolean doesPreMatch(String part) {
        boolean isBefore = !match;
        if (pre != null) {
            for (String pr : pre) {
                if (part.endsWith(pr)) {
                    // If a match is wanted set isBefore to true, else to false
                    isBefore = match;
                    break;
                }
            }
        } else {
            isBefore = true;
        }
        return isBefore;
    }
}
