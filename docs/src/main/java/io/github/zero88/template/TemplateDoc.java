package io.github.zero88.template;

import io.vertx.docgen.Source;

@Source
public class TemplateDoc {

    public void basic(TemplateApi api) {
        api.sum(5, 6);              // <1>
    }

}
