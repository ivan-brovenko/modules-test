package org.folio.rest.jaxrs.resource;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Handler;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.folio.rest.annotations.Validate;
import org.folio.rest.jaxrs.model.Message;
import org.folio.rest.jaxrs.resource.support.ResponseDelegate;

@Path("/message1")
public interface Message1 {
  /**
   * Get message
   * @param asyncResultHandler An AsyncResult<Response> Handler  {@link Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
   * @param vertxContext
   *  The Vertx Context Object <code>io.vertx.core.Context</code> 
   * @param okapiHeaders
   *  Case insensitive map of x-okapi-* headers passed in as part of the request <code>java.util.Map<String, String></code>  */
  @GET
  @Produces("application/json")
  @Validate
  void getMessage1(Map<String, String> okapiHeaders, Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext);

  class GetMessage1Response extends ResponseDelegate {
    private GetMessage1Response(Response response, Object entity) {
      super(response, entity);
    }

    private GetMessage1Response(Response response) {
      super(response);
    }

    public static GetMessage1Response respond200WithApplicationJson(Message entity) {
      Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
      responseBuilder.entity(entity);
      return new GetMessage1Response(responseBuilder.build(), entity);
    }

    public static GetMessage1Response respond400WithApplicationJson(String entity) {
      Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "application/json");
      responseBuilder.entity(entity);
      return new GetMessage1Response(responseBuilder.build(), entity);
    }
  }
}
