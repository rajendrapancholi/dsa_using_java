public class CeaserCipher{
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int rotation ){
        for(int k=0; k<26; k++){
            encoder[k] = (char)('A' + (k+rotation)%26);
            decoder[k] = (char)('A' + (k-rotation + 26)%26);
        }
    }
    public String encrypt(String message){
            return transform(message, encoder);
    }
    private String transform(String original, char[] code){
        char[] msg = original.toCharArray();
        for(int k=0; k<msg.length; k++){
            if(Character.isUpperCase(msg[k])){
                int j = msg[k]-'A';
                msg[k] = code[j];
            }
            return new String(msg);
        }
    }
    public static void main(String[] args){
        // code here
    }
}