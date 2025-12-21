package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

public final class ForbiddenUserRule extends CustomRule {
    private final String forbiddenUsername;

    public ForbiddenUserRule(String forbiddenUsername) {
        super("Forbidden User");
        this.forbiddenUsername = forbiddenUsername;
    }

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        return !booking.createdBy().equalsIgnoreCase(forbiddenUsername);
    }

    public String getForbiddenUsername() {
        return forbiddenUsername;
    }
}
