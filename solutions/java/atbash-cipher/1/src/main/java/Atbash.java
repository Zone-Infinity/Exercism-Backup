class Atbash {

    String encode(String input) {
        input = input.toLowerCase();
        StringBuilder cipher = new StringBuilder();

        int count = 0;
        for(char c : input.toCharArray()) {
            if(!Character.isLetterOrDigit(c)) continue;
            
            if(Character.isDigit(c))
                cipher.append(c);
            else
                cipher.append((char)('z' - c + 'a'));

            if(++count % 5 == 0) cipher.append(' ');
        }

        return cipher.toString().trim();
    }

    String decode(String input) {
        StringBuilder msg = new StringBuilder();

        for(char c : input.toCharArray()) {
            if(c == ' ') continue;
            if(Character.isDigit(c))
                msg.append(c);
            else
                msg.append((char)('z' - c + 'a'));
        }

        return msg.toString();
    }

}
