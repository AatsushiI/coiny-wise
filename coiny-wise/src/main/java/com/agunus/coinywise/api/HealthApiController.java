package com.agunus.coinywise.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.agunus.coinywise.model.GetHealthResponse.StatusEnum;
import com.agunus.coinywise.model.GetHealthResponse;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-09T07:04:38.204816Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.coinyWise.base-path:}")
public class HealthApiController implements HealthApi {

    private final NativeWebRequest request;

    @Autowired
    public HealthApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<GetHealthResponse> healthGet() {
        GetHealthResponse response = new GetHealthResponse();
				response.setStatus(StatusEnum.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
