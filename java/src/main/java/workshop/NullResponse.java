package workshop;

public class NullResponse implements PatternMatcher {
    @Override
    public boolean matches(int number) {
        return false;
    }

    @Override
    public String generateRresponse() {
        return "";
    }
    
}
