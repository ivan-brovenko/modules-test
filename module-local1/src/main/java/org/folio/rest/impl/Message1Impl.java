package org.folio.rest.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import org.folio.rest.jaxrs.model.Message;
import org.folio.rest.jaxrs.resource.Message1;

import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Message1Impl implements Message1 {
  @Override
  public void getMessage1(Map<String, String> okapiHeaders, Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    Message message = new Message();
    message.setMessage("ok");
    CompletableFuture.completedFuture(null)
      .thenAccept(isValid -> asyncResultHandler.handle(Future.succeededFuture(Message1.GetMessage1Response.respond200WithApplicationJson(message))))
      .exceptionally(e -> {
        asyncResultHandler.handle(Future.succeededFuture(
          Message1.GetMessage1Response.respond400WithApplicationJson("Bad request")));
        return null;
      });
  }
}
