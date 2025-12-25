package es.jgm1997.sprint1.rules;

public abstract non-sealed class CustomRule implements Rule {
    private final String ruleName;

    CustomRule(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }
}
