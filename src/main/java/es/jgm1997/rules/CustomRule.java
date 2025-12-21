package es.jgm1997.rules;

public non-sealed abstract class CustomRule implements Rule {
    private final String ruleName;

    public CustomRule(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }
}
