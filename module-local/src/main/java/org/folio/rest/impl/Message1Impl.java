package org.folio.rest.impl;

import io.vertx.core.*;
import org.folio.rest.jaxrs.model.Message;
import org.folio.rest.tools.client.HttpClientFactory;
import org.folio.rest.tools.client.interfaces.HttpClientInterface;

import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Message1Impl implements org.folio.rest.jaxrs.resource.Message {
  @Override
  public void getMessage(Map<String, String> okapiHeaders, Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    HttpClientInterface client = HttpClientFactory.getHttpClient("localhost", 9130, "diku");
    try {
      CompletableFuture<org.folio.rest.tools.client.Response> completableFuture = client.request("/message1", okapiHeaders);
      completableFuture.whenComplete((response, throwable) -> {
        Message message = new Message();
        message.setMessage(response.getBody().encode());
          completableFuture.thenAccept(isValid -> asyncResultHandler.handle(
            Future.succeededFuture(org.folio.rest.jaxrs.resource.Message.GetMessageResponse.respond200WithApplicationVndApiJson(message))
            )
          );
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
