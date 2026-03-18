import java.util.Map;
import java.util.HashMap;

public class DialingCodes {
    private Map<Integer, String> codes;

    public DialingCodes() {
        codes = new HashMap<>();
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(codes.containsKey(code) || codes.containsValue(country)) return;
        codes.put(code, country);
    }

    public Integer findDialingCode(String country) {
        Integer code = null;
        for(var entry : codes.entrySet()) {
            if(entry.getValue().equals(country)) {
                code = entry.getKey();
                break;
            }
        }
        return code;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer old_code = findDialingCode(country);
        if(code == null) return;

        codes.remove(old_code);
        codes.put(code, country);
    }
}
