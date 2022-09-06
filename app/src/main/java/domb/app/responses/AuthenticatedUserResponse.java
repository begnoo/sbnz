package domb.app.responses;

public class AuthenticatedUserResponse {
    private String jwt;
    private int expiresIn;

    public AuthenticatedUserResponse(String jwt, int expiresIn) {
        this.jwt = jwt;
        this.expiresIn = expiresIn;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getExpiredIn() {
        return expiresIn;
    }

    public void setExpiredIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
