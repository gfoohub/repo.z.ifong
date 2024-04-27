import java.util.*;

public class Psychiatrist {

    private String question;
    private String reply;
    private Random randomValue = new Random();

    public void putQuestion(String q) {
        question = " " + q + " ";
    }

    public String getReply() {
        int variation = randomValue.nextInt(3);
        switch (variation) {
        case 0: 
            reply = transformQuestion(); 
            break;
        case 1: 
            reply = "Why do you feel that?"; 
            break;
        case 2: 
            reply = "please be frank!"; 
            break;
        }
        return reply;
    }

    private String transformQuestion() {
        if (question.indexOf(" I ") >= 0) {
            String tempReply = replace (question,
                                        " I ", " you ");
            tempReply = replace(tempReply,
                                " am ", " are ");
            return replace(tempReply, " my "," your ") + 
                           "-why?";
        }
        else
            if (question.indexOf(" no ") >= 0)
                return "no? that is negative! Please explain...";
            else
                return "\"" + question + "\"-Please re-phrase..";
    }

    private String replace(String original, String from,
                           String to) {
        String leftBit, rightBit;
        int startSearch = 0;
        int place = original.indexOf(from);
        if (from.length() != 0) {
            while (place >= startSearch) {
                leftBit = original.substring(0, place);
                rightBit = original.substring(place + 
                           from.length(), original.length());
                original = leftBit + to + rightBit;
                startSearch = leftBit.length() + to.length();
                place = original.indexOf(from);
            }
        }
        return original;
    }
}
