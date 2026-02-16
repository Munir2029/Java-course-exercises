//package WörterbuchV1;
//
//public class testChatgpt {
//    public static String guessLanguage(String text) {
//        // إزالة علامات الترقيم
//        text = text.replaceAll("[^A-Za-zÄÖÜäöüß ]", "");
//        String[] words = text.split("\\s+");
//
//        int deCount = 0;
//        int enCount = 0;
//
//        for (String word : words) {
//            // نحاول مقارنة الكلمات كما هي وكذلك بصيغة lowercase
//            String lowerWord = word.toLowerCase();
//
//            if (worterbuchDE.containsKey(word) || worterbuchDE.containsKey(lowerWord)) {
//                deCount++;
//            }
//            if (dictionaryED.containsKey(word) || dictionaryED.containsKey(lowerWord)) {
//                enCount++;
//            }
//        }
//
//        if (deCount == 0 && enCount == 0) {
//            return "unknown";
//        } else if (deCount > enCount) {
//            return "de";
//        } else {
//            return "en";
//        }
//    }
//
//}
