package helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HelperBase {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public HelperBase(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;
        this.response = response;
    }
}
