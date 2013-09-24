package controllers;

import com.google.inject.Inject;
import play.*;
import play.mvc.*;

import services.GreetingService;
import views.html.*;

public class Application extends Controller {

    @Inject
    private GreetingService greetingService;

    public Result index() {
        return ok(index.render(greetingService.greeting()));
    }

}
