public class Encrypt {
    public static char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encrypt(String encrypt){
        char[] word = encrypt.toCharArray();
        StringBuilder fullWord = new StringBuilder();

        for(int placement = 0; placement<word.length; placement++) {
            StringBuilder placementCombo = new StringBuilder();
            StringBuilder letterCombo = new StringBuilder();
            int addZ = placement;
            if (placement > 25) {
                do {
                    placementCombo.append(abc[25]);
                    addZ = addZ % 25;
                } while (addZ > 25);
            }
            placementCombo.append(abc[addZ]);
            char letter = word[addZ];

            for (int alphabet = 0; alphabet < abc.length; alphabet++) {
                if (letter == abc[alphabet]) {
                    int result = placement + alphabet;
                    if (result > 25) {
                        do {
                            letterCombo.append(abc[25]);
                            result = result % 25;
                        } while (result > 25);
                    }
                    letterCombo.append(abc[result]);
                    fullWord.append(letterCombo.toString() + ":" + placementCombo.toString()+" ");
                }
            }
        }
        return fullWord.toString();
    }

    public static String decrypt(String decrypt){
        StringBuilder decrypted = new StringBuilder();
        String[] spl = (decrypt).split(" ");
        for(int placement = 0; placement<spl.length; placement++){
            String[] spl2 = (spl[placement]).split(":");
            int placementNumber = 0;
            int letterNumber = 0;
            for(int alpha = 0; alpha<abc.length; alpha++){
                char place = spl2[1].toCharArray()[0];
                if(place==abc[alpha]){
                    placementNumber = alpha;
                }
            }
            char[] place = spl2[0].toCharArray();
            if(place.length>0){
                for(int x = 0; x<place.length; x++){
                    for(int alpha = 0; alpha<abc.length; alpha++){
                        if(place[x]==abc[alpha]){
                            letterNumber = letterNumber+alpha;
                        }
                    }
                }
            } else {
                for (int alpha = 0; alpha < abc.length; alpha++) {
                    if (place[0] == abc[alpha]) {
                        letterNumber = alpha;
                    }
                }
            }
            int letter = letterNumber-placementNumber;
            decrypted.append(abc[letter]);
        }
        return decrypted.toString();
    }
}
